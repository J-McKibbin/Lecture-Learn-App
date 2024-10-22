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
public class LabTest {
    
    public LabTest() {
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
     * Test of setNumberOfPCs method, of class Lab.
     */
    @Test
    public void testSetNumberOfPCs() {
        System.out.println("setNumberOfPCs");
        int numberOfPCs = 20;
        Lab instance = new Lab("lab1", 10, 2, 15,15,"Windows");
        instance.setNumberOfPCs(numberOfPCs);
        int expResult = 20;
        int result = instance.getNumberOfPCs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfPCs method, of class Lab.
     */
    @Test
    public void testGetNumberOfPCs() {
        System.out.println("getNumberOfPCs");
        Lab instance = new Lab("lab1", 10, 2, 15,15,"Windows");
        int expResult = 15;
        int result = instance.getNumberOfPCs();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOperatingSystem method, of class Lab.
     */
    @Test
    public void testSetOperatingSystem() {
        System.out.println("setOperatingSystem");
        String operatingSystem = "MacOS";
        Lab instance = new Lab("lab1", 10, 2, 15,15,"Windows");
        instance.setOperatingSystem(operatingSystem);
        String expResult = "MacOS";
        String result = instance.getOperatingSystem();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOperatingSystem method, of class Lab.
     */
    @Test
    public void testGetOperatingSystem() {
        System.out.println("getOperatingSystem");
        Lab instance = new Lab("lab1", 10, 2, 15,15,"Windows");
        String expResult = "Windows";
        String result = instance.getOperatingSystem();
        assertEquals(expResult, result);
    }
    
}
