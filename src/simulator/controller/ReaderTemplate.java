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

    public void readFile(String filename) throws FileReadingException,
                                                 FileFormatException
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
            // Assume it doesn't matter if the header line is invalid
            // So long as data below is intact it's all fine
            line = br.readLine();
            line = br.readLine();
            while (line != null)
            {
                processLine( line.split( ",",-1 ) );
                // Pass in split line to reader to parse
                line = br.readLine();
            }
			fs.close();
		}
		catch (IOException e)
		{
            // Try to close file if its already open
            try
            {
                if ( fs != null )
    				fs.close();
            }
            catch (IOException e2)
            {
                throw new FileReadingException("Cannot read specified file", e);
            }
            // Rethrow as less specific exception, caller doesn't need to
            // know about the IOException
			throw new FileReadingException("Cannot read specified file", e);
		}
    }

//---------------------------------------------------------------------------
    //NAME: processLine()
    //IMPORT: fields (String[])
    //PURPOSE: Template method, differs in each of the subclasses

    protected abstract void processLine(String[] fields) throws FileFormatException;

//---------------------------------------------------------------------------
}
