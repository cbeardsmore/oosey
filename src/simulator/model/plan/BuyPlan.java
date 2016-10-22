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
        // Get the buyer and the actual property + its fields
        Company primary = control.getPropCon().getPrimary();
        Property prop = super.getProp();
        double propValue = prop.getValue();
        String name = prop.getName();

        // Check primary doesn't already own the property
        if ( primary.owns( name ) )
            throw new IllegalArgumentException("Company cannot buy property it owns");

        // Check primary isn't buying itself
        if ( name == primary.getName() )
            throw new IllegalArgumentException("Cannot buy primary company");

        // Put property in the map of primary company
        primary.addProperty( name, prop );

        // Reset propertys owner to the new owner (primary company)
        Company oldOwner = prop.getOwner();
        if ( oldOwner != null )
        {
            oldOwner.removeProperty( name );
            BankAccount oldBank = oldOwner.getBank();
            oldBank.incrementValue( propValue );
        }

        //Set the new owner
        prop.setOwner( primary );

        // Decrease the value of primary companys bank
        BankAccount newBank = primary.getBank();
        newBank.incrementValue( -propValue );
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
