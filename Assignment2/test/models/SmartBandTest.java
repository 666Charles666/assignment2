package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SmartBandTest {
    private SmartBand validSmartBand,invalidSmartBand;

    @After
    public void teardown(){
        validSmartBand = invalidSmartBand = null;
    }
    @Before
    public void setUp(){
        Manufacturer manufacturer = new Manufacturer("MI", 333);
        //same to COMPUTERTEST
        validSmartBand = new SmartBand("MIBand",9888,manufacturer,"9999",
                "glass","40000",true);
        invalidSmartBand = new SmartBand("MISuperMaxxxxxxxxxxBand 8pro",8.8,manufacturer,"14243123",
                "glassglassglassglasspropropro","100000000000000",false);
    }

    @Test
    public void testIsHeatRateMonitor(){
        assertTrue(validSmartBand.isHeartRateMonitor());
        assertFalse(invalidSmartBand.isHeartRateMonitor());
    }

    @Test
    public void testSetHeartRateMonitor(){
        validSmartBand.setHeartRateMonitor(false);
        assertFalse(validSmartBand.isHeartRateMonitor());
        invalidSmartBand.setHeartRateMonitor(true);
        assertTrue(invalidSmartBand.isHeartRateMonitor());
    }

    @Test
    public void testToString(){
        String expected1 = "Includes Heart Rate Monitor";
        assertTrue(validSmartBand.toString().contains(expected1));
        String expected2 = "No Heart Rate Monitor includes";
        assertTrue(invalidSmartBand.toString().contains(expected2));
    }

}
