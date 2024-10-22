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
public class RoomTest {
    
    public RoomTest() {
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
     * Test of getRoomID method, of class Room.
     */
    @Test
    public void testGetRoomID() {
        System.out.println("getRoomID");
        Room instance = new Room("lab1", 26, 5, 100);
        String expResult = "lab1";
        String result = instance.getRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomID method, of class Room.
     */
    @Test
    public void testSetRoomID() {
        System.out.println("setRoomID");
        String roomID = "lab54";
        Room instance = new Room("lab1", 26, 5, 100);
        instance.setRoomID(roomID);
        String expResult = "lab54";
        String result = instance.getRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomNumber method, of class Room.
     */
    @Test
    public void testSetRoomNumber() {
        System.out.println("setRoomNumber");
        int roomNumber = 14;
        Room instance = new Room("lab1", 26, 5, 100);
        instance.setRoomNumber(roomNumber);
        int expResult = 14;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoomNumber method, of class Room.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Room instance = new Room("lab1", 26, 5, 100);
        int expResult = 26;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFloor method, of class Room.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        int floor = 23;
        Room instance = new Room("lab1", 26, 5, 100);
        instance.setFloor(floor);
        int expResult = 23;
        int result = instance.getFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFloor method, of class Room.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        Room instance = new Room("lab1", 26, 5, 100);
        int expResult = 5;
        int result = instance.getFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacity method, of class Room.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 150;
        Room instance = new Room("lab1", 26, 5, 100);
        instance.setCapacity(capacity);
        int expResult = 150;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacity method, of class Room.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Room instance = new Room("lab1", 26, 5, 100);
        int expResult = 100;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }
    
}
