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
    //IMPORT: year (int), control (PropertyController)
    //PURPOSE: Print out all companies and their balances for a given year

    public void companyOutput( int year, PropertyController control )
    {
        // Get models required from the controller
        Map<String,Property> propMap = control.getPropMap();
        Company primary = control.getPrimary();

        // Print the current year and Primary Company
        System.out.println( "\nYEAR: " + year );
        System.out.print( "PRIMARY: " + primary.getName() + "\n\n" );
        System.out.println("----------------------------------\n");

        // Iteratore across all companies and output their balances
        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            Property next = entry.getValue();
            // Only print if not null and it is a company
            if ( ( next != null ) && ( next instanceof Company ) )
            {
                // Downcast to allow for getBank() to be called
                Company nextCompany = (Company)next;
                double nextValue = nextCompany.getBank().getValue();
                System.out.println( "COMPANY: " + nextCompany.getName() );
                // Two decimal places for money
                String balString = String.format("%.02f", nextValue);
                System.out.println( "BALANCE: " + balString + "\n" );
            }
        }

        System.out.println("----------------------------------");
    }

//---------------------------------------------------------------------------
    //NAME: debugOutput()
    //IMPORT: year (int), control (PropertyController)
    //PURPOSE: Print out all properties via their own toString() methods


    public void debugOutput( int year, PropertyController control )
    {
        // Get models required from the controller
        Map<String,Property> propMap = control.getPropMap();
        Company primary = control.getPrimary();

        // Print the current year and Primary Company
        System.out.println( "YEAR: " + year + "\n" );
        System.out.print( "PRIMARY: " + primary.getName() + "\n" );

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
        System.out.println("----------------------------------");

    }

//---------------------------------------------------------------------------
    //NAME: errorMessage
    //IMPORT: error (String)
    //PURPOSE: Error message printed to standard error

    public void errorMessage( String error )
    {
        System.err.println( error );
    }

//---------------------------------------------------------------------------
}
