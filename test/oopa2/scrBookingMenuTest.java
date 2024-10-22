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
public class scrBookingMenuTest {
    
    public scrBookingMenuTest() {
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
     * Test of resetAddBooking method, of class scrBookingMenu.
     */
    @Test
    public void testResetAddBooking() {
        System.out.println("resetAddBooking");
        scrBookingMenu instance = new scrBookingMenu();
        instance.resetAddBooking();
    }

    /**
     * Test of createBookingID method, of class scrBookingMenu.
     */
    @Test
    public void testCreateBookingID() {
        System.out.println("createBookingID");
        scrBookingMenu instance = new scrBookingMenu();
        instance.createBookingID();
    }

    /**
     * Test of validateRoomID method, of class scrBookingMenu.
     */
    @Test
    public void testValidateRoomID() {
        System.out.println("validateRoomID");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validateRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class scrBookingMenu.
     */
    @Test
    public void testValidateDate() {
        System.out.println("validateDate");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validateDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTime method, of class scrBookingMenu.
     */
    @Test
    public void testValidateTime() {
        System.out.println("validateTime");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePerson method, of class scrBookingMenu.
     */
    @Test
    public void testValidatePerson() {
        System.out.println("validatePerson");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validatePerson();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmail method, of class scrBookingMenu.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validateEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePhone method, of class scrBookingMenu.
     */
    @Test
    public void testValidatePhone() {
        System.out.println("validatePhone");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = false;
        boolean result = instance.validatePhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of createBooking method, of class scrBookingMenu.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        scrBookingMenu instance = new scrBookingMenu();
        instance.createBooking();
    }

    /**
     * Test of validateUniqueBooking method, of class scrBookingMenu.
     */
    @Test
    public void testValidateUniqueBooking() {
        System.out.println("validateUniqueBooking");
        scrBookingMenu instance = new scrBookingMenu();
        boolean expResult = true;
        boolean result = instance.validateUniqueBooking();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchBooking method, of class scrBookingMenu.
     */
    @Test
    public void testSearchBooking() {
        System.out.println("searchBooking");
        scrBookingMenu instance = new scrBookingMenu();
        instance.searchBooking();
    }

    /**
     * Test of deleteBooking method, of class scrBookingMenu.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        scrBookingMenu instance = new scrBookingMenu();
        instance.deleteBooking();
    }

    /**
     * Test of main method, of class scrBookingMenu.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        scrBookingMenu.main(args);
    }
    
}
