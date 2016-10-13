/***************************************************************************
*	FILE: PrimaryView.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Primary View for all output to the terminal
*   LAST MOD: 28/09/16
*   REQUIRES: model.property.*, controller.*
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
    //NAME: companyOutput()
    //IMPORT: year (int), propMap (Map<String,Property>)
    //PURPOSE: Print out all companies and their balances for a given year

    public void companyOutput( int year, Map<String,Property> propMap )
    {
        //Primary company will always be the first in the Map,
        // according to the Java API
        System.out.println( "YEAR: " + year + "\n" );
        System.out.print( "PRIMARY "  );

        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            // Only print if not null and it's a company
            if ( ( next != null ) && ( next instanceof Company ) )
            {
                // Downcast to allow for getBank() to be called
                Company nextCompany = (Company)next;
                System.out.println( "COMPANY: " + nextCompany.getName() );
                System.out.println( "BALANCE: " + nextCompany.getBank().getValue() + "\n" );
            }
        }

        System.out.println("----------------------------------\n");
    }

//---------------------------------------------------------------------------
    //NAME: debugOutput()
    //IMPORT: year (int), propMap (Map<String,Property>)
    //PURPOSE: Print out all properties via their own toString() methods


    public void debugOutput( int year, Map<String,Property> propMap )
    {
        System.out.println( "YEAR: " + year + "\n" );
        System.out.print( "PRIMARY "  );

        // Print ALL properties and ALL fields via toString() calls
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            if ( next != null )
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
