
package oopa2;
//run the main in order to start the program
public class main {

    public static void main(String[] args) {
        //start splashscreen
        scrSplashScreen ss = new scrSplashScreen();
        ss.startSplashScreen();
        //create some instances for exmaple purposes
        Lab newLab = new Lab("lab1", 1, 2, 50,25,"Windows");
        Lab newLab2 = new Lab("lab2", 5, 2, 70,70,"MacOS");
        Lab newLab3 = new Lab("lab3", 3, 2, 80,80,"Linux");
        LectureHall newLectureHall = new LectureHall("hall1", 10, 2, 5,"Ribbon", false);
        LectureHall newLectureHall2 = new LectureHall("hall2", 50, 3, 50,"Dynamic", true);
        Booking newBooking = new Booking(1, "lab1", "e", "10:00", "Jim", "harry@yahoo.com", "07090234545");
        Booking newBooking2 = new Booking(2, "lab2", "01/06/2024", "09:00 - 17:00 (All Day)", "Jim Bob", "jim@email.com", "09090334545");
        Booking newBooking3 = new Booking(3, "lab2", "02/06/2024", "09:00 - 11:00", "Alan Duffy", "smurry23@gmail.com", "07090334545");
        Booking newBooking4 = new Booking(4, "hall1", "02/06/2024", "11:00 - 13:00", "Sarah Davies", "jim@email.com", "07090334454");
        Booking newBooking5 = new Booking(5, "hall1", "02/06/2024", "09:00 - 11:00", "Timoth alan", "david@email.com", "09090334454");
    }
    
}
