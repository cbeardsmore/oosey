/***************************************************************************
*	FILE: Event.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Event model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/

public abstract class Event
{
    //CLASSFIELDS
    private int year;
    private boolean increase;

//---------------------------------------------------------------------------
    //PURPOSE: initialise Event with given fields

    public Event( int inYear, boolean inIncrease )
    {
        year = inYear;
        increase = inIncrease;
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = "EVENT" + "\n";
        state += "YEAR: " + year + "\n";
        state += "INCREASE: " + increase + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
