/***************************************************************************
*	FILE: BusinessUnit.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 11/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

import simulator.model.event.*;

public class BusinessUnit extends Property implements WageObserver
{
    //CLASSFIELDS
    private double revenue;
    private double wages;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public BusinessUnit()
    {
        super();
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public BusinessUnit( double inRevenue, double inWages )
    {
        super();
        revenue = inRevenue;
        wages = inWages;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public double getRevenue() { return revenue; }
    public double getWages()   { return wages; }

//---------------------------------------------------------------------------
    //SETTERS

    public void setRevenue( double inRevenue ) { revenue = inRevenue; }
    public void setWages( double inWages ) { wages = inWages; }

//---------------------------------------------------------------------------
    //NAME: updateRevenue()
    //IMPORT: percent (double)
    //PURPOSE: Update revenue via multiplying by given percentage

    public void updateRevenue( double percent )
    {
        revenue *= ( 1 + percent );
    }

//---------------------------------------------------------------------------
    //NAME: calcProfit()
    //PURPOSE: Calculate profit for the year as revnue - wages

    public void calcProfit()
    {
        super.setProfit( revenue - wages );
    }

//---------------------------------------------------------------------------
    //NAME: increaseWages()
    //PURPOSE: Increase wages based on an occuring wage event

    public void increaseWages()
    {
        wages *= ( 1.0 + WAGE_CHANGE );
    }

//---------------------------------------------------------------------------
    //NAME: decreaseWages()
    //PURPOSE: Increase wages based on an occuring wage event

    public void decreaseWages()
    {
        wages *= ( 1.0 - WAGE_CHANGE );
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
