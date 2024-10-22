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
public class scrMainMenuTest {
    
    public scrMainMenuTest() {
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
     * Test of exitProgram method, of class scrMainMenu.
     */
    @Test
    public void testExitProgram() {
        System.out.println("exitProgram");
        scrMainMenu instance = new scrMainMenu();
        instance.exitProgram();
    }

    /**
     * Test of main method, of class scrMainMenu.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        scrMainMenu.main(args);
    }
    
}
