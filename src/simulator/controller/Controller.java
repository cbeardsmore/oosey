/***************************************************************************
*	FILE: Controller.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main storage and controller for all objects in the system
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import simulator.view.*;

public class Controller
{
    //CLASSFIELDS
    private PropertyController propCon;
    private EventController eventCon;
    private PlanController planCon;
    private PrimaryView view;
    private int currentYear;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public Controller( PrimaryView inView, PropertyController pc,
                        EventController ec, PlanController pc2 )
    {
        propCon = pc;
        eventCon = ec;
        planCon = pc2;
        view = inView;
        currentYear = 0;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public PropertyController getPropCon() { return propCon; }
    public EventController getEventCon() { return eventCon; }
    public PlanController getPlanCon() { return planCon; }
    public int getYear() { return currentYear; }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: start (int), end (int)
    //PURPOSE: Run simulation, outputting via view and doing events + plans

    public void run( int start, int end )
    {
        // Run from start to end year inclusively
        for ( int ii = start; ii <= end; ii++ )
        {
            // Step 1: Events take place for that year
            eventCon.performEvents( this, ii );

            // Step 2: Perform Buy/Sell Plans for that year
            planCon.performPlans( this, ii );

            // Step 3: Update profits of companies Bank Accounts
            // Step 4: Update interest of all companies after
            propCon.performProfit();

            // Step 4: Output at the end of year + interest for the previous year
            view.companyOutput( ii+1, propCon );
        }
    }

//---------------------------------------------------------------------------
    //NAME: toString()
    //EXPORT: state (String)
    //PURPOSE: Export state via the controllers toString() methods

    public String toString()
    {
         // PRINT ALL PROPERTIES
        String state = "MAIN CONTROLLER:";
        state += "----------------";

        state += propCon.toString();
        state += eventCon.toString();
        state += planCon.toString();
        state += "CURRENT YEAR: " + currentYear + "\n";

        return state;
    }

//---------------------------------------------------------------------------
}
