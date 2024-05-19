package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WearableDeviceTest {
    private SmartWatch validSmartWatch, inValidSmartWatchTest;
    @After
    public void teardown(){validSmartWatch= inValidSmartWatchTest =null;}
    @Before
    public void setup(){
        Manufacturer manufacturer = new Manufacturer("Samsung", 333);
        Manufacturer invalidManufacturer = new Manufacturer("ABCDEFGHIJKLMNOPQRSTU", 0);
        //same to ComputingDeviceTest
        validSmartWatch = new SmartWatch("HUAWEIWATCH",10888,manufacturer,"22010","plastic","7000","LED");
        inValidSmartWatchTest = new SmartWatch( "HUAWEIWATCH 2 Max PPPPPPPPPPPPPPPPRO",11,manufacturer,"22222222222","great plastic--plastic pro","568263786454","LCD");
    }
    @Test
    public void testGetMaterial(){
        assertEquals("medal",validSmartWatch.getMaterial());
        assertEquals("InValid Material", inValidSmartWatchTest.getMaterial());
    }

    @Test
    public void testGetSize(){
        assertEquals("7000",validSmartWatch.getSize());
        assertEquals("InValid Size", inValidSmartWatchTest.getSize());
    }

    @Test
    public void testSetMaterial(){
        validSmartWatch.setMaterial("Plastic");
        assertEquals("Plastic",validSmartWatch.getMaterial());
        validSmartWatch.setMaterial("great plastic--plastic pro");
        assertEquals("Plastic",validSmartWatch.getMaterial());
    }

    @Test
    public void testSetSize(){
        validSmartWatch.setSize("0000");
        assertEquals("0000",validSmartWatch.getSize());
        validSmartWatch.setSize("568263786454");
        assertEquals("0000",validSmartWatch.getSize());
    }

    @Test
    public void testToString(){
        String expected1 = "Material: plastic, Size: 7000";
        assertTrue(validSmartWatch.toString().contains(expected1));
        String expected2 = "Material: InValid, Size: InValid";
        assertTrue(inValidSmartWatchTest.toString().contains(expected2));
    }
}




