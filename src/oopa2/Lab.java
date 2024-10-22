
    package oopa2;

 
    public class Lab extends Room{
        int numberOfPCs;
        String operatingSystem;
    
    public Lab(String roomID, int roomNumber, int floor, int capacity, int numberOfPCs, String operatingSystem){
        super(roomID, roomNumber, floor, capacity);
        this.numberOfPCs = numberOfPCs;
        this.operatingSystem = operatingSystem;
        AppLib.labs.add(this);
    }
    
    public void setNumberOfPCs(int numberOfPCs){
        this.numberOfPCs = numberOfPCs;
    }
    
    public int getNumberOfPCs(){
        return numberOfPCs;
    }
    
    public void setOperatingSystem(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }
    
    public String getOperatingSystem(){
        return operatingSystem;
    }
    
}
