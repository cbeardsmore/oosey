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
    public static final int PLAN_FIELDS = 3;

    public PlanReader( Controller inControl, PlanFactory inFactory )
    {
        control = inControl;
        factory = inFactory;
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields) throws IllegalArgumentException
    {
        // Declare fields
        Plan newPlan = null;
        Property prop = null;
        int year;
        char type;

        // Check length of fields
        if ( fields.length != PLAN_FIELDS )
            throw new IllegalArgumentException("Plan File Data Missing");

        // Parse year field and rethrow as less specific exception
        try
        {
            year = Integer.parseInt( fields[0] );
        }
        catch ( NumberFormatException e )
        {
            throw new IllegalArgumentException("Year in Plan file invalid");
        }

        // Get property from controller map, ensure it actually exists
        prop = control.getProperty( fields[2] );
        if ( prop == null )
            throw new IllegalArgumentException("Property in Plan does not exist");

        // Check validity of transaction type
        type = fields[1].charAt(0);
        if ( fields[1].length() != 1 )
            throw new IllegalArgumentException("Plan Transaction type invalid");

        // Get factory to create Plan, ensure it created properly
        newPlan = factory.createPlan( type );
        if ( newPlan == null )
            throw new IllegalArgumentException("Plan Transaction type invalid");

        // Set fields of the default plan object
        newPlan.setYear( year );
        newPlan.setProp( prop );

        // Add the new plan to the list of plans in the controller
        control.setPlan( newPlan );
    }

//---------------------------------------------------------------------------
}
