/***************************************************************************
*	FILE: ValueEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: ValueEvent model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;

public class ValueEvent extends Event
{
    public ValueEvent()
    {
        super();
    }

//---------------------------------------------------------------------------
    //IMPORT: inYear (int), inIncrease (boolean), inAff (Property)
    //PURPOSE: initialise fields to imported values

    public ValueEvent( int inYear, boolean inIncrease, Property inAff )
    {
        super( inYear, inIncrease, inAff );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Value" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
