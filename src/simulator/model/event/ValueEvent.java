/***************************************************************************
*	FILE: ValueEvent.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: ValueEvent model
*   LAST MOD: 14/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.event;

import simulator.model.property.*;
import simulator.controller.*;

public class ValueEvent extends Event
{
//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public ValueEvent()
    {
        super();
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public ValueEvent( int inYear, boolean inIncrease, BusinessUnit inAff )
    {
        super( inYear, inIncrease, inAff );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Perform the Event, updating revenue of the affected property

    public void run( Controller control )
    {
        Property affected = super.getAffected();
        if ( super.isIncrease() )
            affected.updateValue( VALUE_CHANGE );
        else
            affected.updateValue( -VALUE_CHANGE );
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
