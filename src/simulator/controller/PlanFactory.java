/***************************************************************************
*	FILE: PlanFactory.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Factory to create Plan objects
*   LAST MOD: 28/09/16
*   REQUIRES: Plan
***************************************************************************/
package simulator.controller;

import simulator.model.plan.*;

public class PlanFactory
{
//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public PlanFactory() {}
        
//---------------------------------------------------------------------------
    //NAME: createPlan()
    //IMPORT: type (char)
    //EXPORT: newPlan (Plan)
    //PURPOSE: Create new plan, based on the type char

    public Plan createPlan( char type )
    {
        Plan newPlan = null;
        if ( type == 'B' )
            newPlan = new BuyPlan();
        else if ( type == 'S' )
            newPlan = new SellPlan();
        return newPlan;
    }

//---------------------------------------------------------------------------
}
