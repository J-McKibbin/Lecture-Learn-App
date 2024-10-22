/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package oopa2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonnymckibbin
 */
public class LectureHallTest {
    
    public LectureHallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setMicrophoneType method, of class LectureHall.
     */
    @Test
    public void testSetMicrophoneType() {
        System.out.println("setMicrophoneType");
        String microphoneType = "Ribbon";
        LectureHall instance = new LectureHall("hall1", 10, 2, 50,"Dynamic", true);
        instance.setMicrophoneType(microphoneType);
        String expResult = "Ribbon";
        String result = instance.getMicrophoneType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMicrophoneType method, of class LectureHall.
     */
    @Test
    public void testGetMicrophoneType() {
        System.out.println("getMicrophoneType");
        LectureHall instance = new LectureHall("hall1", 10, 2, 50,"Dynamic", true);
        String expResult = "Dynamic";
        String result = instance.getMicrophoneType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTieredSeating method, of class LectureHall.
     */
    @Test
    public void testSetTieredSeating() {
        System.out.println("setTieredSeating");
        Boolean tieredSeating = false;
        LectureHall instance = new LectureHall("hall1", 10, 2, 50,"Dynamic", true);
        instance.setTieredSeating(tieredSeating);
        boolean expResult = false;
        boolean result = instance.getTieredSeating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTieredSeating method, of class LectureHall.
     */
    @Test
    public void testGetTieredSeating() {
        System.out.println("getTieredSeating");
        LectureHall instance = new LectureHall("hall1", 10, 2, 50,"Dynamic", true);
        Boolean expResult = true;
        Boolean result = instance.getTieredSeating();
        assertEquals(expResult, result);
    }
    
}
