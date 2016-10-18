/***************************************************************************
*	FILE: Simulator.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main method to kickstart simulation
*   LAST MOD: 11/10/16
*   REQUIRES: java.io.*, model.*, controller.*, view.*
***************************************************************************/

import java.io.*;
import simulator.model.event.*;
import simulator.model.plan.*;
import simulator.model.property.*;
import simulator.controller.*;
import simulator.view.*;

public class Simulator
{
//---------------------------------------------------------------------------

    public static void main( String[] args )
    {
        //CLA FORMAT: start year, end year, property file, event file, plan file
        //Check correct number entered
        if ( args.length != 5 )
        {
            System.err.println("INVALID COMMAND LINE ARGUMENTS");
            System.err.println("SEE README FOR ARGUMENT FORMAT\n");
            System.exit(1);
        }


        try
        {
            // Construct objects and factories
            PrimaryView view = new PrimaryView();
            PropertyController propCon = new PropertyController();
            EventController eventCon = new EventController();
            PlanController planCon = new PlanController();
            Controller control = new Controller( view, propCon, eventCon, planCon );
            PlanFactory planFact = new PlanFactory();
            EventFactory eventFact = new EventFactory();

            // Welcome text/menu
            view.welcome();

            // Parse arguments
            int startYear = Integer.parseInt( args[0] );
            int endYear = Integer.parseInt( args[1] );
            String propertyFile = args[2];
            String eventFile = args[3];
            String planFile = args[4];

            // Read all 3 files using template method pattern
            ReaderTemplate reader = null;
            reader = new PropertyReader( control );
            reader.readFile( propertyFile );
            reader = new EventReader( control, eventFact );
            reader.readFile( eventFile );
            reader = new PlanReader( control, planFact );
            reader.readFile( planFile );

            // Run simulation
            control.run( startYear, endYear );

            // Completion
            System.exit(0);
        }
        // Thrown by parseInt if years are not numbers
        catch( NumberFormatException e )
        {
            System.err.println("INVALID YEARS GIVEN: " + e.getMessage() + "\n");
            System.exit(1);
        }
        // Thrown by file readers if files format is invalid
        catch( IllegalArgumentException e )
        {
            System.err.println("INVALID FILE FORMAT: " + e.getMessage() + "\n");
            System.exit(1);
        }
        // Thrown by file readers if file IO fails
        catch (IOException e)   // FIX THIS UP NIGGA
        {
            System.err.println( "FILE READING ERROR: " + e.getMessage() + "\n" );
            System.exit(1);
        }
    }

//---------------------------------------------------------------------------
}
