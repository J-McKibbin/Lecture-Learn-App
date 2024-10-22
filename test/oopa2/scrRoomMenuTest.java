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
public class scrRoomMenuTest {
    
    public scrRoomMenuTest() {
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
     * Test of dynamicFormFields method, of class scrRoomMenu.
     */
    @Test
    public void testDynamicFormFields() {
        System.out.println("dynamicFormFields");
        scrRoomMenu instance = new scrRoomMenu();
        instance.dynamicFormFields();
    }

    /**
     * Test of createLabID method, of class scrRoomMenu.
     */
    @Test
    public void testCreateLabID() {
        System.out.println("createLabID");
        scrRoomMenu instance = new scrRoomMenu();
        instance.createLabID();
    }

    /**
     * Test of createLectureHallID method, of class scrRoomMenu.
     */
    @Test
    public void testCreateLectureHallID() {
        System.out.println("createLectureHallID");
        scrRoomMenu instance = new scrRoomMenu();
        instance.createLectureHallID();
    }

    /**
     * Test of lecturehallSelectedSeating method, of class scrRoomMenu.
     */
    @Test
    public void testLecturehallSelectedSeating() {
        System.out.println("lecturehallSelectedSeating");
        scrRoomMenu instance = new scrRoomMenu();
        boolean expResult = true;
        boolean result = instance.lecturehallSelectedSeating();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRoomNumber method, of class scrRoomMenu.
     */
    @Test
    public void testValidateRoomNumber() {
        System.out.println("validateRoomNumber");
        scrRoomMenu instance = new scrRoomMenu();
        boolean expResult = false;
        boolean result = instance.validateRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateFloor method, of class scrRoomMenu.
     */
    @Test
    public void testValidateFloor() {
        System.out.println("validateFloor");
        scrRoomMenu instance = new scrRoomMenu();
        boolean expResult = false;
        boolean result = instance.validateFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCapacity method, of class scrRoomMenu.
     */
    @Test
    public void testValidateCapacity() {
        System.out.println("validateCapacity");
        scrRoomMenu instance = new scrRoomMenu();
        boolean expResult = false;
        boolean result = instance.validateCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUniqueRoom method, of class scrRoomMenu.
     */
    @Test
    public void testValidateUniqueRoom() {
        System.out.println("validateUniqueRoom");
        scrRoomMenu instance = new scrRoomMenu();
        boolean expResult = false;
        boolean result = instance.validateUniqueRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of viewLab method, of class scrRoomMenu.
     */
    @Test
    public void testViewLab() {
        System.out.println("viewLab");
        String requestedRoomID = "";
        scrRoomMenu instance = new scrRoomMenu();
        Lab expResult = null;
        Lab result = instance.viewLab(requestedRoomID);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewHall method, of class scrRoomMenu.
     */
    @Test
    public void testViewHall() {
        System.out.println("viewHall");
        String requestedRoomID = "";
        scrRoomMenu instance = new scrRoomMenu();
        LectureHall expResult = null;
        LectureHall result = instance.viewHall(requestedRoomID);
        assertEquals(expResult, result);
    }

    /**
     * Test of resetRoomDetails method, of class scrRoomMenu.
     */
    @Test
    public void testResetRoomDetails() {
        System.out.println("resetRoomDetails");
        scrRoomMenu instance = new scrRoomMenu();
        instance.resetRoomDetails();
    }

    /**
     * Test of addNewLab method, of class scrRoomMenu.
     */
    @Test
    public void testAddNewLab() {
        System.out.println("addNewLab");
        scrRoomMenu instance = new scrRoomMenu();
        instance.addNewLab();
    }

    /**
     * Test of addNewLectureHall method, of class scrRoomMenu.
     */
    @Test
    public void testAddNewLectureHall() {
        System.out.println("addNewLectureHall");
        scrRoomMenu instance = new scrRoomMenu();
        instance.addNewLectureHall();
    }

    /**
     * Test of getAllRooms method, of class scrRoomMenu.
     */
    @Test
    public void testGetAllRooms() {
        System.out.println("getAllRooms");
        scrRoomMenu instance = new scrRoomMenu();
        instance.getAllRooms();
    }

    /**
     * Test of main method, of class scrRoomMenu.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        scrRoomMenu.main(args);
    }
    
}
