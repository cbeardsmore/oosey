/***************************************************************************
*	FILE: Company.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Company Model
*   LAST MOD: 28/09/16
*   REQUIRES: Property, List
***************************************************************************/
import java.util.List;
import java.util.ArrayList;

public class Company extends Property
{
    //CLASSFIELDS
    List<Company> ownedCompanies;
    BankAccount bank;

    public Company()
    {
        ownedCompanies = new ArrayList<Company>();
        bank = null;
    }

//---------------------------------------------------------------------------
    public String toString()
    {
        String state = super.toString();
        state += "TYPE: Company" + "\n";
        state += "OWNED COMPANIES: ---" + "\n";
        state += "BANK ACCOUNT: ---" + "\n";
        return state;
    }

//---------------------------------------------------------------------------
}
