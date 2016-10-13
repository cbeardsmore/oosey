/***************************************************************************
*	FILE: Controller.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main storage and controller for all objects in the system
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import simulator.model.property.*;
import simulator.model.event.*;
import simulator.model.plan.*;
import simulator.view.*;

public class Controller
{
    //CLASSFIELDS
    private Map<String,Property> propMap;
    private Company primary;
    private List<Event> eventList;
    private List<Plan> planList;
    private List<WageObserver> observers;
    private int currentYear;
    private PrimaryView view;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public Controller( PrimaryView inView )
    {
        propMap = new HashMap<String,Property>();
        eventList = new ArrayList<Event>();
        planList = new ArrayList<Plan>();
        observers = new ArrayList<WageObserver>();
        view = inView;
        primary = null;
        currentYear = 0;
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: start (int), end (int)
    //PURPOSE: Run simulation, outputting via view and doing events + plans

    public void run( int start, int end )
    {
        for ( int ii = start; ii <= end; ii++ )
        {
            // Step 1: Update profits of companies Bank Accounts
            if ( ii == start )
            {
                for ( Map.Entry<String,Property> entry : propMap.entrySet() )
                {
                    Property next = entry.getValue();
                    // Only update profit if not null
                    if ( ( next != null ) && ( next instanceof Company ) )
                        next.calcProfit();
                }
            }

            // Step 2: Output Company Information
            view.companyOutput( ii, propMap );
            //view.debugOutput( ii, propMap );

            // Step 3: Events take place for that year
            performEvents( ii );

            // Step 4: Perform Buy/Sell Plans for that year
            performPlans( ii );
        }
    }

//---------------------------------------------------------------------------
    //NAME: setProperty()
    //IMPORT: name (String), prop (Property)
    //PURPOSE: add property and key into the property map

    public void setProperty(String name, Property prop)
    {
        propMap.put( name, prop );
        if ( ( primary == null ) && ( prop instanceof Company ) )
            primary = (Company)prop;
        if ( prop instanceof WageObserver )
            attach( (WageObserver)prop );
    }

//---------------------------------------------------------------------------
    //NAME: getProperty()
    //IMPORT: name (String)
    //EXPORT: property with specified key (Property)
    //PURPOSE: Get property with given name from property map

    public Property getProperty(String name)
    {
        return propMap.get(name);
    }

//---------------------------------------------------------------------------
    //NAME: getPrimary()
    //EXPORT: primary (Company)

    public Company getPrimary()
    {
        return primary;
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
    //NAME: setPlan()
    //IMPORT: inPlan (Plan)
    //PURPOSE: add plan into PlanList

    public void setPlan( Plan inPlan )
    {
        planList.add( inPlan );
    }

//---------------------------------------------------------------------------
    //NAME: getPlans()
    //EXPORT: iterator over the planList (Iterator<Plan>)
    //PURPOSE: Get iterator for the planList

    public Iterator<Plan> getPlans()
    {
        return planList.iterator();
    }

//---------------------------------------------------------------------------
    //NAME: getObs()
    //EXPORT: iterator over the observer list
    //PURPOSE: Get iterator for the observer list

    public Iterator<WageObserver> getObs()
    {
        return observers.iterator();
    }

//---------------------------------------------------------------------------
    //NAME: attach()
    //IMPORT: observer (WageObserver)
    //PURPOSE: Add new observer to the observer list

    public void attach( WageObserver observer )
    {
        observers.add( observer );
    }

//---------------------------------------------------------------------------
    //NAME: notifyWages()
    //PURPOSE: Call update on all observers in observer list

    public void notifyWages( boolean isIncrease )
    {
        for (WageObserver observer : observers)
            observer.updateWage( isIncrease );
    }

//---------------------------------------------------------------------------
    //NAME: currentEventYear()
    //EXPORT: year (int)
    //PURPOSE: Get current year in the list, to validate file format

    public int currentEventYear()
    {
        // Get last event in the list
        Event lastEvent = eventList.get( eventList.size() );
        // Return the year of this event
        return lastEvent.getYear();
    }

//---------------------------------------------------------------------------
    //NAME: currentPlanYear()
    //EXPORT: year (int)
    //PURPOSE: Get current year in the list, to validate file format

    public int currentPlanYear()
    {
        // Get last pla n in the list
        Plan lastPlan = planList.get( planList.size() );
        // Return the year of this plan
        return lastPlan.getYear();
    }

//---------------------------------------------------------------------------
    //NAME: performEvents()
    //IMPORT: year (int)
    //PURPOSE: Perform all events in the given year

    public void performEvents( int year )
    {
        for ( Event next : eventList )
        {
            if ( next.getYear() == year )
                next.run( this );
        }
    }

//---------------------------------------------------------------------------
    //NAME: performPlans()
    //IMPORT: year (int)
    //PURPOSE: Perform all plans in the given year

    public void performPlans( int year )
    {
        for ( Plan next : planList )
        {
            if ( next.getYear() == year )
                next.run( this );
        }
    }

//---------------------------------------------------------------------------
    //NAME: toString()
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
         // PRINT ALL PROPERTIES
        String state = "PROPERTY MAP CONTENTS\n";
        state += "---------------------\n";

        // Print primary Company name
        state += ": " + primary.getName() + "\n\n";

        // iterate over all values in the property hashmap
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            // only print if the value isn't null
            if ( entry.getValue() != null )
                state += entry.getValue().toString() + "\n" ;
        }

        // PRINT ALL EVENTS
        state += "\nEVENT LIST CONTENTS\n";
        state += "-------------------\n";
        Iterator<Event> eventIter = getEvents();
        while ( eventIter.hasNext() )
        {
            state += eventIter.next().toString() + "\n";
        }

        // PRINT ALL PLANS
        state += "\nPLAN LIST CONTENTS\n";
        state += "------------------\n";
        Iterator<Plan> planIter = getPlans();
        while ( planIter.hasNext() )
        {
            state += planIter.next().toString() + "\n";
        }

        // PRINT ALL OBSERVERS
        state += "\nOBSERVER LIST CONTENTS\n";
        state += "------------------\n";
        Iterator<WageObserver> obsIter = getObs();
        while ( obsIter.hasNext() )
        {
            BusinessUnit next = (BusinessUnit)obsIter.next();
            state += next.toString() + "\n";
        }

        return state;
    }

//---------------------------------------------------------------------------
}
