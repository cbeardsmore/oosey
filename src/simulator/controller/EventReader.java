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

        // Parse year field
        int year = Integer.parseInt( fields[0] );

        // Get property if name is given
        if ( fields.length == 3 )
            affected = control.getProperty( fields[2] );

        // Specify type and create via factory
        char type = fields[1].charAt(0);
        newEvent = factory.createEvent( type );

        // Set year and affected property
        newEvent.setYear( year );
        newEvent.setAffected( affected );

        // Add to event list in controller
        control.setEvent( newEvent );
    }

//---------------------------------------------------------------------------
}
