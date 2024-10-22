
package oopa2;

public class Room {
    
    private String roomID;
    private int roomNumber;
    private int floor;
    private int capacity;

    //room constructor
    Room(String roomID, int roomNumber, int floor, int capacity){
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.capacity = capacity;
    }
    
    public String getRoomID(){
        return roomID;
    }
    
    public void setRoomID(String roomID){
        this.roomID = roomID;
    }
    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
    public void setFloor(int floor){
        this.floor = floor;
    }
    
    public int getFloor(){
        return floor;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public int getCapacity(){
        return capacity;
    }
}//class
