/***************************************************************************
*	FILE: BusinessUnit.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.view;

import java.util.Map;
import simulator.model.property.*;
import simulator.controller.*;

public class PrimaryView
{
//---------------------------------------------------------------------------

    public PrimaryView() {}

//---------------------------------------------------------------------------

    public void companyOutput( int year, Map<String,Property> propMap )
    {
        System.out.println("----------------------------------\n");
        System.out.println( "YEAR: " + year + "\n" );
        System.out.print( "PRIMARY "  );
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            if ( ( next != null ) && ( next instanceof Company ) )
            {
                Company nextCompany = (Company)next;
                System.out.println( "COMPANY: " + nextCompany.getName() );
                System.out.println( "BALANCE: " + nextCompany.getBank().getValue() + "\n" );
            }
        }
    }

//---------------------------------------------------------------------------

    public void debugOutput( int year, Map<String,Property> propMap )
    {
        System.out.println( "YEAR: " + year + "\n" );
        System.out.print( "PRIMARY "  );
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            if ( next != null )
                if ( ( next.getOwner() != null ) || ( next instanceof Company ) )
                    System.out.println( next.toString() );
        }
        System.out.println("----------------------------------\n");
    }

//---------------------------------------------------------------------------
    //NAME: welcome()
    //PURPOSE: General Welcome message to user on system startup

    public void welcome()
    {
        System.out.println("\n------COMPANY SIMULATOR 2016------");
        System.out.println("---Connor Beardsmore - 15504319---");
        System.out.println("----------------------------------\n");

    }

//---------------------------------------------------------------------------
}
