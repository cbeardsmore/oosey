/***************************************************************************
*	FILE: BankAccount.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BankAccount Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/

public class BankAccount extends Property
{

    //CLASSFIELDS + CONSTANTS
    public static final int DEFAULT_BALANCE = 0;
    public static final double INTEREST = 0.05;
    private int balance;
//---------------------------------------------------------------------------
    //PURPOSE: Initialise balance to default value

    public BankAccount()
    {
        super();
        balance = DEFAULT_BALANCE;
    }
//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = super.toString();
        state += "BANK ACCOUNT BALANCE: " + balance + "\n";
        return state;
    }
//---------------------------------------------------------------------------
    //NAME: calcProfit()
    //PURPOSE: Calculate Bank account profit for the year

    public void calcProfit()
    {
        // Interest is 5% of the balance
        int interestAmount = (int)(INTEREST * (double)balance);
        // +ve interest for +ve balance and vice versa
        if ( balance > 0 )
            balance += interestAmount;
        else
            balance -= interestAmount;
        // Set the Bank Property profit value
        super.setProfit( interestAmount );
    }

//---------------------------------------------------------------------------
}