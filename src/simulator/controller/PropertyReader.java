/***************************************************************************
*	FILE: PropertyReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE:
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
package simulator.controller;

import simulator.model.*;

public class PropertyReader extends ReaderTemplate
{
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
        // If C, create new Company
        if ( fields[1].charAt(0) == 'C' )
        {
            newProp = new Company();
        }
        // If B, create new BusinessUnit with given revenue and wages
        else if ( fields[1].charAt(0) == 'B' )
        {
            int revenue = Integer.parseInt( fields[4] );
            int wages = Integer.parseInt( fields[5] );
            newProp = new BusinessUnit( revenue, wages );
        }

        // Set name and value
        newProp.setName( fields[0] );
        newProp.setValue( Integer.parseInt( fields[3] ) );

        // Check if owner exists from map, set to null if no owner
        newProp.setOwner( (Company)control.getProperty( fields[2] ) );

        // Add the new property into the controller
        control.setProperty( fields[0], newProp );
    }

//---------------------------------------------------------------------------
}
