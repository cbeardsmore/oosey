/***************************************************************************
*	FILE: Planeader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Take plan fields and process into a plan object
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/

public class PlanReader extends ReaderTemplate
{
    public PlanReader( Controller inControl )
    {
        control = inControl;
    }

    protected void processLine(String[] fields)
    {
        // FIRST = year
        // SECOND = type -> B for BUY, S for SELL
        // THIRD = property name
    }

//---------------------------------------------------------------------------
}
