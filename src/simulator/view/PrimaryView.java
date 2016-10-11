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
//---------------------------------------------------------------------------

    public PrimaryView() {}

//---------------------------------------------------------------------------

    public void output(String outputString)
    {
        System.out.println(outputString);
    }

//---------------------------------------------------------------------------
    //NAME: welcome()
    //PURPOSE: General Welcome message to user on system startup

    public void welcome()
    {
        System.out.println("\n------COMPANY SIMULATOR 2016------");
        System.out.println("---Connor Beardsmore - 15504319---");
        System.out.println("----------------------------------\n");

    }

//---------------------------------------------------------------------------
}
