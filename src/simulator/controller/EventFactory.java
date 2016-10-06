/***************************************************************************
*	FILE: EventFactory.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Factory to create Event objects
*   LAST MOD: 28/09/16
*   REQUIRES: Event
***************************************************************************/
package simulator.controller;

import simulator.model.event.*;

public class EventFactory
{
    public EventFactory() {}
//---------------------------------------------------------------------------
    //NAME: createEvent()
    //IMPORT: type (char)
    //EXPORT: newEvent (Event)
    //PURPOSE: Create new event, based on the type char

    public Event createEvent( char type )
    {
        Event newEvent = null;
        if ( type == 'R' )
            newEvent = new RevenueEvent();
        else if ( type == 'V' )
            newEvent = new ValueEvent();
        else if ( type == 'W' )
            newEvent = new WageEvent();
        return newEvent;
    }

//---------------------------------------------------------------------------
}
