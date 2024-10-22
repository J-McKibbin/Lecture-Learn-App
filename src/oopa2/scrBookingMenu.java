
package oopa2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jonnymckibbin
 */
public class scrBookingMenu extends javax.swing.JFrame {

    /**
     * Creates new form scrBookingMenu
     */
    public scrBookingMenu() {
        initComponents();
    }

    public void resetAddBooking(){
        txtFieldAddBookingID.setText("");
        txtFieldAddRoomID.setText("");
        txtFieldAddBookingID.setText("");
        txtFieldAddDate.setText("");
        txtFieldAddPerson.setText("");
        txtFieldAddPhone.setText("");
        txtFieldAddEmail.setText("");
        ddlAddTime.setSelectedItem("Select");
        lblSubmissionMessage.setText("");
    }
    
    //generate a unique booking ID 
    public void createBookingID(){
        Random random = new Random();
        int newID = random.nextInt(100);
        boolean uniqueID = false;
        while(!uniqueID){
            uniqueID = true;
            for(Booking booking:AppLib.bookings){
                int checkBookingID = booking.getBookingId();
                if(newID == checkBookingID){
                    uniqueID = false;
                    break;
                }
            }
            if(uniqueID){
                txtFieldAddBookingID.setText(String.valueOf(newID));
                break;
            }
        }
    }
    
