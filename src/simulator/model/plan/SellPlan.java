/***************************************************************************
*	FILE: SellPlan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: SellPlan model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.plan;

import simulator.model.property.*;
import simulator.controller.*;

public class SellPlan extends Plan
{
    public SellPlan()
    {
        super();
    }
//---------------------------------------------------------------------------
    //PURPOSE: initialise Plan with given fields

    public SellPlan( int inYear, Property inProp )
    {
        super( inYear, inProp );
    }

//---------------------------------------------------------------------------

    public void run( Controller control )
    {
        Property prop = super.getProp();
        Company primary = control.getPrimary();

        //Remove property from the owned property map
        double propValue = prop.getValue();
        String name = prop.getName();
        primary.removeProperty( name );

        // Increase the value of this Companys Bank
        BankAccount bank = primary.getBank();
        bank.setValue( bank.getValue() + propValue );

        // Set the new owner of the Property as "Unnamed"
        prop.setOwner( null );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Sell" + "\n";
        return state;
    }
//---------------------------------------------------------------------------
}
