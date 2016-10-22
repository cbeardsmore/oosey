/***************************************************************************
*	FILE: WageEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: WageEvent model
*   LAST MOD: 13/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.controller.*;

public class WageEvent extends Event
{

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public WageEvent()
    {
        super();
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public WageEvent( int inYear, boolean inIncrease )
    {
        //WageEvent currently doesn't apply to any specific BusinessUnit
        //Leave as null, in case we have specific WageEvents later
        super( inYear, inIncrease, null );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Perform the Event, updating wages via calling "notify"

    public void run( Controller control )
    {
        PropertyController propCon = control.getPropCon();
        boolean isIncrease = super.isIncrease();
        if ( isIncrease )
            propCon.notifyWageInc();
        else
            propCon.notifyWageDec();
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
