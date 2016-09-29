/***************************************************************************
*	FILE: Simulator.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Main method to kickstart simulation
*   LAST MOD: 28/09/16
*   REQUIRES:
***************************************************************************/
import java.io.*;

public class Simulator
{
    public static void main( String[] args )
    {
        // CLA'S -> PROPERTY_FILE, EVENT_FILE, PLAN_FILE, START_YR, END_YR
        //if ( args.length != 5 )
        //    throw new IllegalArgumentException("INVALID CLA");

        String propertyFile = args[0];
        String eventFile = args[1];
        String planFile = args[2];
        int startYear = Integer.parseInt( args[3] );
        int endYear = Integer.parseInt( args[4] );

        Controller myController = new Controller();

        try
        {
            ReaderTemplate reader = null;
            reader = new PropertyReader( myController );
            reader.readFile( "../tests/property1.txt" );
            reader = new EventReader( myController );
            reader.readFile( "../tests/event1.txt" );
            reader = new PlanReader( myController );
            reader.readFile( "../tests/plan1.txt" );
        }
        catch (IOException e)
        {
            System.out.println( e.getMessage() );
        }

        System.out.println( myController.toString() );

    }

//---------------------------------------------------------------------------
}
