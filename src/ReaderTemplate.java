/***************************************************************************
*	FILE: FileIO.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: FileIO Controller
*   LAST MOD: 28/09/16
*   REQUIRES: java.io
***************************************************************************/
import java.io.*;

public abstract class ReaderTemplate
{
    protected Controller control;

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

            line = br.readLine();
            line = br.readLine(); // skip header row
            while (line != null)
            {
                processLine( line.split(",") );
                line = br.readLine();
            }
			fs.close();
		}
		catch (IOException e)
		{
			if ( fs != null )
			{
				fs.close();
			}
			throw new IOException("error reading input file");
		}
    }

//---------------------------------------------------------------------------

    protected abstract void processLine(String[] fields);

//---------------------------------------------------------------------------
}
