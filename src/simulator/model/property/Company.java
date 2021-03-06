/***************************************************************************
*	FILE: Company.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Company Model
*   LAST MOD: 11/10/16
*   REQUIRES: Map, HashMap
***************************************************************************/
package simulator.model.property;

import java.util.Map;
import java.util.HashMap;

public class Company extends Property
{
    //CLASSFIELDS
    private Map<String,Property> ownedProps;
    private BankAccount bank;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRCTOR

    public Company( BankAccount inBank )
    {
        bank = inBank;
        ownedProps = new HashMap<String,Property>();
    }

//---------------------------------------------------------------------------
    //GETTERS

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
    //NAME: removeProperty()
    //IMPORT: name (String), newProp (Property)
    //PURPOSE: Remove property from owned companies, or exception if doesn't exist

    public void removeProperty( String name )
    {
        Property removed = ownedProps.remove( name );
        if ( removed == null )
            throw new IllegalArgumentException("Cannot remove property");
    }

//---------------------------------------------------------------------------
    //NAME: ownsUnit()
    //IMPORT: name (String)
    //EXPORT: owns (boolean)
    //PURPOSE: Returns true if the company owns the imported Property

    public boolean owns( String name )
    {
        boolean owns = false;
        Property prop = ownedProps.get(name);
        // If prop is not null, it exists in the map
        if ( prop != null )
            owns = true;
        return owns;
    }


//---------------------------------------------------------------------------
    //NAME: calcProfit()
    //PURPOSE: Calculate Company profit for the year iteratively

    public void calcProfit()
    {
        double newProfit = 0.0;
        Property nextProp = null;

        // Call all properties in the map
        for ( Map.Entry<String,Property> entry : ownedProps.entrySet() )
        {
            nextProp = entry.getValue();
            if ( nextProp != null )
            {
                // Get property to calculate profit, add to this profit
                nextProp.calcProfit();
                newProfit += nextProp.getProfit();
            }
        }

        // If negative profit, reduce bank account
        if ( newProfit <= 0.0 )
        {
            super.setProfit( 0.0 );
            bank.incrementValue( newProfit );
        }
        // If positive, put half in the bank and halve profit
        else
        {
            super.setProfit( 0.5 * newProfit );
            bank.incrementValue( 0.5 * newProfit );
        }

        // Calculate Bank interest amount
        bank.calcProfit();
    }

//---------------------------------------------------------------------------
    //NAME: toString()
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Company" + "\n";
        state += bank.toString();
        state += "OWNED COMPANIES: ";

        // Owns no companies
        if ( ownedProps.isEmpty() )
            state += "-----";

        // Output names of all owned companies
        for ( Map.Entry<String,Property> entry : ownedProps.entrySet() )
        {
            Property next = entry.getValue();
            if ( next != null )
                state += " : " + next.getName();
        }

        state += "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
