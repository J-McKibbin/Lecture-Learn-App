
package oopa2;
import java.util.Random;
import java.util.*;


public class Booking {
    
    private int bookingID;
    private String roomID;
    private String date;
    private String time;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    //storing booking objects
    
    Booking(int bookingID, String roomID, String date, String time, String contactPerson, String contactEmail, String contactPhone){
        this.bookingID = bookingID;
        this.roomID = roomID;
        this.date = date;
        this.time = time;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        AppLib.bookings.add(this);
    }
    
    public int getBookingId(){
        return bookingID;
    }
    
    public void setBookingID(int bookingID){
        this.bookingID = bookingID;
    }
    
    public String getRoomID(){
        return roomID;
    }
    public void setRoomId(String roomId){
        this.roomID = roomId;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    public String getTime(){
        return time;
    }
    
    public String getContactPerson(){
        return contactPerson;
    }
    
    public String getContactEmail(){
        return contactEmail;
    }
    
    public String getContactPhone(){
        return contactPhone;
    }
}//class
    
    


