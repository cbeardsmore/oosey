/***************************************************************************
*	FILE: PlanReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take plan fields and process into a plan object
*   LAST MOD: 10/10/16
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

//---------------------------------------------------------------------------
    //ALTERNATE CONSTRUCTOR

    public PlanReader( Controller inControl, PlanFactory inFactory )
    {
        control = inControl;
        factory = inFactory;
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Parse fields of a given line, creating objects as required

    protected void processLine(String[] fields) throws FileFormatException
    {
        PlanController planCon = control.getPlanCon();
        Plan newPlan = null;
        Property prop = null;
        int year;
        char type;

        // Check length of fields
        if ( fields.length != PLAN_FIELDS )
            throw new FileFormatException("Plan File Data Missing");

        // Get factory to create Plan, ensure it created properly
        type = parseType( fields[1] );
        newPlan = factory.createPlan( type );
        if ( newPlan == null )
            throw new FileFormatException("Plan Transaction type invalid");

        // Parse year field
        year = parseYear( fields[0] );
        newPlan.setYear( year );

        // Parse Affected
        prop = parseAffected( fields[2] );
        newPlan.setProp( prop );

        // Add the new plan to the list of plans in the controller
        planCon.setPlan( newPlan );
    }

//---------------------------------------------------------------------------
    //NAME: parseYear()
    //IMPORT: yearString (String)
    //EXPORT: year (int)
    //PURPOSE: Parse the year field of the input, checking validity

    private int parseYear( String yearString ) throws FileFormatException
    {
        PlanController planCon = control.getPlanCon();
        int year;
        // Parse year field and rethrow as less specific exception
        try
        {
            year = Integer.parseInt( yearString );
            // Ensure event in chronilogical order, sorry Demeter
            if ( year < planCon.currentPlanYear() )
                throw new FileFormatException("Plans Not Chronological");
        }
        catch ( NumberFormatException e )
        {
            // Rethrow, NumberFormatException doesn't provide correct info
            throw new FileFormatException("Year in Plan file invalid", e);
        }
        return year;
    }

//---------------------------------------------------------------------------
    //NAME: parseType()
    //IMPORT: typeString (String)
    //EXPORT: type (char)
    //PURPOSE: Parse the type field of the input, checking validity

    private char parseType( String typeString) throws FileFormatException
    {
        char type;
        // Specify type
        type = typeString.charAt(0);
        if ( typeString.length() != 1 )
            throw new FileFormatException("Plan Type invalid");
        return type;
    }

//---------------------------------------------------------------------------
    //NAME: parseAffected()
    //IMPORT: affString (String)
    //EXPORT: affected (Property)
    //PURPOSE: Parse the affected field of the input, checking validity

    private Property parseAffected( String affString) throws FileFormatException
    {
        PropertyController propCon = control.getPropCon();
        Property affected = null;

        // Get affected property, exception if it doesn't exist
        affected = propCon.getProperty( affString );
        if ( affected == null )
            throw new FileFormatException("Property in Plan does not exist");

        return affected;
    }

//---------------------------------------------------------------------------
}
