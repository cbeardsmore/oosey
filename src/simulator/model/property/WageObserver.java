/***************************************************************************
*	FILE: WageObserver.java
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: Observer for all BusinessUnits who's Wage could globally change
*   LAST MOD: 28/09/16
*   REQUIRES: NONE
***************************************************************************/
package simulator.model.property;

public interface WageObserver
{
    public void updateWage(boolean isIncrease);
}
