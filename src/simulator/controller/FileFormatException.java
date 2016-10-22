/***************************************************************************
*	FILE: FileFormatException.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Exception thrown during file reading, if file is invalid
*   LAST MOD: 11/10/16
*   REQUIRES: NONE
***************************************************************************/

package simulator.controller;

public class FileFormatException extends Exception
{
    public FileFormatException( String message )
    {
        super(message);
    }

    public FileFormatException( String message, Throwable cause )
    {
        super(message, cause);
    }
}

//---------------------------------------------------------------------------
