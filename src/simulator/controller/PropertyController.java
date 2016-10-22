/***************************************************************************
*	FILE: PropertyController.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main storage and controller for all objects in the system
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import simulator.model.property.*;

public class PropertyController
{
    //CLASSFIELDS
    private Map<String,Property> propMap;
    private List<WageObserver> observers;
    private Company primary;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public PropertyController()
    {
        propMap = new HashMap<String,Property>();
        observers = new ArrayList<WageObserver>();
        primary = null;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public Map<String,Property> getPropMap() { return propMap; }

//---------------------------------------------------------------------------
    //NAME: performProfit()
    //PURPOSE: Do profit calculations + interest thigns

    public void performProfit()
    {
        // Iterate across entire Map
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            // Only update profit if not null
            if ( ( next != null ) && ( next instanceof Company ) )
                next.calcProfit();
        }
    }

//---------------------------------------------------------------------------
    //NAME: setProperty()
    //IMPORT: name (String), prop (Property)
    //PURPOSE: add property and key into the property map

    public void setProperty(String name, Property prop)
    {
        // Add property to the map
        propMap.put( name, prop );

        // If its the first Company, make it the primary company
        if ( ( primary == null ) && ( prop instanceof Company ) )
            primary = (Company)prop;

        // If its an Observer, add it to the observer list
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
    //NAME: notifyWageInc()
    //PURPOSE: Call update on all observers in observer list

    public void notifyWageInc()
    {
        for (WageObserver observer : observers)
            observer.increaseWages();
    }

//---------------------------------------------------------------------------
    //NAME: notifyWageDec()
    //PURPOSE: Call update on all observers in observer list

    public void notifyWageDec()
    {
        for (WageObserver observer : observers)
            observer.decreaseWages();
    }

//---------------------------------------------------------------------------
}
