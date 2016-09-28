/***************************************************************************
*	FILE: Controller
*	AUTHOR: Connor Beardsmore - 15504319
*	UNIT: OOSE200
*	PURPOSE: BusinessUnit Model
*   LAST MOD: 28/09/16
*   REQUIRES: Property
***************************************************************************/
import java.util.Map;
import java.util.HashMap;

public class Controller
{
    //CLASSFIELDS
    private Map<String,Property> propMap;
//---------------------------------------------------------------------------
    public Controller()
    {
        propMap = new HashMap<String,Property>();
    }

//---------------------------------------------------------------------------

    public Property setProperty(String name, Property prop)
    {
        return propMap.put( name, prop );
    }
//---------------------------------------------------------------------------

    public Property getProperty(String name)
    {
        return propMap.get(name);
    }

//---------------------------------------------------------------------------

    public String toString()
    {
        String state = "PROPERTY MAP CONTENTS\n";
        state += "---------------------\n";

        for ( Map.Entry<String,Property> entry : propMap.entrySet() )
        {
            if ( entry.getValue() != null )
                state += entry.getValue().toString() + "\n" ;
        }

        return state;
    }

//---------------------------------------------------------------------------
}
