/***************************************************************************
*	FILE: PropertyReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take property fields and process into a property object
*   LAST MOD: 10/10/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import simulator.model.property.*;

public class PropertyReader extends ReaderTemplate
{
//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public PropertyReader( Controller inControl )
    {
        control = inControl;
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields)
    {
        Property newProp = null;
        Property owner;
        int revenue;
        int wages;

        // Check that type is correct length
        if ( fields[1].length() != 1 )
            throw new IllegalArgumentException("Property Type Invalid");

        // If C, create new Company
        if ( fields[1].charAt(0) == 'C' )
            newProp = new Company( new BankAccount() );
        // If B, create new BusinessUnit with given revenue and wages
        // Ensure revenue and wages actually exist
        else if ( fields[1].charAt(0) == 'B' )
        {
            try
            {
                revenue = Integer.parseInt( fields[4] );
                wages = Integer.parseInt( fields[5] );
                newProp = new BusinessUnit( revenue, wages );
            }
            catch ( NumberFormatException e )
            {
                throw new IllegalArgumentException("Business Revenue/Wages Invalid");
            }
        }
        else
            throw new IllegalArgumentException("Property Type Invalid");

        // Set name and value
        newProp.setName( fields[0] );
        try
        {
            newProp.setValue( Integer.parseInt( fields[3] ) );
        }
        catch ( NumberFormatException e )
        {
            throw new IllegalArgumentException("Value in Plan File Invalid");
        }


        // Check if owner exists from map, set to null if no owner
        if ( !fields[2].equals("") )
        {
            owner = control.getPropCon().getProperty( fields[2] );
            if ( owner == null )
                throw new IllegalArgumentException("Property Owner Invalid");
            if ( !(owner instanceof Company) )
                throw new IllegalArgumentException("Property Owner must be a Company");

            // Set owner field AND update map of the owner
            newProp.setOwner( (Company)owner );
            ((Company)owner).addProperty( fields[0], newProp );
        }

        // Add the new property into the controller
        control.getPropCon().setProperty( fields[0], newProp );
    }

//---------------------------------------------------------------------------
}
