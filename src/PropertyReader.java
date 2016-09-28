/***************************************************************************
*	FILE: PropertyReader.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE:
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/

public class PropertyReader extends ReaderTemplate
{
    public PropertyReader( Controller inControl )
    {
        control = inControl;
    }

    protected void processLine(String[] fields)
    {
        // FIRST = property name
        // SECOND = type -> C or B
        // THIRD = owner
        // FOURTH = value
        // FIFTH = revenue (business only)
        // SIXTH = wages (business only)
    }

//---------------------------------------------------------------------------
}
