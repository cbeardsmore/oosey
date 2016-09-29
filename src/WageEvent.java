/***************************************************************************
*	FILE: WageEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: WageEvent model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/

public class WageEvent extends Event
{
    public WageEvent( int inYear, boolean inIncrease )
    {
        super( inYear, inIncrease );
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
