/***************************************************************************
*	FILE: Property.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Property Model
*   LAST MOD: 14/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public abstract class Property
{
    //CLASSFIELDS
    private String name;
    private Company owner;
    private double value;
    private double profit;

    //CONSTANTS
    public static final double DEFAULT_PROFIT = 0.0;
    public static final double DEFAULT_VALUE = 0.0;

//---------------------------------------------------------------------------

    // ABSTRACT STRATEGY METHOD IMPLEMENTED IN THE CHILDREN
    public abstract void calcProfit();

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public Property()
    {
        profit = DEFAULT_PROFIT;
        value = DEFAULT_VALUE;
        name = null;
        owner = null;
    }

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public Property( String inName, Company inOwner )
    {
        name = inName;
        owner = inOwner;
        value = DEFAULT_VALUE;
    }

//---------------------------------------------------------------------------
    //GETTERS

    public String getName()   { return name; }
    public Company getOwner() { return owner; }
    public double getValue()  { return value; }
    public double getProfit() { return profit; }

//---------------------------------------------------------------------------
    //SETTERS

    public void setName( String inName )     { name = inName; }
    public void setOwner( Company inOwner )  { owner = inOwner; }
    public void setValue( double inValue )   { value = inValue; }
    public void setProfit( double inProfit ) { profit = inProfit; }

//---------------------------------------------------------------------------
    //NAME: updateValue()
    //IMPORT: percent (double)
    //PURPOSE: Update value via multiplying by given percentage

    public void updateValue( double percent )
    {
        value *= ( 1 + percent );
    }

//---------------------------------------------------------------------------
    //NAME: incrementValue()
    //IMPORT: increment (double)
    //PURPOSE: Increment value by increasing by value

    public void incrementValue( double increment )
    {
        value += increment;
    }

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
