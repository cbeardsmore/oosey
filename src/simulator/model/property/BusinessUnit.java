/***************************************************************************
*	FILE: BusinessUnit.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public class BusinessUnit extends Property implements WageObserver
{
    //CLASSFIELDS
    private int revenue;
    private int wages;

//---------------------------------------------------------------------------
    //IMPORT: inRevenue (int), inWages (int)
    //PURPOSE: Initialise classfields to imported values

    public BusinessUnit( int inRevenue, int inWages )
    {
        super();
        revenue = inRevenue;
        wages = inWages;
    }
//---------------------------------------------------------------------------
    //Setters

    public void setRevenue( int inRevenue ) { revenue = inRevenue; }
    public void setWages( int inWages ) { wages = inWages; }

//---------------------------------------------------------------------------
    //Getters

    public int getRevenue() { return revenue; }
    public int getWages()   { return wages; }

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
    //NAME: calcProfit()
    //PURPOSE: Calculate Bank account profit for the year

    public void calcProfit()
    {
        super.setProfit( revenue - wages );
    }

//---------------------------------------------------------------------------
    //NAME: updateWage()
    //IMPORT: isIncrease (boolean)
    //PURPOSE: Update wages based on an occuring wage event

    public void updateWage( boolean isIncrease )
    {
        if ( isIncrease )
            wages = (int)(1.05 * (double)wages);
        else
            wages = (int)(0.95 * (double)wages);
    }

//---------------------------------------------------------------------------
}
