/***************************************************************************
*	FILE: FileReadingException.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Exception thrown during any File Reading
*   LAST MOD: 11/10/16
*   REQUIRES: NONE
***************************************************************************/

package simulator.controller;

public class FileReadingException extends Exception
{
    public FileReadingException( String message, Throwable cause )
    {
        super(message, cause);
    }
}

//---------------------------------------------------------------------------
