/***************************************************************************
*	FILE: BuyPlan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BuyPlan model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.plan;

import simulator.model.property.*;
import simulator.controller.*;

public class BuyPlan extends Plan
{
    public BuyPlan()
    {
        super();
    }
//---------------------------------------------------------------------------
    //PURPOSE: initialise Plan with given fields

    public BuyPlan( int inYear, Property inProp )
    {
        super( inYear, inProp );
    }

//---------------------------------------------------------------------------

    public void run( Controller control )
    {
        Property prop = super.getProp();
        Company primary = control.getPrimary();

        // Put property in the map of primary company
        double propValue = prop.getValue();
        String name = prop.getName();
        primary.addProperty( name, prop );

        // Decrease the value of primary companys bank
        BankAccount bank = primary.getBank();
        bank.setValue( bank.getValue() - propValue );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Buy" + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
