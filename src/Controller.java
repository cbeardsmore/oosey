/***************************************************************************
*	FILE: Controller.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main storage and controller for all objects in the system
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller
{
    //CLASSFIELDS
    private Map<String,Property> propMap;
    private List<Event> eventList;
    private List<Plan> planList;

//---------------------------------------------------------------------------
    //PURPOSE: initialise property map as a HashMap

    public Controller()
    {
        propMap = new HashMap<String,Property>();
        eventList = new ArrayList<Event>();
        planList = new ArrayList<Plan>();
    }

//---------------------------------------------------------------------------
    //NAME: setProperty()
    //IMPORT: name (String), prop (Property)
    //PURPOSE: add property and key into the property map

    public void setProperty(String name, Property prop)
    {
        propMap.put( name, prop );
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
    //NAME: toString()
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
         // PRINT ALL PROPERTIES
        String state = "PROPERTY MAP CONTENTS\n";
        state += "---------------------\n";

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

        return state;
    }

//---------------------------------------------------------------------------
}
