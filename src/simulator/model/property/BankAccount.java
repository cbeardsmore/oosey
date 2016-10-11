/***************************************************************************
*	FILE: BankAccount.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BankAccount Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public class BankAccount extends Property
{

    //CLASSFIELDS + CONSTANTS
    public static final double INTEREST = 0.05;

//---------------------------------------------------------------------------
    //PURPOSE: Initialise balance to default value

    public BankAccount()
    {
        //Will initialise the banks "balance" (same as value) to 0
        super();
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "BANK ACCOUNT BALANCE: " + super.getValue() + "\n";
        return state;
    }
//---------------------------------------------------------------------------
    //NAME: calcProfit()
    //PURPOSE: Calculate Bank account profit for the year

    public void calcProfit()
    {
        // Interest is 5% of the balance
        double balance = super.getValue();
        double interestAmount = INTEREST * balance;
        // +ve interest for +ve balance and vice versa
        if ( balance >= 0.0 )
            balance += interestAmount;
        else
            balance -= interestAmount;
        // Set the Bank Property profit value
        super.setProfit( interestAmount );
    }

//---------------------------------------------------------------------------
}
