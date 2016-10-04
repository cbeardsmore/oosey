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

public class RevenueEvent extends Event
{
    //CLASSFIELDS
    Property affected;

//---------------------------------------------------------------------------
    //IMPORT: inYear (int), inIncrease (boolean), inAff (BusinessUnit)
    //PURPOSE: initialise fields to imported values

    public RevenueEvent( int inYear, boolean inIncrease, Property inAff )
    {
        super( inYear, inIncrease );
        affected = inAff;
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Revenue" + "\n";
        state += "AFFECTED: " + affected.getName() + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
