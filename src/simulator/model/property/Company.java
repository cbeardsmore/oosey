/***************************************************************************
*	FILE: Company.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Company Model
*   LAST MOD: 28/09/16
*   REQUIRES: Property, List
***************************************************************************/
package simulator.model.property;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Company extends Property
{
    //CLASSFIELDS
    Map<String,Property> ownedProps;
    BankAccount bank;

//---------------------------------------------------------------------------
    //PURPOSE: Initialise classfields, Bank initially null

    public Company()
    {
        ownedProps = new HashMap<String,Property>();
        bank = new BankAccount();
    }

//---------------------------------------------------------------------------
    //Getters

    public Property getProperty(String name) { return ownedProps.get(name); }
    public BankAccount getBank() { return bank; }

//---------------------------------------------------------------------------
    //NAME: addProperty()
    //IMPORT: name (String), newProp (Property)
    //PURPOSE: Add a new property to owned companies

    public void addProperty( String name, Property newProp )
    {
        ownedProps.put( name, newProp );
    }

//---------------------------------------------------------------------------
    //NAME: toString()
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Company" + "\n";
        state += "OWNED COMPANIES: ---" + "\n";
        state += "BANK ACCOUNT: ---" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
    //NAME: calcProfit()
    //PURPOSE: Calculate Bank account profit for the year

    public void calcProfit()
    {
        // First, get bank profit
        int newProfit = bank.getProfit();
        Property nextProp = null;

        for ( Map.Entry<String,Property> entry : ownedProps.entrySet() )
        {
            nextProp = entry.getValue();
            if ( nextProp != null )
                newProfit += nextProp.getProfit();
        }

        super.setProfit( newProfit );
    }

//---------------------------------------------------------------------------
}
