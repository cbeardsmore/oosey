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

public abstract class Plan
{
    //CLASSFIELDS
    private int year;
    private Property prop;

//---------------------------------------------------------------------------
    //PURPOSE: initialise Plan with given fields

    public Plan( int inYear, Property inProp )
    {
        year = inYear;
        prop = inProp;
    }

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
