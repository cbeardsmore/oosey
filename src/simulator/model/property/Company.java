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
    private Map<String,Property> ownedProps;
    private BankAccount bank;

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
    //NAME: ownsUnit()
    //IMPORT: name (String)
    //EXPORT: owns (boolean)
    //PURPOSE: Returns true if the company owns the imported BusinessUnit

    public boolean ownsUnit( String name )
    {
        boolean owns = false;
        Property prop = ownedProps.get(name);
        // If prop exists in the map, it will not equal to null
        if ( prop != null )
            owns = true;
        return owns;
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
    //NAME: buys()
    //IMPORT: inNew (Property)
    //PURPOSE: Adds new property to this company and updates all fields

    public void buys( Property inNew )
    {
        // Put property in the map of owner properties
        int propValue = inNew.getValue();
        String name = inNew.getName();
        ownedProps.put( name, inNew );

        // Decrease the value of this Companys Bank
        bank.setValue( bank.getValue() - propValue );

        // Increase the value of the selling Companys Bank
        Company oldOwner = inNew.getOwner();
        if ( oldOwner != null )
        {
            BankAccount oldBank = oldOwner.getBank();
            oldBank.setValue( oldBank.getValue() + propValue );
        }
    }


//---------------------------------------------------------------------------
    //NAME: sells()
    //IMPORT: inNew (Property)
    //PURPOSE: Sells property and updates all fields

    public void sells( Property inNew )
    {
        //Remove property from the owned property map
        int propValue = inNew.getValue();
        String name = inNew.getName();
        ownedProps.remove( name );

        // Increase the value of this Companys Bank
        bank.setValue( bank.getValue() + propValue );

        // Set the new owner of the Property as "Unnamed"
        inNew.setOwner( null );

    }

//---------------------------------------------------------------------------
}
