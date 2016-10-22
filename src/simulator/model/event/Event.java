/***************************************************************************
*	FILE: Event.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Event model
*   LAST MOD: 12/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;
import simulator.controller.*;

public abstract class Event
{
    // All events increase/decrease the given field by 5%
    public static final double VALUE_CHANGE = 0.05;
    public static final int DEFAULT_YEAR = 0;

    //CLASSFIELDS
    private int year;
    private boolean increase;

    // Wage events don't have affected properties currently
    // Leave in superclass in case Wages alter in future
    private Property affected;

//---------------------------------------------------------------------------
    //STRATEGY METHOD. WILL BE IMPLEMENTED IN THE SUBCLASSES
    //RUNS THE EVENT AND UPDATES THE CONTROLLER FIELDS AS REQUIRED

    public abstract void run( Controller control );

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public Event()
    {
        year = DEFAULT_YEAR;
        increase = false;
        affected = null;
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public Event( int inYear, boolean inIncrease, Property inAff )
    {
        year = inYear;
        increase = inIncrease;
        affected = inAff;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public int getYear() { return year; }
    public boolean isIncrease() { return increase; }
    public Property getAffected() { return affected; }

//---------------------------------------------------------------------------
    //SETTERS

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
