/***************************************************************************
*	FILE: Property.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Property Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model;

public abstract class Property
{
    //CONSTANTS
    public static final String UNOWNED = "No Owner";
    public static final int DEFAULT_PROFIT = 0;

    //CLASSFIELDS
    private String name;
    private int value;
    private int profit;
    private Company owner;
//---------------------------------------------------------------------------
    //PURPOSE: Initialise profit to default value

    public Property() { profit = DEFAULT_PROFIT; }

//---------------------------------------------------------------------------
    //NAME: Standard setters
    //IMPORT: value to set
    //PURPOSE: Set classfield equal to the imported value

    public void setName( String inName ) { name = inName; }
    public void setOwner( Company inOwner ) { owner = inOwner; }
    public void setValue( int inValue ) { value = inValue; }
    public void setProfit( int inProfit ) { profit = inProfit; }

//---------------------------------------------------------------------------
    //NAME: standard getters
    //EXPORT: value of classfield
    //PURPOSE: Export value of classfield asked for

    public String getName() { return name; };
    public int getProfit() { return profit; }
//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = "NAME: " + name + "\n";
        state += "VALUE: " + value + "\n";
        state += "PROFIT: " + profit + "\n";
        state += "OWNER: ";
        if ( owner != null )
            state += owner.getName() + "\n";
        else
            state += UNOWNED + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
