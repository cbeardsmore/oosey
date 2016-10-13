/***************************************************************************
*	FILE: FileIO.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: FileIO Controller
*   LAST MOD: 28/09/16
*   REQUIRES: java.io
***************************************************************************/
package simulator.controller;

import java.io.*;
import simulator.model.*;

public abstract class ReaderTemplate
{
    // Enables read method to add objects into controller
    protected Controller control;

//---------------------------------------------------------------------------
    //NAME: readFile()
    //IMPORT: filename (String)
    //PURPOSE: Open up a file and read its contents into the Controller

    public void readFile(String filename) throws IOException
    {
        FileInputStream fs = null;
		InputStreamReader isr;
		BufferedReader br;
        String line;

		try
		{
			//Open all streams
			fs = new FileInputStream(filename);
			isr = new InputStreamReader(fs);
			br = new BufferedReader(isr);

            // Read twice to skip over the initial header row
            line = br.readLine();
            line = br.readLine();
            while (line != null)
            {
                processLine( line.split(",") );
                // Pass in split line to reader to parse
                line = br.readLine();
            }
			fs.close();
		}
		catch (IOException e)
		{
			if ( fs != null )
				fs.close();
			throw new IOException("Error reading file");
		}
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Template method, differs in each of the subclasses

    protected abstract void processLine(String[] fields);

//---------------------------------------------------------------------------
}
