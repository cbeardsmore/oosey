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
    // CONSTANTS
    public static final int PROP_FIELDS = 6;

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

    protected void processLine(String[] fields) throws FileFormatException
    {
        PropertyController propCon = control.getPropCon();
        Property newProp = null;
        char type;

        // Check length of fields
        if ( fields.length != PROP_FIELDS )
            throw new FileFormatException("Property File Data Missing");

        // Parse type
        type = parseType( fields[1] );
        // Create proeprty based off that type, kinda factory looking thing
        newProp = createProperty( type, fields );
        // Set name
        newProp.setName( fields[0] );

        // Set value
        try
        {
            newProp.setValue( Integer.parseInt( fields[3] ) );
        }
        catch ( NumberFormatException e )
        {
            throw new FileFormatException("Value in Plan File Invalid");
        }

        // Set the owner of the new property
        setOwner( fields[2], newProp );

        // Check it doesn't already exist in the map
        if ( propCon.getProperty(fields[0]) != null )
            throw new FileFormatException("Property duplicate detected");

        // Add the new property into the controller
        propCon.setProperty( fields[0], newProp );
    }

//---------------------------------------------------------------------------
    //NAME: parseType()
    //IMPORT: typeString (String)
    //EXPORT: type (char)
    //PURPOSE: Parse type given the string containing the type

    private char parseType( String typeString ) throws FileFormatException
    {
        char type;
        // Check that type is correct length
        type = typeString.charAt(0);
        if ( typeString.length() != 1 )
            throw new FileFormatException("Property Type Invalid");

        return type;
    }

//---------------------------------------------------------------------------
    //NAME: setOwner()
    //IMPORT: ownerName (String), newProp (Property)
    //PURPOSE: Set the owner of newProp to be that of ownerNamer

    private void setOwner( String ownerName, Property newProp ) throws FileFormatException
    {
        PropertyController propCon = control.getPropCon();
        Property owner = null;
        // If an owner is actually given
        if ( !ownerName.equals("") )
        {
            owner = propCon.getProperty( ownerName );
            if ( owner == null )
                throw new FileFormatException("Property Owner Invalid");
            if ( !(owner instanceof Company) )
                throw new FileFormatException("Property Owner must be a Company");

            // Set owner field AND update map of the owner
            newProp.setOwner( (Company)owner );
            ((Company)owner).addProperty( newProp.getName(), newProp );
        }
    }

//---------------------------------------------------------------------------
    //NAME: createProperty()
    //IMPORT: type (char), fields (String[])
    //EXPORT: newProp (Property)
    //PURPOSE: Create Property given the fields, either Company or BusinessUnit

    private Property createProperty( char type, String[] fields ) throws FileFormatException
    {
        Property newProp = null;
        int revenue;
        int wages;

        // If C, create new Company
        if ( type == 'C' )
            newProp = new Company( new BankAccount() );
        // If B, create new BusinessUnit with given revenue and wages
        // Ensure revenue and wages actually exist
        else if ( type == 'B' )
        {
            try
            {
                revenue = Integer.parseInt( fields[4] );
                wages = Integer.parseInt( fields[5] );
                newProp = new BusinessUnit( revenue, wages );
            }
            // Wrap exception and throw as a more general kind
            catch ( NumberFormatException e )
            {
                throw new FileFormatException("Business Revenue/Wages Invalid");
            }
        }
        // Isn't B or C, must be invalid
        else
            throw new FileFormatException("Property Type Invalid");

        return newProp;
    }

//---------------------------------------------------------------------------
}
