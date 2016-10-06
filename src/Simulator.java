/***************************************************************************
*	FILE: Simulator.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main method to kickstart simulation
*   LAST MOD: 28/09/16
*   REQUIRES:
***************************************************************************/
import java.io.*;
import simulator.model.event.*;
import simulator.model.plan.*;
import simulator.model.property.*;
import simulator.controller.*;
import simulator.view.*;

public class Simulator
{
    public static void main( String[] args )
    {
        //CLA FORMAT: start year, end year, property file, event file, plan file
        //Check correct number entered
        if ( args.length != 5 )
        {
            System.err.println("INVALID COMMAND LINE ARGUMENTS");
            System.err.println("SEE README FOR ARGUMENT FORMAT");
            System.exit(1);
        }

        // Parse arguments
        try
        {
            int startYear = Integer.parseInt( args[0] );
            int endYear = Integer.parseInt( args[1] );
            String propertyFile = args[2];
            String eventFile = args[3];
            String planFile = args[4];

            PrimaryView view = new PrimaryView();
            Controller control = new Controller( view );
            PlanFactory planFact = new PlanFactory();
            EventFactory eventFact = new EventFactory();

            ReaderTemplate reader = null;
            reader = new PropertyReader( control );
            reader.readFile( propertyFile );
            reader = new EventReader( control, eventFact );
            reader.readFile( eventFile );
            reader = new PlanReader( control, planFact );
            reader.readFile( planFile );

            control.run( startYear, endYear );
            view.output( control.toString() );
        }
        catch( NumberFormatException e )
        {
            System.err.println("START YEAR/END YEAR INVALID");
            System.exit(1);
        }
        catch( IllegalArgumentException e )
        {
            System.err.println("END YEAR NOT AFTER START YEAR");
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println( "FILE READING ERROR: " + e.getMessage() );
        }
    }

//---------------------------------------------------------------------------
}
