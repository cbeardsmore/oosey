/***************************************************************************
*	FILE: WageObserver.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Observer for all BusinessUnits who's Wage could globally change
*   LAST MOD: 11/10/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public interface WageObserver
{
    //CONSTANTS
    public static final double WAGE_CHANGE = 0.05;

//---------------------------------------------------------------------------
    //Methods to be implemented in all Observers implementing this interface

    public void increaseWages();
    public void decreaseWages();

//---------------------------------------------------------------------------
}
