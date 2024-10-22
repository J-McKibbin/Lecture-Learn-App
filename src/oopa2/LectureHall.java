
package oopa2;

public class LectureHall extends Room{
    private String microphoneType;
    private Boolean tieredSeating;
    
    public LectureHall(String roomID, int roomNumber, int floor, int capacity, String microphoneType, Boolean tieredSeating){
        super(roomID, roomNumber, floor, capacity);   
        this.microphoneType = microphoneType;
        this.tieredSeating = tieredSeating;
        AppLib.lectureHalls.add(this);
   }
    
    public void setMicrophoneType(String microphoneType){
        this.microphoneType = microphoneType;
    }
    
    public String getMicrophoneType(){
        return microphoneType;
    }
    
    public void setTieredSeating(Boolean tieredSeating){
        this.tieredSeating = tieredSeating;
    }
    
    public Boolean getTieredSeating(){
        return tieredSeating;
    }
}
