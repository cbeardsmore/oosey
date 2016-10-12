/***************************************************************************
*	FILE: Plan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Plan model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.plan;

import simulator.model.property.*;
import simulator.controller.*;

public abstract class Plan
{
    //CLASSFIELDS
    private int year;
    private Property prop;

    public abstract void run( Controller control );

//---------------------------------------------------------------------------
    //PURPOSE: initialise Plan with default fields

    public Plan()
    {
        year = -1;
        prop = null;
    }

//---------------------------------------------------------------------------
    //PURPOSE: initialise Plan with given fields

    public Plan( int inYear, Property inProp )
    {
        year = inYear;
        prop = inProp;
    }

//---------------------------------------------------------------------------
    //Getters

    public int getYear() { return year; }
    public Property getProp() { return prop; }

//---------------------------------------------------------------------------
    // Setters

    public void setYear( int inYear ) { year = inYear; }
    public void setProp( Property inProp ) { prop = inProp; }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = "PLAN" + "\n";
        state += "YEAR: " + year + "\n";
        state += "PROPERTY: " + prop.getName() + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
