/***************************************************************************
*	FILE: PlanReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take plan fields and process into a plan object
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.controller;

import simulator.model.*;

public class PlanReader extends ReaderTemplate
{
    public PlanReader( Controller inControl )
    {
        control = inControl;
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields)
    {
        // Parse year
        Plan newPlan = null;
        Property prop = null;

        // Parse year field
        int year = Integer.parseInt( fields[0] );

        // Get property if name is given
        if ( fields.length == 3 )
            prop = control.getProperty( fields[2] );

        // Create object based on char field
        if ( fields[1].charAt(0) == 'B' )
            newPlan = new BuyPlan( year, prop );
        else if ( fields[1].charAt(0) == 'S' )
            newPlan = new SellPlan( year, prop );

        control.setPlan( newPlan );
    }

//---------------------------------------------------------------------------
}
