/***************************************************************************
*	FILE: PlanReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take plan fields and process into a plan object
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.controller;

import simulator.model.property.*;
import simulator.model.plan.*;

public class PlanReader extends ReaderTemplate
{
    //CLASSFIELDS
    private PlanFactory factory;

    public PlanReader( Controller inControl, PlanFactory inFactory )
    {
        control = inControl;
        factory = inFactory;
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

        char type = fields[1].charAt(0);
        newPlan = factory.createPlan( type );

        control.setPlan( newPlan );
    }

//---------------------------------------------------------------------------
}
