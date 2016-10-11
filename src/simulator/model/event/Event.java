/***************************************************************************
*	FILE: Event.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Event model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;

public abstract class Event
{
    // All events increase/decrease by 5%
    public static final double valueChange = 0.05;

    //CLASSFIELDS
    private int year;
    private boolean increase;
    private Property affected;

//---------------------------------------------------------------------------
    //PURPOSE: initialise Event with given fields

    public Event()
    {
        year = -1;
        increase = false;
        affected = null;
    }

//---------------------------------------------------------------------------
    //PURPOSE: initialise Event with given fields

    public Event( int inYear, boolean inIncrease, Property inAff )
    {
        year = inYear;
        increase = inIncrease;
        affected = inAff;
    }

//---------------------------------------------------------------------------
    //Getters

    public int getYear() { return year; }
    public boolean isIncrease() { return increase; }
    public Property getAffected() { return affected; }

//---------------------------------------------------------------------------
    //Setters

    public void setYear( int inYear ) { year = inYear; }
    public void setIncrease( boolean inInc ) { increase = inInc; }
    public void setAffected( Property inAff ) { affected = inAff; }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = "EVENT" + "\n";
        state += "YEAR: " + year + "\n";
        state += "INCREASE: " + increase + "\n";
        if ( affected != null )
            state += "AFFECTED: " + affected.getName() + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
