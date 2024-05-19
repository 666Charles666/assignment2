package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmartWatchTest {
    private SmartWatch validSmartWatch,invalidSmartWatch;
    @After
    public void teardown(){
        validSmartWatch=invalidSmartWatch=null;
    }

    @Before
    public void setup(){
        Manufacturer manufacturer = new Manufacturer("Apple", 333);
        //copied from the WearableDeviceTest
        validSmartWatch = new SmartWatch("DoraWatch",1500,manufacturer,"123211","metal","8888","LED");
        invalidSmartWatch = new SmartWatch("Dorrrrrrrrrrrawwwwwwwatcccch",6.6,manufacturer,"1269486589901","goodgodgreatwonderfullymetal","99909999999","LLL");
    }

    @Test
    public void testSetDisplayType(){
        validSmartWatch.setDisplayType("AMOLED");
        assertEquals("AMOLED",validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("LSO");
        assertEquals("AMOLED",validSmartWatch.getDisplayType());
    }
    @Test
    public void testGetDisplayType(){
        assertEquals("LED",validSmartWatch.getDisplayType());
        assertEquals("LCD",invalidSmartWatch.getDisplayType());
    }
    @Test
    public void testToString(){
        String expected1 = "DisplayType: LED";
        assertTrue(validSmartWatch.toString().contains(expected1));
        String expected2 = "DisplayType: LCD";
        assertTrue(invalidSmartWatch.toString().contains(expected2));
    }

}