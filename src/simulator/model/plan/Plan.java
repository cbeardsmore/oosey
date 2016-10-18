/***************************************************************************
*	FILE: Plan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Abstract Plan Model
*   LAST MOD: 12/10/16
*   REQUIRES:
***************************************************************************/
package simulator.model.plan;

import simulator.model.property.*;
import simulator.controller.*;

public abstract class Plan
{
    //CLASSFIELDS
    private int year;
    private Property prop;

//---------------------------------------------------------------------------
    //STRATEGY METHOD. WILL BE IMPLEMENTED IN THE SUBCLASSES
    //RUNS THE PLAN AND UPDATES THE CONTROLLER FIELDS AS REQUIRED

    public abstract void run( Controller control );

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR
    //PURPOSE: initialise Plan with default fields

    public Plan()
    {
        year = -1;
        prop = null;
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTO
    //PURPOSE: initialise Plan with given fields

    public Plan( int inYear, Property inProp )
    {
        year = inYear;
        prop = inProp;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public int getYear() { return year; }
    public Property getProp() { return prop; }

//---------------------------------------------------------------------------
    //SETTERS

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
