/***************************************************************************
*	FILE: EventReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take event fiels and process into an event object
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/

public class EventReader extends ReaderTemplate
{
    public EventReader( Controller inControl )
    {
        control = inControl;
    }
//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields)
    {
        Event newEvent = null;
        Property affected = null;
        boolean increase = false;

        // Parse year field
        int year = Integer.parseInt( fields[0] );

        // Get property if name is given
        if ( fields.length == 3 )
            affected = control.getProperty( fields[2] );

        // Find whether increase of decrease event
        if ( fields[1].charAt(1) == '+' )
            increase = true;

        // Create object based on char field
        if ( fields[1].charAt(0) == 'W' )
            newEvent = new WageEvent( year, increase );
        else if ( fields[1].charAt(0) == 'R' )
            newEvent = new RevenueEvent( year, increase, affected );
        else if ( fields[1].charAt(0) == 'V' )
            newEvent = new ValueEvent( year, increase, affected );

        control.setEvent( newEvent );
    }

//---------------------------------------------------------------------------
}
