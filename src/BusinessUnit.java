/***************************************************************************
*	FILE: BusinessUnit.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/

public class BusinessUnit extends Property
{
    //CLASSFIELDS
    private int revenue;
    private int wages;
//---------------------------------------------------------------------------

    public BusinessUnit( int inRevenue, int inWages )
    {
        super();
        revenue = inRevenue;
        wages = inWages;
    }
//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format
    
    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Business Unit" + "\n";
        state += "REVENUE: " + revenue + "\n";
        state += "WAGES: " + wages + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
