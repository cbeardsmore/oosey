/***************************************************************************
*	FILE: EventReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take event fiels and process into an event object
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/

public class EventReader extends ReaderTemplate
{
    public EventReader( Controller inControl )
    {
        control = inControl;
    }

    protected void processLine(String[] fields)
    {
        // FIRST = year
        // SECOND = type -> W,R,V followed by +/-
        // THIRD = property name (R/V only)
    }

//---------------------------------------------------------------------------
}
