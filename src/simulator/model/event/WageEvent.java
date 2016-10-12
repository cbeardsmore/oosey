/***************************************************************************
*	FILE: WageEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: WageEvent model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.controller.*;

public class WageEvent extends Event
{
    public WageEvent()
    {
        super();
    }

//---------------------------------------------------------------------------

    public WageEvent( int inYear, boolean inIncrease )
    {
        //WageEvent currently doesn't apply to any specific BusinessUnit
        //Leave as null, in case we have specific WageEvents later
        super( inYear, inIncrease, null );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Perform the Event, updating wages

    public void run( Controller control )
    {
        control.notifyWages( super.isIncrease() );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Wage" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
