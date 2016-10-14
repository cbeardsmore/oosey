/***************************************************************************
*	FILE: BuyPlan.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BuyPlan model
*   LAST MOD: 12/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.plan;

import simulator.model.property.*;
import simulator.controller.*;

public class BuyPlan extends Plan
{
//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR
    public BuyPlan()
    {
        super();
    }
//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public BuyPlan( int inYear, Property inProp )
    {
        super( inYear, inProp );
    }

//---------------------------------------------------------------------------
    //NAME: run()
    //IMPORT: control (Controller)
    //PURPOSE: Primary company BUYS the property, old owner SELLS

    public void run( Controller control )
    {
        // Get the buyer and the actual property to buy
        Property prop = super.getProp();
        Company primary = control.getPrimary();

        // Put property in the map of primary company
        double propValue = prop.getValue();
        String name = prop.getName();
        primary.addProperty( name, prop );

        // Reset propertys owner to the new owner (primary company)
        Company oldOwner = prop.getOwner();
        if ( oldOwner != null )
        {
            oldOwner.removeProperty( name );
            BankAccount oldBank = oldOwner.getBank();
            oldBank.setValue( oldBank.getValue() + propValue );
        }
        prop.setOwner( primary );

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