    //validation on room ID field
    public boolean validateRoomID(){
        try{
            String roomID = txtFieldAddRoomID.getText();
            if(roomID.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid room ID starting with 'lab' or 'hall'");
                return false;
            }else if(!roomID.startsWith("lab") && !roomID.startsWith("hall")){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid room ID starting with 'lab' or 'hall' ");
                return false;
            }else if(roomID.startsWith("lab")){
                for(Lab lab:AppLib.labs){
                    if(roomID.equals(lab.getRoomID())){
                        return true;
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "Room ID doesn't exist");
                return false;
            }else if(roomID.startsWith("hall")){
                for(LectureHall hall:AppLib.lectureHalls){
                    if(roomID.equals(hall.getRoomID())){
                        return true;
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "Room ID doesn't exist");
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Enter a valid room ID");
            return false;
        }//exception handling
        return false;
    }//method
    
    
    //validation on date text field
    public boolean validateDate(){
        try{
            String date = txtFieldAddDate.getText();
            String pattern = "\\d{2}[/-]\\d{2}[/-]\\d{4}";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate enteredDate = LocalDate.parse(date, formatter);
            LocalDate currentDate = LocalDate.now();
            if(date.matches(pattern) && enteredDate.isAfter(currentDate)){
                return true;
            }else if(enteredDate.isBefore(currentDate)){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid date in the future");
                return false;
            }else{
                JOptionPane.showMessageDialog(rootPane, "Enter a valid date e.g 10/05/2024");
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Enter a valid date in the future e.g 10/05/2024");
            return false;
        }
    }//method
    
    
    public boolean validateTime(){
        try{        
            if(ddlAddTime.getSelectedItem().equals("Select")){
            JOptionPane.showMessageDialog(rootPane, "Select a valid time");
            return false;
            }else{
                return true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Select a valid time");
            return false;
        }
    }//method
    
    public boolean validatePerson(){
        try{
            //regex pattern set for a forename with a space and then a surname
            String regexPattern = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$";
            String person = txtFieldAddPerson.getText();
            if(person.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a contact persons name");
                return false;
            }else if(person.matches(regexPattern)){
                return true;
            }else{
                JOptionPane.showMessageDialog(rootPane, "Enter a valid full name e.g. John Lewis");
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Enter a valid full name e.g. John Lewis");
            return false;
        }
    }//method
    
    public boolean validateEmail(){
        try{
            String regexPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String email = txtFieldAddEmail.getText();
            if(email.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a contact email e.g. jim65@gmail.com");
                return false;
            }else if(email.matches(regexPattern)){
                return true;
            }else{
                JOptionPane.showMessageDialog(rootPane, "Enter a valid email e.g. jim65@gmail.com");
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Enter a valid email e.g. jim65@gmail.com");
                return false;
        }
    }//method
    
    public boolean validatePhone(){
        try{
            String phone = txtFieldAddPhone.getText();
            if(phone.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid phone number e.g 07505904343");
                return false;
            }else if(!phone.matches("\\d{11}")){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid 11 digit phone number e.g 07505904343");
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Enter a valid 11 digit phone number e.g 07505904343");
            return false;
        }
    }
    
    //create a booking object
    public void createBooking(){
        try{
        //get all information inputted by user
        int bookingID = Integer.parseInt(txtFieldAddBookingID.getText());
        String roomID = txtFieldAddRoomID.getText();
        String date = txtFieldAddDate.getText();
        String time = ddlAddTime.getSelectedItem().toString();
        String person = txtFieldAddPerson.getText();
        String email = txtFieldAddEmail.getText();
        String phone = txtFieldAddPhone.getText();
        
        //create message for user to confirm details
        String message = "Booking ID: " + bookingID + "\n" + "Room ID: " + roomID
        + "\n" + "Date: " + date + "\n" + "Booking time: " + time + "\n" + "Contact Person: "
        + person + "\n" + "Contact Email: " + email + "\n" + "Contact phonenumber: " + phone;
        
        int option = JOptionPane.showConfirmDialog(rootPane, message,
        "Confirm Booking Details",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        //if the user confirms then the object is created
        if(option == JOptionPane.OK_OPTION){
            //create new booking with inputted info
            Booking newBooking = new Booking(bookingID, roomID, date, time, person,
            email,phone);
            lblSubmissionMessage.setText("Booking created!");
            //if the user doesn't confirm then the object isnt created
        }else{
            lblSubmissionMessage.setText("Booking creation cancelled");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "An error occured try again...");
        }
    }//method
    
    
    public boolean validateUniqueBooking(){
        try{
            String roomID = txtFieldAddRoomID.getText();
            String date = txtFieldAddDate.getText();
            String time = ddlAddTime.getSelectedItem().toString();
            if(!roomID.equals(null) && !date.equals(null) && !time.equals(null)){
            for(Booking booking:AppLib.bookings){
                String checkRoomID = booking.getRoomID();
                String checkTime = booking.getTime();
                String checkDate = booking.getDate();
                if(roomID.equals(checkRoomID) && date.equals(checkDate)){
                    if(time.equals("09:00 - 17:00 (All Day)") && checkTime.equals("09:00 - 17:00 (All Day)")){
                        JOptionPane.showMessageDialog(rootPane, "This day has already been fully booked");
                        return false;
                    }else if (time.contains("09:00") && (checkTime.equals("09:00 - 13:00 (Morning)")
                    || checkTime.equals("09:00 - 17:00 (All Day)") || checkTime.equals("09:00 - 11:00"))) {
                        JOptionPane.showMessageDialog(rootPane, "This time is not available try another");
                        return false; 
                    }else if (time.contains("11:00") && (checkTime.equals("09:00 - 13:00 (Morning)")
                    ||checkTime.equals("09:00 - 17:00") || checkTime.equals("11:00 - 13:00"))) {
                        JOptionPane.showMessageDialog(rootPane, "This time is not available try another");
                        return false; 
                    } else if (time.contains("13:00") && (checkTime.equals("13:00 - 17:00 (Afternoon)")
                        || checkTime.contains("09:00 - 17:00 (All Day)") || checkTime.equals("13:00 - 15:00"))) {
                        JOptionPane.showMessageDialog(rootPane, "This time is not available try another");
                        return false; 
                    }else if(time.contains("15:00") && (checkTime.equals("13:00 - 17:00 (Afternoon)")
                        || checkTime.equals("09:00 - 17:00 (All Day)") ||checkTime.equals("15:00 - 17:00"))){
                        JOptionPane.showMessageDialog(rootPane, "This time is not available try another");
                        return false;
                    }
                }
            }
            }else{
                return false;
            }
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "An error occurred try again");
            return false;
        }
    }//method
    

    
    public void searchBooking(){
        try{
            int requestedBooking = Integer.parseInt(txtFieldSearchBookingID.getText());
            boolean bookingFound = false;
            //create an arraylist to hold bookings that need to be deleted
            if(requestedBooking != 0){
                for(Booking booking:AppLib.bookings){
                if(booking.getBookingId() == requestedBooking){
                    String requestedBookingRoomID = booking.getRoomID();
                    if(requestedBookingRoomID.contains("lab")){
                        for(Lab lab:AppLib.labs){
                            if(requestedBookingRoomID.equals(lab.getRoomID())){
                                String roomID = lab.getRoomID();
                                int roomNumber = lab.getRoomNumber();
                                int floor = lab.getFloor();
                                int capacity = lab.getCapacity();
                                int numberOfPCs = lab.getNumberOfPCs();
                                String operatingSystem = lab.getOperatingSystem();
                                String date = booking.getDate();
                                String time = booking.getTime();
                                String contact = booking.getContactPerson();
                                String phoneNumber = booking.getContactPhone();
                                String email = booking.getContactEmail();
                                //creating string for searched booking
                                String message = "Booking Details" + "\nBooking ID: " + requestedBooking + "\n"
                                + "Date: " + date + "\n" + "Time: " + time + "\n"
                                +"Contact Person: " + contact + "\n" + "Phone number: "
                                + phoneNumber + "\n" + "Email: " + email +"\n\n"
                                + "Room Details" + "\nRoom Type: Lab" + "\nRoom ID: " + roomID + "\n"
                                + "Room Number: " + roomNumber + "\nFloor: " + floor
                                + "\nCapacity: " + capacity + "\nNumber of PC's: "
                                + numberOfPCs + "\nOperating System: " + operatingSystem;
                                JOptionPane.showMessageDialog(rootPane, message);
                                
                                //set latest searched labels
                                lblViewBookingID.setText(String.valueOf(booking.getBookingId()));
                                lblViewDate.setText(date);
                                lblViewEmail.setText(email);
                                lblViewTime.setText(time);
                                lblViewRoomID.setText(roomID);
                                lblViewPhoneNumber.setText(phoneNumber);
                                lblViewContact.setText(contact);
                                //set flag to true as the booking was found
                                bookingFound = true;
                            }
                        }//inner for loop
                    }else if(requestedBookingRoomID.contains("hall")){
                        for(LectureHall hall:AppLib.lectureHalls){
                            if(requestedBookingRoomID.equals(hall.getRoomID())){
                                String roomID = hall.getRoomID();
                                int roomNumber = hall.getRoomNumber();
                                int floor = hall.getFloor();
                                int capacity = hall.getCapacity();
                                String microphoneType = hall.getMicrophoneType();  
                                boolean tieredSeating = hall.getTieredSeating();
                                String strTieredSeating;
                                if(tieredSeating == true){
                                    strTieredSeating = "yes";
                                }else{strTieredSeating = " no";}
                                String date = booking.getDate();
                                String time = booking.getTime();
                                String contact = booking.getContactPerson();
                                String phoneNumber = booking.getContactPhone();
                                String email = booking.getContactEmail();
                                //creating string for searched booking
                                String message = "Booking Details" + "\nBooking ID: " + requestedBookingRoomID + "\n"
                                + "Date: " + date + "\n" + "Time: " + time + "\n"
                                +"Contact Person: " + contact + "\n" + "Phone number: "
                                + phoneNumber + "\n" + "Email: " + email +"\n\n"
                                + "Room Details" +"\nRoom Type: Lecture Hall"+ "\nRoom ID: " + roomID + "\n"
                                + "Room Number: " + roomNumber + "\nFloor: " + floor
                                + "\nCapacity: " + capacity + "\nMicrophone: "
                                + microphoneType + "\nTiered Seating: " + strTieredSeating;
                                JOptionPane.showMessageDialog(rootPane, message);
                                lblViewBookingID.setText(String.valueOf(booking.getBookingId()));
                                lblViewDate.setText(date);
                                lblViewEmail.setText(email);
                                lblViewTime.setText(time);
                                lblViewRoomID.setText(roomID);
                                lblViewPhoneNumber.setText(phoneNumber);
                                lblViewContact.setText(contact);
                                bookingFound = true;
                            }//inner inner conditional
                        }//inner for loop
                    }//inner conditional
                }
            }//for loop
            }
            if(!bookingFound){
                JOptionPane.showMessageDialog(rootPane, "Booking Doesn't Exist");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Invalid booking ID, booking IDs are only numbers e.g 45");
        }//exception handling
    }//method
    
    public void deleteBooking(){
        try{
        int deleteBookingID = Integer.parseInt(txtFieldBookingID.getText());
        boolean bookingFound = false;
        ArrayList<Booking> bookingsToDelete = new ArrayList<>();
        for(Booking booking :AppLib.bookings){
            int checkBookingID = booking.getBookingId();
            if(deleteBookingID == checkBookingID){
                String date = booking.getDate();
                String time = booking.getTime();
                String contact = booking.getContactPerson();
                String phoneNumber = booking.getContactPhone();
                String email = booking.getContactEmail();
                String roomID = booking.getRoomID();
                String message = "Booking Details" + "\nBooking ID: " + deleteBookingID + "\nRoom ID: "
                                +roomID + "\nDate: " + date + "\nTime: " + time
                                +"\nContact Person: " + contact + "\n" + "Phone number: "
                                + phoneNumber + "\n" + "Email: " + email;
                bookingFound = true;
                int option = JOptionPane.showConfirmDialog(rootPane, message,
                "Confirm booking deletion",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                if(option == JOptionPane.OK_OPTION){
//                    AppLib.bookings.remove(booking);
                      bookingsToDelete.add(booking);
                    lblDeletedMessage.setText("Booking Deleted");
                }else{
                    lblDeletedMessage.setText("Booking not deleted");
                }
            }//conditional
        }
        AppLib.bookings.removeAll(bookingsToDelete);
        if(!bookingFound){
            JOptionPane.showMessageDialog(rootPane, "Unable to find booking");
        }//conditional
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Unable to find booking");
            System.out.println("An error occured");
        }//exception handling
    }//method
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBookingMenu = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanelAddBooking = new javax.swing.JPanel();
        lblAddBooking = new javax.swing.JLabel();
        lblAddBookingID = new javax.swing.JLabel();
        txtFieldAddBookingID = new javax.swing.JTextField();
        lblAddRoomID = new javax.swing.JLabel();
        txtFieldAddRoomID = new javax.swing.JTextField();
        ddlAddTime = new javax.swing.JComboBox<>();
        lblAddTime = new javax.swing.JLabel();
        lblAddDate = new javax.swing.JLabel();
        txtFieldAddDate = new javax.swing.JTextField();
        lblAddPerson = new javax.swing.JLabel();
        lblAddEmail = new javax.swing.JLabel();
        lblAddPhone = new javax.swing.JLabel();
        txtFieldAddPerson = new javax.swing.JTextField();
        txtFieldAddEmail = new javax.swing.JTextField();
        txtFieldAddPhone = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblSubmissionMessage = new javax.swing.JLabel();
        jPanelViewBooking = new javax.swing.JPanel();
        lblViewBooking = new javax.swing.JLabel();
        lblSearchBookingID = new javax.swing.JLabel();
        txtFieldSearchBookingID = new javax.swing.JTextField();
        btnSearchBooking = new javax.swing.JButton();
        lblLastViewed = new javax.swing.JLabel();
        lblBookingID = new javax.swing.JLabel();
        lblViewBookingID = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblRoomID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblContactPerson = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblViewDate = new javax.swing.JLabel();
        lblViewContact = new javax.swing.JLabel();
        lblViewPhoneNumber = new javax.swing.JLabel();
        lblViewEmail = new javax.swing.JLabel();
        lblViewRoomID = new javax.swing.JLabel();
        lblViewTime = new javax.swing.JLabel();
        btnViewAllBookings = new javax.swing.JButton();
        jPanelDeleteBooking = new javax.swing.JPanel();
        lblDeleteBooking = new javax.swing.JLabel();
        lblDeleteBookingID = new javax.swing.JLabel();
        txtFieldBookingID = new javax.swing.JTextField();
        btnDeleteBooking = new javax.swing.JButton();
        lblDeletedMessage = new javax.swing.JLabel();
        jPanelBackground = new javax.swing.JPanel();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 700));
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(850, 700));
        setSize(new java.awt.Dimension(780, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBookingMenu.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblBookingMenu.setText("Booking Menu");
        getContentPane().add(lblBookingMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jPanelHeader.setBackground(new java.awt.Color(29, 94, 115));
        jPanelHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelHeader.setPreferredSize(new java.awt.Dimension(900, 80));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LectureLearn");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("™");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel4)))
                .addContainerGap(786, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 990, -1));

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 41));

        jPanelAddBooking.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAddBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblAddBooking.setText("Add Booking");

        lblAddBookingID.setText("Booking ID");

        txtFieldAddBookingID.setEditable(false);
        txtFieldAddBookingID.setText("Auto Assigned");

        lblAddRoomID.setText("Room ID");

        ddlAddTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "09:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00", "15:00 - 17:00", "09:00 - 13:00 (Morning)", "13:00 - 17:00 (Afternoon)", "09:00 - 17:00 (All Day)" }));

        lblAddTime.setText("Time");

        lblAddDate.setText("Date (dd/mm/yyyy)");

        lblAddPerson.setText("Contact Person");

        lblAddEmail.setText("Contact Email");

        lblAddPhone.setText("Contact Phone");

        btnReset.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblSubmissionMessage.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelAddBookingLayout = new javax.swing.GroupLayout(jPanelAddBooking);
        jPanelAddBooking.setLayout(jPanelAddBookingLayout);
        jPanelAddBookingLayout.setHorizontalGroup(
            jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                        .addComponent(lblAddBooking)
                        .addGap(208, 208, 208)
                        .addComponent(lblSubmissionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldAddBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddRoomID)
                            .addComponent(txtFieldAddRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddTime)
                            .addComponent(ddlAddTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddPerson)
                            .addComponent(txtFieldAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddEmail)
                            .addComponent(txtFieldAddEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddPhone)
                            .addComponent(txtFieldAddPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddBookingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddBookingLayout.createSequentialGroup()
                    .addContainerGap(682, Short.MAX_VALUE)
                    .addComponent(btnSubmit)
                    .addGap(24, 24, 24)))
        );
        jPanelAddBookingLayout.setVerticalGroup(
            jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddBookingLayout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(lblSubmissionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                                .addComponent(lblAddTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ddlAddTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAddBookingLayout.createSequentialGroup()
                                .addComponent(lblAddBooking)
                                .addGap(24, 24, 24)
                                .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddBookingID)
                                    .addComponent(lblAddRoomID)
                                    .addComponent(lblAddDate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFieldAddBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldAddRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddPerson)
                            .addComponent(lblAddEmail)
                            .addComponent(lblAddPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldAddEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldAddPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelAddBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddBookingLayout.createSequentialGroup()
                    .addContainerGap(169, Short.MAX_VALUE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)))
        );

        getContentPane().add(jPanelAddBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 790, -1));

        jPanelViewBooking.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelViewBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblViewBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblViewBooking.setText("View Booking");
        jPanelViewBooking.add(lblViewBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        lblSearchBookingID.setText("Booking ID");
        jPanelViewBooking.add(lblSearchBookingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtFieldSearchBookingID.setToolTipText("");
        jPanelViewBooking.add(txtFieldSearchBookingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));

        btnSearchBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSearchBooking.setText("Submit");
        btnSearchBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookingActionPerformed(evt);
            }
        });
        jPanelViewBooking.add(btnSearchBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 133, -1, 30));

        lblLastViewed.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblLastViewed.setText("Last Viewed");
        jPanelViewBooking.add(lblLastViewed, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        lblBookingID.setText("BookingID:");
        jPanelViewBooking.add(lblBookingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        lblViewBookingID.setText("N/a");
        jPanelViewBooking.add(lblViewBookingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        lblTime.setText("Time:");
        jPanelViewBooking.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        lblRoomID.setText("Room ID:");
        jPanelViewBooking.add(lblRoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        lblDate.setText("Date:");
        jPanelViewBooking.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        lblContactPerson.setText("Contact Person:");
        jPanelViewBooking.add(lblContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        lblPhoneNumber.setText("Phone number:");
        jPanelViewBooking.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        lblEmail.setText("Email:");
        jPanelViewBooking.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        lblViewDate.setText("N/a");
        jPanelViewBooking.add(lblViewDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        lblViewContact.setText("N/a");
        jPanelViewBooking.add(lblViewContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        lblViewPhoneNumber.setText("N/a");
        lblViewPhoneNumber.setToolTipText("");
        jPanelViewBooking.add(lblViewPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        lblViewEmail.setText("N/a");
        jPanelViewBooking.add(lblViewEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        lblViewRoomID.setText("N/a");
        jPanelViewBooking.add(lblViewRoomID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        lblViewTime.setText("N/a");
        jPanelViewBooking.add(lblViewTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        btnViewAllBookings.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnViewAllBookings.setText("View all Bookings");
        btnViewAllBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllBookingsActionPerformed(evt);
            }
        });
        jPanelViewBooking.add(btnViewAllBookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        getContentPane().add(jPanelViewBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 600, 180));

        jPanelDeleteBooking.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDeleteBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblDeleteBooking.setText("Delete Booking");

        lblDeleteBookingID.setText("Booking ID");

        btnDeleteBooking.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnDeleteBooking.setText("Delete");
        btnDeleteBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookingActionPerformed(evt);
            }
        });

        lblDeletedMessage.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDeletedMessage.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanelDeleteBookingLayout = new javax.swing.GroupLayout(jPanelDeleteBooking);
        jPanelDeleteBooking.setLayout(jPanelDeleteBookingLayout);
        jPanelDeleteBookingLayout.setHorizontalGroup(
            jPanelDeleteBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteBookingLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblDeletedMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelDeleteBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDeleteBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDeleteBooking)
                    .addGroup(jPanelDeleteBookingLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelDeleteBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDeleteBookingID)
                            .addComponent(txtFieldBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDeleteBooking))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelDeleteBookingLayout.setVerticalGroup(
            jPanelDeleteBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDeleteBooking)
                .addGap(12, 12, 12)
                .addComponent(lblDeleteBookingID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDeletedMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanelDeleteBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 180, 180));

        jPanelBackground.setBackground(new java.awt.Color(255, 255, 255));

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopa2/icons8-help-48.png"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setBorder(null);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap(792, Short.MAX_VALUE)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(536, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 860, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AppLib.bookingMenu.setVisible(false);
        AppLib.mainMenu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //validation on inputted fields
        if(validateRoomID() && validateDate() && validateTime()
        && validatePerson() && validateEmail() && validatePhone()
        && validateUniqueBooking()){
//          formatDateField();
            //booking id is automatically generated
            createBookingID();
            //booking object is created from inputted information after being validated
            createBooking();
        }else{

        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetAddBooking();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookingActionPerformed
        searchBooking();
    }//GEN-LAST:event_btnSearchBookingActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
        deleteBooking();
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "The Booking Menu enables you to"
        + " create new bookings\nview bookings that already exist and delete bookings"
                + "\nTry entering details, you cant go wrong!");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnViewAllBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllBookingsActionPerformed
        AppLib.bookingList = new scrBookingList();
        AppLib.bookingList.setVisible(true);
        AppLib.bookingMenu.setVisible(false);
    }//GEN-LAST:event_btnViewAllBookingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(scrBookingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scrBookingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scrBookingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrBookingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scrBookingMenu().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearchBooking;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewAllBookings;
    private javax.swing.JComboBox<String> ddlAddTime;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelAddBooking;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelDeleteBooking;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelViewBooking;
    private javax.swing.JLabel lblAddBooking;
    private javax.swing.JLabel lblAddBookingID;
    private javax.swing.JLabel lblAddDate;
    private javax.swing.JLabel lblAddEmail;
    private javax.swing.JLabel lblAddPerson;
    private javax.swing.JLabel lblAddPhone;
    private javax.swing.JLabel lblAddRoomID;
    private javax.swing.JLabel lblAddTime;
    private javax.swing.JLabel lblBookingID;
    private javax.swing.JLabel lblBookingMenu;
    private javax.swing.JLabel lblContactPerson;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeleteBooking;
    private javax.swing.JLabel lblDeleteBookingID;
    private javax.swing.JLabel lblDeletedMessage;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLastViewed;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblRoomID;
    private javax.swing.JLabel lblSearchBookingID;
    private javax.swing.JLabel lblSubmissionMessage;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblViewBooking;
    private javax.swing.JLabel lblViewBookingID;
    private javax.swing.JLabel lblViewContact;
    private javax.swing.JLabel lblViewDate;
    private javax.swing.JLabel lblViewEmail;
    private javax.swing.JLabel lblViewPhoneNumber;
    private javax.swing.JLabel lblViewRoomID;
    private javax.swing.JLabel lblViewTime;
    private javax.swing.JTextField txtFieldAddBookingID;
    private javax.swing.JTextField txtFieldAddDate;
    private javax.swing.JTextField txtFieldAddEmail;
    private javax.swing.JTextField txtFieldAddPerson;
    private javax.swing.JTextField txtFieldAddPhone;
    private javax.swing.JTextField txtFieldAddRoomID;
    private javax.swing.JTextField txtFieldBookingID;
    private javax.swing.JTextField txtFieldSearchBookingID;
    // End of variables declaration//GEN-END:variables
}
