/***************************************************************************
*	FILE: Controller.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main storage and controller for all objects in the system
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import simulator.model.event.*;

public class EventController
{
    //CLASSFIELDS
    private List<Event> eventList;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public EventController()
    {
        eventList = new ArrayList<Event>();
    }

//---------------------------------------------------------------------------
    //NAME: setEvent()
    //IMPORT: inEvent (Event)
    //PURPOSE: add event into eventList

    public void setEvent( Event inEvent )
    {
        eventList.add( inEvent );
    }

//---------------------------------------------------------------------------
    //NAME: getEvents()
    //EXPORT: iterator over the eventList (Iterator<Event>)
    //PURPOSE: Get iterator for the eventList

    public Iterator<Event> getEvents()
    {
        return eventList.iterator();
    }

//---------------------------------------------------------------------------
    //NAME: currentEventYear()
    //EXPORT: year (int)
    //PURPOSE: Get current year in the list, to validate file format

    public int currentEventYear()
    {
        // Get last event in the list
        int year = 0;
        Event lastEvent = null;
        if ( eventList.size() != 0 )
        {
            lastEvent = eventList.get( eventList.size() - 1 );
            year = lastEvent.getYear();
        }
        // Return the year of this event
        return year;
    }

//---------------------------------------------------------------------------
    //NAME: performEvents()
    //IMPORT: year (int)
    //PURPOSE: Perform all events in the given year

    public void performEvents( Controller control, int year )
    {
        for ( Event next : eventList )
        {
            if ( next.getYear() == year )
                next.run( control );
        }
    }

//---------------------------------------------------------------------------
}
