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
public class BookingTest {
    
    public BookingTest() {
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
     * Test of getBookingId method, of class Booking.
     */
    @Test
    public void testGetBookingId() {
        System.out.println("getBookingId");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        int expResult = 1;
        int result = instance.getBookingId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoomID method, of class Booking.
     */
    @Test
    public void testGetRoomID() {
        System.out.println("getRoomID");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "lab1";
        String result = instance.getRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomId method, of class Booking.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        String roomId = "lab5";
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        instance.setRoomId(roomId);
        String expResult = "lab5";
        String result = instance.getRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Booking.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "10/06/2024";
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        instance.setDate(date);
        String expResult = "10/06/2024";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Booking.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "10/06/2024";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class Booking.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        String time = "09:00 - 11:00";
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        instance.setTime(time);
        String expResult = "09:00 - 11:00";
        String result = instance.getTime();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTime method, of class Booking.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "09:00 - 11:00";
        String result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactPerson method, of class Booking.
     */
    @Test
    public void testGetContactPerson() {
        System.out.println("getContactPerson");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "David Hoggins";
        String result = instance.getContactPerson();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactEmail method, of class Booking.
     */
    @Test
    public void testGetContactEmail() {
        System.out.println("getContactEmail");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "hoggins234@email.com";
        String result = instance.getContactEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactPhone method, of class Booking.
     */
    @Test
    public void testGetContactPhone() {
        System.out.println("getContactPhone");
        Booking instance = new Booking(1, "lab1", "10/06/2024", "09:00 - 11:00", "David Hoggins",
        "hoggins234@email.com", "07654356765");
        String expResult = "07654356765";
        String result = instance.getContactPhone();
        assertEquals(expResult, result);
    }
    
}
