/***************************************************************************
*	FILE: PropertyReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE:
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/

public class PropertyReader extends ReaderTemplate
{
    public PropertyReader( Controller inControl )
    {
        control = inControl;
    }

//---------------------------------------------------------------------------
    protected void processLine(String[] fields)
    {
        Property newProp = null;
        if ( fields[1].charAt(0) == 'C' )
            newProp = new Company();
        else if ( fields[1].charAt(0) == 'B' )
        {
            int revenue = Integer.parseInt( fields[4] );
            int wages = Integer.parseInt( fields[5] );
            newProp = new BusinessUnit( revenue, wages );

        }

        newProp.setName( fields[0] );
        newProp.setValue( Integer.parseInt( fields[3] ) );
        newProp.setOwner( (Company)control.getProperty( fields[2] ) );

        control.setProperty( fields[0], newProp );
    }

//---------------------------------------------------------------------------
}
