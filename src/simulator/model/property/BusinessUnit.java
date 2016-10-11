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
    private double revenue;
    private double wages;
    public static final double WAGE_CHANGE = 0.05;

//---------------------------------------------------------------------------
    //IMPORT: inRevenue (double), inWages (double)
    //PURPOSE: Initialise classfields to imported values

    public BusinessUnit( double inRevenue, double inWages )
    {
        super();
        revenue = inRevenue;
        wages = inWages;
    }
//---------------------------------------------------------------------------
    //Setters

    public void setRevenue( double inRevenue ) { revenue = inRevenue; }
    public void setWages( double inWages ) { wages = inWages; }

//---------------------------------------------------------------------------
    //Getters

    public double getRevenue() { return revenue; }
    public double getWages()   { return wages; }

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
            wages = ( 1.0 + WAGE_CHANGE ) * wages;
        else
            wages = ( 1.0 - WAGE_CHANGE ) * wages;
    }

//---------------------------------------------------------------------------
}
