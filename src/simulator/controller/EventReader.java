/***************************************************************************
*	FILE: EventReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take event fiels and process into an event object
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import simulator.model.property.*;
import simulator.model.event.*;

public class EventReader extends ReaderTemplate
{
    //CLASSFIELDS
    private EventFactory factory;

    public EventReader( Controller inControl, EventFactory inFactory )
    {
        control = inControl;
        factory = inFactory;
    }
//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields)
    {
        Event newEvent = null;
        Property affected = null;
        boolean increase = false;
        int year;
        char type;

        // Check length of fields
        if ( ( fields.length != 2 ) && ( fields.length != 3 ) )
            throw new IllegalArgumentException("Event File Data Missing");

        // Parse year field and rethrow as less specific exception
        try
        {
            year = Integer.parseInt( fields[0] );
        }
        catch ( NumberFormatException e )
        {
            throw new IllegalArgumentException("Year in Event file invalid");
        }

        // Get property if name is given
        if ( fields.length == 3 )
        {
            affected = control.getProperty( fields[2] );
            if ( affected == null )
                throw new IllegalArgumentException("Property in Event File does not exist");
        }

        // Specify type and create via factory
        type = fields[1].charAt(0);
        if ( fields[1].length() != 2 )
            throw new IllegalArgumentException("Event Type invalid");

        // Get factory to create Event, ensure it created properly
        newEvent = factory.createEvent( type );
        if ( newEvent == null )
            throw new IllegalArgumentException("Event Type invalid");

        // Set increase/decrease type of the event
        if ( fields[1].charAt(1) == '-' )
            newEvent.setIncrease(false);
        else if ( fields[1].charAt(1) == '+' )
            newEvent.setIncrease(true);
        else
            throw new IllegalArgumentException("Event Type Invalid");

        // Set year and affected property
        newEvent.setYear( year );
        newEvent.setAffected( affected );

        // Add to event list in controller
        control.setEvent( newEvent );
    }

//---------------------------------------------------------------------------
}
