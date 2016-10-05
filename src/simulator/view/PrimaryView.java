/***************************************************************************
*	FILE: BusinessUnit.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.view;

import simulator.model.*;
import simulator.controller.*;

public class PrimaryView
{
    private Controller control;

//---------------------------------------------------------------------------

    public PrimaryView( Controller inControl )
    {
        control = inControl;
    }

//---------------------------------------------------------------------------

    public void output(String outputString)
    {
        System.out.println(outputString);
    }

//---------------------------------------------------------------------------
}
