/***************************************************************************
*	FILE: Property.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Property Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public abstract class Property
{
    //CONSTANTS
    public static final int DEFAULT_PROFIT = 0;
    public static final int DEFAULT_VALUE = 0;

    //CLASSFIELDS
    private String name;
    private Company owner;
    private int value;
    private int profit;
//---------------------------------------------------------------------------
    //PURPOSE: Used to initialise profit field

    public Property()
    {
        profit = DEFAULT_PROFIT;
        value = DEFAULT_VALUE;
        name = null;
        owner = null;
    }

//---------------------------------------------------------------------------
    //PURPOSE: General constructor, given owner and unique name

    public Property( String inName, Company inOwner )
    {
        name = inName;
        owner = inOwner;
        value = DEFAULT_VALUE;
    }

//---------------------------------------------------------------------------
    //NAME: Standard setters
    //IMPORT: value to set
    //PURPOSE: Set classfield equal to the imported value

    public void setName( String inName )    { name = inName; }
    public void setOwner( Company inOwner ) { owner = inOwner; }
    public void setValue( int inValue )     { value = inValue; }
    public void setProfit( int inProfit )   { profit = inProfit; }

//---------------------------------------------------------------------------
    //NAME: standard getters
    //EXPORT: value of classfield
    //PURPOSE: Export value of classfield asked for

    public String getName()   { return name; }
    public Company getOwner() { return owner; }
    public int getValue()     { return value; }
    public int getProfit()    { return profit; }
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
            state += "Unowned" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
