/***************************************************************************
*	FILE: Company.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Company Model
*   LAST MOD: 28/09/16
*   REQUIRES: Property, List
***************************************************************************/
package simulator.model;

import java.util.List;
import java.util.ArrayList;

public class Company extends Property
{
    //CLASSFIELDS
    List<Property> ownedProps;
    BankAccount bank;

//---------------------------------------------------------------------------
    //PURPOSE: Initialise classfields, Bank initially null

    public Company()
    {
        ownedProps = new ArrayList<Property>();
        bank = new BankAccount();;
    }

//---------------------------------------------------------------------------
    //NAME: toString
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

        // Next, get profit of every company owned
        for ( Property next : ownedProps )
            newProfit += next.getProfit();

        super.setProfit( newProfit );
    }

//---------------------------------------------------------------------------
}
