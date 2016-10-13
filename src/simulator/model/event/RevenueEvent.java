/***************************************************************************
*	FILE: RevenueEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: RevenueEvent model
*   LAST MOD: 12/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;
import simulator.controller.*;

public class RevenueEvent extends Event
{
//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public RevenueEvent()
    {
        super();
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public RevenueEvent( int inYear, boolean inIncrease, BusinessUnit inAff )
    {
        super( inYear, inIncrease, inAff );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Perform the Event, updating revenue field of affected property

    public void run( Controller control )
    {
        // Downcast as affected is a generic Property, needed to alter revenue
        BusinessUnit affected = (BusinessUnit)super.getAffected();

        // Update the affected units revenue by based on increase/decrease event
        if ( super.isIncrease() )
            affected.updateRevenue( VALUE_CHANGE );
        else
            affected.updateRevenue( -VALUE_CHANGE );
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
