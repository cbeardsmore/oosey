/***************************************************************************
*	FILE: RevenueEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: RevenueEvent model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;
import simulator.controller.*;

public class RevenueEvent extends Event
{
    public RevenueEvent()
    {
        super();
    }

//---------------------------------------------------------------------------
    //IMPORT: inYear (int), inIncrease (boolean), inAff (BusinessUnit)
    //PURPOSE: initialise fields to imported values

    public RevenueEvent( int inYear, boolean inIncrease, BusinessUnit inAff )
    {
        super( inYear, inIncrease, inAff );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Perform the Event, updating revenue

    public void run( Controller control )
    {
        BusinessUnit affected = (BusinessUnit)super.getAffected();
        if ( super.isIncrease() )
            affected.setRevenue( affected.getRevenue() * ( 1.00 + VALUE_CHANGE ) );
        else
            affected.setRevenue( affected.getRevenue() * ( 1.00 - VALUE_CHANGE ) );

    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Revenue" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
