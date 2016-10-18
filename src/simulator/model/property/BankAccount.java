/***************************************************************************
*	FILE: BankAccount.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BankAccount Model
*   LAST MOD: 10/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public class BankAccount extends Property
{
    //CONSTANTS
    public static final double INTEREST = 0.05;

//---------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR

    public BankAccount()
    {
        //Will initialise the banks "balance" (same as value) to 0
        super();
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
        balance += interestAmount;

        // Set the Bank Property profit value
        super.setValue( balance );
        super.setProfit( interestAmount );
    }

//---------------------------------------------------------------------------
    //NAME: toString
    //EXPORT: state (String)
    //PURPOSE: Export state in readable String format

    public String toString()
    {
        String state = "BANK ACCOUNT BALANCE: " + super.getValue() + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
