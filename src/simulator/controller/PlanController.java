/***************************************************************************
*	FILE: PlanController.java
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
import simulator.model.plan.*;

public class PlanController
{
    //CLASSFIELDS
    private List<Plan> planList;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public PlanController()
    {
        planList = new ArrayList<Plan>();
    }

//---------------------------------------------------------------------------
    //NAME: setPlan()
    //IMPORT: inplan (plan)
    //PURPOSE: add plan into planList

    public void setPlan( Plan inplan )
    {
        planList.add( inplan );
    }

//---------------------------------------------------------------------------
    //NAME: getplans()
    //EXPORT: iterator over the planList (Iterator<plan>)
    //PURPOSE: Get iterator for the planList

    public Iterator<Plan> getPlans()
    {
        return planList.iterator();
    }

//---------------------------------------------------------------------------
    //NAME: currentplanYear()
    //EXPORT: year (int)
    //PURPOSE: Get current year in the list, to validate file format

    public int currentPlanYear()
    {
        // Get last plan in the list
        int year = 0;
        Plan lastPlan = null;
        int size = planList.size();

        if ( size != 0 )
        {
            lastPlan = planList.get( size - 1 );
            year = lastPlan.getYear();
        }
        // Return the year of this plan
        return year;
    }

//---------------------------------------------------------------------------
    //NAME: performplans()
    //IMPORT: year (int)
    //PURPOSE: Perform all plans in the given year

    public void performPlans( Controller control, int year )
    {
        // For each plan for this year, call run
        // Inefficient, could user Iterators instead to maintain state
        for ( Plan next : planList )
            if ( next.getYear() == year )
                next.run( control );
    }

//---------------------------------------------------------------------------
}
