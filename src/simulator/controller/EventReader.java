/***************************************************************************
*	FILE: EventReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take event fields and process into an event object
*   LAST MOD: 10/10/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import simulator.model.property.*;
import simulator.model.event.*;

public class EventReader extends ReaderTemplate
{
    //CLASSFIELDS
    private EventFactory factory;

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public EventReader( Controller inControl, EventFactory inFactory )
    {
        control = inControl;
        factory = inFactory;
    }
//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields) throws FileFormatException
    {
        EventController eventCon = control.getEventCon();
        Event newEvent;
        Property affected;
        boolean increase;
        int year;
        char type;

        // Check length of fields
        if ( fields.length != 3 )
            throw new FileFormatException("Event File Data Missing");

        // Parse the type of object and construct via the factory
        type = parseType( fields[1] );
        newEvent = factory.createEvent( type );
        if ( newEvent == null )
            throw new FileFormatException("Event Type invalid");

        // Parse the year field and set, relative to the last given year
        year = parseYear( fields[0] );
        newEvent.setYear( year );

        // Parse the increase/decrease type and set the field
        increase = parseIncrease( fields[1] );
        newEvent.setIncrease( increase );

        // Parse the affected property, if one exists
        affected = parseAffected( fields[2] );
        newEvent.setAffected( affected );

        // Add to event list in controller
        eventCon.setEvent( newEvent );
    }

//---------------------------------------------------------------------------
    //NAME: parseYear()
    //IMPORT: yearString (String)
    //EXPORT: year (int)
    //PURPOSE: Parse the year field of the input, checking validity

    public int parseYear( String yearString ) throws FileFormatException
    {
        EventController eventCon = control.getEventCon();
        int year;
        // Parse year field and rethrow as less specific exception
        try
        {
            year = Integer.parseInt( yearString );
            // Ensure event in chronilogical order, sorry Demeter
            if ( year < eventCon.currentEventYear() )
                throw new FileFormatException("Events Not Chronological");
        }
        catch ( NumberFormatException e )
        {
            // Rethrow, NumberFormatException doesn't provide correct info
            throw new FileFormatException("Year in Event file invalid", e);
        }
        return year;
    }

//---------------------------------------------------------------------------
    //NAME: parseType()
    //IMPORT: typeString (String)
    //EXPORT: type (char)
    //PURPOSE: Parse the type field of the input, checking validity

    public char parseType( String typeString) throws FileFormatException
    {
        char type;
        // Specify type
        type = typeString.charAt(0);
        if ( typeString.length() != 2 )
            throw new FileFormatException("Event Type invalid");
        return type;
    }

//---------------------------------------------------------------------------
    //NAME: parseIncrease()
    //IMPORT: incString (String)
    //EXPORT: isIncrease (boolean)
    //PURPOSE: Parse the increase field of the input, checking validity

    public boolean parseIncrease( String incString) throws FileFormatException
    {
        boolean isIncrease;
        // Set increase/decrease type of the event
        if ( incString.charAt(1) == '-' )
            isIncrease = false;
        else if ( incString.charAt(1) == '+' )
            isIncrease = true;
        else
            throw new FileFormatException("Event Type Invalid");
        return isIncrease;
    }

//---------------------------------------------------------------------------
    //NAME: parseType()
    //IMPORT: typeString (String)
    //EXPORT: affected (Property)
    //PURPOSE: Parse the affected field of the input, checking validity

    public Property parseAffected( String affString) throws FileFormatException
    {
        PropertyController propCon = control.getPropCon();
        Property affected = null;
        // Get property if name is given
        if ( affString.length() > 0 )
        {
            affected = propCon.getProperty( affString );
            if ( affected == null )
                throw new FileFormatException("Property in Event does not exist");
        }
        return affected;
    }

//---------------------------------------------------------------------------
}
