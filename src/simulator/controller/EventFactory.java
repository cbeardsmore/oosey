/***************************************************************************
*	FILE: EventFactory.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Factory to create Event objects
*   LAST MOD: 15/10/16
*   REQUIRES: Event
***************************************************************************/
package simulator.controller;

import simulator.model.event.*;

public class EventFactory
{
    // CONSTANTS
    public static final char REVENUE = 'R';
    public static final char VALUE = 'V';
    public static final char WAGE = 'W';

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public EventFactory() {}

//---------------------------------------------------------------------------
    //NAME: createEvent()
    //IMPORT: type (char)
    //EXPORT: newEvent (Event)
    //PURPOSE: Create new event, based on the type char

    public Event createEvent( char type )
    {
        Event newEvent = null;
        if ( type == REVENUE )
            newEvent = new RevenueEvent();
        else if ( type == VALUE )
            newEvent = new ValueEvent();
        else if ( type == WAGE )
            newEvent = new WageEvent();
        return newEvent;
    }

//---------------------------------------------------------------------------
}
