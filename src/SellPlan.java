/***************************************************************************
*	FILE: SellPlan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: SellPlan model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/

public class SellPlan extends Plan
{
    //PURPOSE: initialise Plan with given fields

    public SellPlan( int inYear, Property inProp )
    {
        super( inYear, inProp );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Sell" + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
