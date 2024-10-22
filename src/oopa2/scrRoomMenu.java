/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oopa2;

import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * @author jonnymckibbin
 */
public class scrRoomMenu extends javax.swing.JFrame {

    /**
     * Creates new form scrRoomMenu
     */
    public scrRoomMenu() {
        initComponents();
        //call method to ensure users can only see one room type
        dynamicFormFields();
    }
    
    
    //method for form fields changing depending on radio button chosen
    public void dynamicFormFields(){
        //set radio button selected to true
        rdoBtnLectureHall.setSelected(true);
        if (rdoBtnLectureHall.isSelected()){
            ddlMicrophoneType.setVisible(true);
            lblMicrophoneType.setVisible(true);
            lblNumOfPCs.setVisible(false);
            spinnerNumOfPCs.setVisible(false);
            lblOperatingSystem.setVisible(false);
            lblTieredSeating.setVisible(true);
            rdoBtnYes.setVisible(true);
            rdoBtnNo.setVisible(true);
            ddlOperatingSystem.setVisible(false);
        }else if (rdoBtnLab.isSelected()){
            lblNumOfPCs.setVisible(true);
            spinnerNumOfPCs.setVisible(true);
            ddlMicrophoneType.setVisible(false);
            lblMicrophoneType.setVisible(false);
            
            lblOperatingSystem.setVisible(true);
            lblTieredSeating.setVisible(false);
            rdoBtnYes.setVisible(false);
            rdoBtnNo.setVisible(false);
            ddlOperatingSystem.setVisible(true);
        }
    }
    
    //generating a lab ID
    public void createLabID(){
        if(rdoBtnLab.isSelected()){
            Random random = new Random();
            boolean uniqueID = false;
            while(!uniqueID){
            String labID = "lab" + random.nextInt(100);
            uniqueID = true;
                for(Lab lab:AppLib.labs){
                    String checkLabID = lab.getRoomID();
                    if(labID.equals(checkLabID)){
                        uniqueID = false;
                        break;
                    }
                }
                if(uniqueID){
                txtFieldRoomID.setText(labID);
                break;
                }
            }
        }
    }//method
    
        //generating a lecturehall ID
        public final void createLectureHallID(){
        if(rdoBtnLectureHall.isSelected()){
            Random random = new Random();
            boolean uniqueID = false;
            while(!uniqueID){
            String lecturehallID = "hall" + random.nextInt(100);
            uniqueID = true;
                for(LectureHall hall:AppLib.lectureHalls){
                    String checkHallID = hall.getRoomID();
                    if(lecturehallID.equals(checkHallID)){
                        uniqueID = false;
                        break;
                    }
                }
                if(uniqueID){
                    txtFieldRoomID.setText(lecturehallID);
                break;
                }
            }
        }
    }//method
    
    //method for 
    public boolean lecturehallSelectedSeating(){
            if (rdoBtnYes.isSelected()){
                return true;
            }else if (rdoBtnNo.isSelected()){
                return false;
            }   
            return false;
    }//method
    

    public boolean validateRoomNumber(){
        try{
            String strRoomNumber = txtFieldRoomNumber.getText();
            int roomNumber = Integer.parseInt(strRoomNumber);
            if(strRoomNumber.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a room Number between 1 and 100");
                return false;
            }else if(roomNumber < 1 || roomNumber > 100){
                JOptionPane.showMessageDialog(rootPane, "Room number must be between 1 and 100");
                return false;
            }else{
                return true;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Room number must be between 1 and 100");
            return false;
        }   
    }//method 
    
    
    public boolean validateFloor(){
        try{
            String strFloor = txtFieldFloor.getText();
            int floor = Integer.parseInt(strFloor);
            if(strFloor.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a floor number between 1 and 5");
                return false;
            }else if(floor < 0 || floor > 5){
                JOptionPane.showMessageDialog(rootPane, "Enter a floor number between 1 and 5");
                return false;
            }else{
                return true;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Enter a floor number between 1 and 5");
            return false;
        }
    }
    
    public boolean validateCapacity(){
        try{
            String strCapacity = txtFieldCapacity.getText();
            int capacity = Integer.parseInt(strCapacity);
            if(strCapacity.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter a capacity between 10 and 100");
                return false;
            }else if(capacity < 10 || capacity > 100){
                JOptionPane.showMessageDialog(rootPane, "Enter a capacity between 10 and 100");
                return false;
            }else{
                return true;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Enter a capacity between 10 and 100");
            return false;
        }
    }
   
        //method for ensuring room duplicates arent created
    public boolean validateUniqueRoom(){
        try{
            String strFloor = txtFieldFloor.getText();
            String strRoomNumber = txtFieldRoomNumber.getText();
            int floor = Integer.parseInt(strFloor);
            int roomNumber = Integer.parseInt(strRoomNumber);
            //check if the room and floor combination exist
            for (LectureHall lecturehall:AppLib.lectureHalls){
                int checkRoomNum = lecturehall.getRoomNumber();
                int checkFloor = lecturehall.getFloor();
                if(floor == checkFloor && roomNumber == checkRoomNum){
                    JOptionPane.showMessageDialog(rootPane, "Room Number: " + roomNumber  + "\n" + "Floor: " + floor
                    + "\n" + "\nAlready exists, enter a different room number or floor");
                return false;
                }
            }for (Lab lab:AppLib.labs){
                int checkRoomNum = lab.getRoomNumber();
                int checkFloor = lab.getFloor();
                if(floor == checkFloor && roomNumber == checkRoomNum){
                    JOptionPane.showMessageDialog(rootPane, "Room Number: " + roomNumber  + "\n" + "Floor: " + floor
                    + "\n" + "\nAlready exists, enter a different room number or floor");
                return false;
                }
            }
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "An error occurred try again");
            return false;
        }
    }//method
    

    //request room detils and return room object to be used
    public Lab viewLab(String requestedRoomID){
        //take input for room number, check this input against arraylist
        if (requestedRoomID.startsWith("lab")){
            for (Lab requestedLab : AppLib.labs){
                String currentID = requestedLab.getRoomID();
                if(currentID.equals(requestedRoomID)){
                    return requestedLab;
                }
            }//for loop
        }
        return null;
    }//method
    
    //request room details for lecture halls
    public LectureHall viewHall(String requestedRoomID){
        //take input for room number, check this input against arraylist
        if (requestedRoomID.startsWith("hall")){
            for (LectureHall requestedHall : AppLib.lectureHalls){
                String currentID = requestedHall.getRoomID();
                if(currentID.equals(requestedRoomID)){
                    return requestedHall;
                }
            }//for loop
        }else{
            return null;
        }
        return null;
    }//method
    
    public void resetRoomDetails(){
        txtFieldRequestRoomID.setText("");
        txtFieldRoomID.setText("Auto Assigned");
        lblGetRoomID.setText("N/a");
        lblGetRoomNumber.setText("N/a");
        lblGetRoomType.setText("N/a");
        lblGetFloor.setText("N/a");
        lblGetCapacity.setText("N/a");
        lblGetTieredSeating.setText("N/a");
        lblGetOperatingSystem.setText("N/a");
        lblGetMicrophoneType.setText("N/a");
        lblGetNumberOfPCs.setText("N/a");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomTypeGroup = new javax.swing.ButtonGroup();
        tieredSeatingGroup = new javax.swing.ButtonGroup();
        jPanelLogo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelAddRoom = new javax.swing.JPanel();
        lblAddRoom = new javax.swing.JLabel();
        txtFieldRoomID = new javax.swing.JTextField();
        lblRoomID = new javax.swing.JLabel();
        lblRoomNumber = new javax.swing.JLabel();
        txtFieldRoomNumber = new javax.swing.JTextField();
        lblFloor = new javax.swing.JLabel();
        txtFieldFloor = new javax.swing.JTextField();
        lblCapacity = new javax.swing.JLabel();
        txtFieldCapacity = new javax.swing.JTextField();
        rdoBtnLectureHall = new javax.swing.JRadioButton();
        rdoBtnLab = new javax.swing.JRadioButton();
        lblRoomType = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        spinnerNumOfPCs = new javax.swing.JSpinner();
        ddlMicrophoneType = new javax.swing.JComboBox<>();
        lblNumOfPCs = new javax.swing.JLabel();
        lblMicrophoneType = new javax.swing.JLabel();
        lblTieredSeating = new javax.swing.JLabel();
        rdoBtnYes = new javax.swing.JRadioButton();
        rdoBtnNo = new javax.swing.JRadioButton();
        ddlOperatingSystem = new javax.swing.JComboBox<>();
        lblOperatingSystem = new javax.swing.JLabel();
        btnSubmitNewRoom = new javax.swing.JButton();
        lblSubmissionMessage = new javax.swing.JLabel();
        jPanelViewRoom = new javax.swing.JPanel();
        lblViewroom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFieldRequestRoomID = new javax.swing.JTextField();
        lblViewRoomID = new javax.swing.JLabel();
        lblGetRoomID = new javax.swing.JLabel();
        lblViewFloor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGetFloor = new javax.swing.JLabel();
        lblViewRoomNumber = new javax.swing.JLabel();
        lblViewCapacity = new javax.swing.JLabel();
        lblGetCapacity = new javax.swing.JLabel();
        lblGetRoomNumber = new javax.swing.JLabel();
        lblViewRoomType = new javax.swing.JLabel();
        lblGetRoomType = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGetNumberOfPCs = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSubmitRoomID = new javax.swing.JButton();
        lblGetMicrophoneType = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGetOperatingSystem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblGetTieredSeating = new javax.swing.JLabel();
        btnResetForm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblRoomMenu = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLogo.setBackground(new java.awt.Color(29, 94, 115));
        jPanelLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LectureLearn");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("™");

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLogoLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel4)))
                .addContainerGap(695, Short.MAX_VALUE))
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 899, -1));

        jPanelAddRoom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAddRoom.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblAddRoom.setText("Add New Room");

        txtFieldRoomID.setEditable(false);
        txtFieldRoomID.setText("AutoAssigned");
        txtFieldRoomID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblRoomID.setText("Room ID ");

        lblRoomNumber.setText("Room Number");

        txtFieldRoomNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFloor.setText("Floor");

        txtFieldFloor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCapacity.setText("Capacity");

        txtFieldCapacity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roomTypeGroup.add(rdoBtnLectureHall);
        rdoBtnLectureHall.setSelected(true);
        rdoBtnLectureHall.setText("Lecture Hall");
        rdoBtnLectureHall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoBtnLectureHall.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoBtnLectureHallItemStateChanged(evt);
            }
        });

        roomTypeGroup.add(rdoBtnLab);
        rdoBtnLab.setText("Lab");
        rdoBtnLab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdoBtnLab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoBtnLabItemStateChanged(evt);
            }
        });

        lblRoomType.setText("Room type");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spinnerNumOfPCs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(spinnerNumOfPCs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        ddlMicrophoneType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Condenser", "Dynamic", "Ribbon" }));
        ddlMicrophoneType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(ddlMicrophoneType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblNumOfPCs.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNumOfPCs.setText("No of PC's");
        jPanel4.add(lblNumOfPCs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblMicrophoneType.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblMicrophoneType.setText("Microphone Type");
        jPanel4.add(lblMicrophoneType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblTieredSeating.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblTieredSeating.setText("Tiered Seating");
        jPanel4.add(lblTieredSeating, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 100, -1));

        tieredSeatingGroup.add(rdoBtnYes);
        rdoBtnYes.setSelected(true);
        rdoBtnYes.setText("Yes");
        rdoBtnYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(rdoBtnYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        tieredSeatingGroup.add(rdoBtnNo);
        rdoBtnNo.setText("No");
        rdoBtnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(rdoBtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        ddlOperatingSystem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Windows", "MacOS", "Linux" }));
        jPanel4.add(ddlOperatingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        lblOperatingSystem.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblOperatingSystem.setText("Operating System");
        jPanel4.add(lblOperatingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, 20));

        btnSubmitNewRoom.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnSubmitNewRoom.setText("Submit");
        btnSubmitNewRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmitNewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitNewRoomActionPerformed(evt);
            }
        });
        jPanel4.add(btnSubmitNewRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 93, 38));

        lblSubmissionMessage.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelAddRoomLayout = new javax.swing.GroupLayout(jPanelAddRoom);
        jPanelAddRoom.setLayout(jPanelAddRoomLayout);
        jPanelAddRoomLayout.setHorizontalGroup(
            jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblAddRoom)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddRoomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddRoomLayout.createSequentialGroup()
                                .addComponent(lblRoomID)
                                .addGap(42, 42, 42)
                                .addComponent(lblFloor)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddRoomLayout.createSequentialGroup()
                                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFieldRoomID, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(lblRoomNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFieldRoomNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCapacity, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldCapacity, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldFloor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddRoomLayout.createSequentialGroup()
                        .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoBtnLectureHall)
                                    .addComponent(rdoBtnLab))
                                .addGap(18, 18, 18))
                            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                                .addComponent(lblRoomType)
                                .addGap(29, 29, 29)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddRoomLayout.createSequentialGroup()
                        .addComponent(lblSubmissionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        jPanelAddRoomLayout.setVerticalGroup(
            jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAddRoom)
                        .addGap(27, 27, 27)
                        .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRoomID)
                            .addComponent(lblFloor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                                .addComponent(txtFieldRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRoomNumber)
                                    .addComponent(lblCapacity))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFieldRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblSubmissionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanelAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAddRoomLayout.createSequentialGroup()
                                .addComponent(lblRoomType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoBtnLectureHall)
                                .addGap(8, 8, 8)
                                .addComponent(rdoBtnLab))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelAddRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 142, 780, 180));

        jPanelViewRoom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblViewroom.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblViewroom.setText("View Room");

        jLabel1.setText("Room ID");

        txtFieldRequestRoomID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFieldRequestRoomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldRequestRoomIDActionPerformed(evt);
            }
        });

        lblViewRoomID.setText("Room ID");

        lblGetRoomID.setText("N/a");

        lblViewFloor.setText("Floor");

        lblGetFloor.setText("N/a");

        lblViewRoomNumber.setText("Room Number");

        lblViewCapacity.setText("Capacity");

        lblGetCapacity.setText("N/a");

        lblGetRoomNumber.setText("N/a");

        lblViewRoomType.setText("Room Type");

        lblGetRoomType.setText("N/a");

        jLabel5.setText("Number of PCs");

        lblGetNumberOfPCs.setText("N/a");

        jLabel7.setText("Microphone Type");

        btnSubmitRoomID.setBackground(new java.awt.Color(153, 255, 153));
        btnSubmitRoomID.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSubmitRoomID.setText("Submit");
        btnSubmitRoomID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSubmitRoomID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmitRoomID.setOpaque(true);
        btnSubmitRoomID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitRoomIDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitRoomIDMouseExited(evt);
            }
        });
        btnSubmitRoomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitRoomIDActionPerformed(evt);
            }
        });

        lblGetMicrophoneType.setText("N/a");

        jLabel9.setText("Operating System");

        lblGetOperatingSystem.setText("N/a");

        jLabel11.setText("Tiered Seating");

        lblGetTieredSeating.setText("N/a");

        btnResetForm.setBackground(new java.awt.Color(255, 102, 102));
        btnResetForm.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnResetForm.setText("Reset");
        btnResetForm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetForm.setOpaque(true);
        btnResetForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetFormMouseExited(evt);
            }
        });
        btnResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFormActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setText("All Rooms");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelViewRoomLayout = new javax.swing.GroupLayout(jPanelViewRoom);
        jPanelViewRoom.setLayout(jPanelViewRoomLayout);
        jPanelViewRoomLayout.setHorizontalGroup(
            jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(lblViewroom))
                        .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jLabel1)))
                    .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnResetForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFieldRequestRoomID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addComponent(btnSubmitRoomID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(61, 61, 61)
                .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                        .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblViewFloor)
                            .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                                .addComponent(lblGetRoomID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(lblViewRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblViewRoomNumber)
                            .addComponent(lblViewCapacity)
                            .addComponent(lblGetRoomNumber)
                            .addComponent(lblGetCapacity))
                        .addGap(33, 33, 33)
                        .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblViewRoomType)
                            .addComponent(lblGetRoomType))
                        .addGap(40, 40, 40)
                        .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(lblGetMicrophoneType)
                            .addComponent(lblGetTieredSeating))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGetOperatingSystem)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(lblGetNumberOfPCs))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                        .addComponent(lblGetFloor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );
        jPanelViewRoomLayout.setVerticalGroup(
            jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblViewroom)
                .addGap(15, 15, 15)
                .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                        .addComponent(lblViewRoomNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGetRoomNumber)
                        .addGap(18, 18, 18)
                        .addComponent(lblViewCapacity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGetCapacity))
                    .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelViewRoomLayout.createSequentialGroup()
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblViewRoomType)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblGetRoomType)
                                .addComponent(lblGetOperatingSystem)
                                .addComponent(lblGetTieredSeating))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGetMicrophoneType))
                                .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGetNumberOfPCs))))
                        .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lblViewRoomID))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFieldRequestRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblGetRoomID)
                                .addComponent(jLabel2))
                            .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lblViewFloor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGetFloor))
                                .addGroup(jPanelViewRoomLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btnSubmitRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelViewRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelViewRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 330, 784, 200));

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 86, -1, 41));

        lblRoomMenu.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblRoomMenu.setText("Room Menu");
        getContentPane().add(lblRoomMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 98, 231, 29));

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopa2/icons8-help-48.png"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setBorder(null);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 50, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoBtnLabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoBtnLabItemStateChanged
        if (rdoBtnLab.isSelected()){
            spinnerNumOfPCs.setValue(0);
            ddlOperatingSystem.setSelectedItem("Select");
            lblNumOfPCs.setVisible(true);
            spinnerNumOfPCs.setVisible(true);
            ddlMicrophoneType.setVisible(false);
            lblMicrophoneType.setVisible(false);
            
            lblOperatingSystem.setVisible(true);
            lblTieredSeating.setVisible(false);
            rdoBtnYes.setVisible(false);
            rdoBtnNo.setVisible(false);
            ddlOperatingSystem.setVisible(true);
        }
    }//GEN-LAST:event_rdoBtnLabItemStateChanged

    private void rdoBtnLectureHallItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoBtnLectureHallItemStateChanged
        if (rdoBtnLectureHall.isSelected()){
            ddlMicrophoneType.setSelectedItem("Select");
            rdoBtnYes.setSelected(true);
            ddlMicrophoneType.setVisible(true);
            lblMicrophoneType.setVisible(true);
            lblNumOfPCs.setVisible(false);
            spinnerNumOfPCs.setVisible(false);
            lblOperatingSystem.setVisible(false);
            lblTieredSeating.setVisible(true);
            rdoBtnYes.setVisible(true);
            rdoBtnNo.setVisible(true);
            ddlOperatingSystem.setVisible(false);
        }
    }//GEN-LAST:event_rdoBtnLectureHallItemStateChanged

    public void addNewLab(){
        try{
            String roomID = txtFieldRoomID.getText();
            int roomNumber = Integer.parseInt(txtFieldRoomNumber.getText());
            int floor = Integer.parseInt(txtFieldFloor.getText());
            int capacity = Integer.parseInt(txtFieldCapacity.getText());
            int numOfPCs = (int) spinnerNumOfPCs.getValue();
            String operatingSystem = ddlOperatingSystem.getSelectedItem().toString();
            //creating new object using inputted values

            String message = "Room ID: " + roomID + "\n" +
            "Room Number: " + roomNumber + "\n" +
            "Floor: " + floor + "\n" +
            "Capacity: " + capacity + "\n" +
            "Number of PCs: " + numOfPCs + "\n" +
            "Operating System: " + operatingSystem;

            int option = JOptionPane.showConfirmDialog(rootPane, message,
            "Confirm Room Details",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(option == JOptionPane.OK_OPTION){
                Lab newLab = new Lab(roomID, roomNumber, floor, capacity, numOfPCs, operatingSystem);
                lblSubmissionMessage.setText("Room Created!");
            }else{
                lblSubmissionMessage.setText("Room creation cancelled");
            }
        }catch(Exception e){
            lblSubmissionMessage.setText("Room creation cancelled");
            JOptionPane.showMessageDialog(rootPane, "An error occurred try again");
        }
    }
    
    public void addNewLectureHall(){
        try{
            String roomID = txtFieldRoomID.getText();
            int roomNumber = Integer.parseInt(txtFieldRoomNumber.getText());
            int floor = Integer.parseInt(txtFieldFloor.getText());
            int capacity = Integer.parseInt(txtFieldCapacity.getText());
            String microphoneType = ddlMicrophoneType.getSelectedItem().toString();
            boolean tieredSeating = lecturehallSelectedSeating();
            String strTieredSeating;
            if (tieredSeating){
                 strTieredSeating = "Yes";
            }else{
                 strTieredSeating= "No";
            }
            //message for confirmation popup
            String message = "Room ID: " + roomID + "\n" +
            "Room Number: " + roomNumber + "\n" +
            "Floor: " + floor + "\n" +
            "Capacity: " + capacity + "\n" + "Microphone Type: "
            + microphoneType + "\n" + "Tiered Seating: "
            + strTieredSeating;
            //creating popup when the function is called
            int option = JOptionPane.showConfirmDialog(rootPane, message,
            "Confirm Room Details",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            //if the user confirms then the object is created
            if(option == JOptionPane.OK_OPTION){
                LectureHall newLectureHall = new LectureHall(roomID, roomNumber, floor, capacity, microphoneType, tieredSeating);
                lblSubmissionMessage.setText("Room Created!");
                System.out.println(newLectureHall.getRoomID());
                //if the user doesn't confirm then the object isnt created
            }else{
                lblSubmissionMessage.setText("Room creation cancelled");
            }
        }catch(Exception e){
            lblSubmissionMessage.setText("Room creation cancelled");
            JOptionPane.showMessageDialog(rootPane, "An error occurred try again");
        }
    }
    
    
    private void btnSubmitNewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitNewRoomActionPerformed
        //validation for text fields
        //if the lab radio button is selected the details are validated and a lab is created
        if (rdoBtnLab.isSelected()){
            //set the lab id to randomly generated id
            createLabID();
            //validation on text fields
            if(!validateRoomNumber() || !validateFloor() || !validateCapacity()
                || !validateUniqueRoom()){
            //validation on room specific fields
            }else if((int) spinnerNumOfPCs.getValue() < 1 || (int) spinnerNumOfPCs.getValue() > 100){
                JOptionPane.showMessageDialog(rootPane, "Number of PCs must be more than 0 and less than 101");
            }else if(ddlOperatingSystem.getSelectedItem().equals("Select")){
                JOptionPane.showMessageDialog(rootPane, "Select an operating system");
            }else{
                //lab object is created
                addNewLab();
                Timer timer = new Timer(3500, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtFieldRoomID.setText("Auto Assigned");
                    txtFieldRoomNumber.setText("");
                    txtFieldFloor.setText("");
                    txtFieldCapacity.setText("");
                    lblSubmissionMessage.setText("");
                    spinnerNumOfPCs.setValue(0);
                    ddlOperatingSystem.setSelectedItem("Select");
                    ((Timer) evt.getSource()).stop();
                }
            });
            timer.start();
            }
        //if the lecturehall radio button is selected the details are validated and a lecturehall is created    
        }else if(rdoBtnLectureHall.isSelected()){
            //Create lecture hall ID
            createLectureHallID();
            //validation on text fields
            if(!validateRoomNumber() || !validateFloor() || !validateCapacity()
                || !validateUniqueRoom()){
            //validation on room specific field
            }else if(ddlMicrophoneType.getSelectedItem().equals("Select")){
                JOptionPane.showMessageDialog(rootPane, "Please select a microphone type");
            }else{
                //lecture hall object is created
                addNewLectureHall();
                //timer is created to clear the fields once the details have been submitted
                Timer timer = new Timer(3500, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtFieldRoomID.setText(""); // Clear the text field
                    txtFieldRoomNumber.setText("");
                    txtFieldFloor.setText("");
                    txtFieldCapacity.setText("");
                    lblSubmissionMessage.setText("");
                    spinnerNumOfPCs.setValue(0);
                    ddlOperatingSystem.setSelectedItem("Select");
                    //the timer is stopped after the fields have been cleared
                    ((Timer) evt.getSource()).stop();
                }
            });
            //timer is started
            timer.start();
            }//inner conditional
        }//outer conditional
    }//GEN-LAST:event_btnSubmitNewRoomActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AppLib.roomMenu.setVisible(false);
        AppLib.mainMenu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFieldRequestRoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldRequestRoomIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldRequestRoomIDActionPerformed
    

    //method for user requesting room details
    private void btnSubmitRoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitRoomIDActionPerformed
        String requestedRoomID = txtFieldRequestRoomID.getText();
        if (requestedRoomID.startsWith("lab")){
            Lab requestedLab = viewLab(requestedRoomID);
            if(requestedLab != null){
                lblGetRoomID.setText(requestedLab.getRoomID());
                lblGetRoomNumber.setText(Integer.toString(requestedLab.getRoomNumber()));
                lblGetFloor.setText(Integer.toString(requestedLab.getFloor()));
                lblGetCapacity.setText(Integer.toString(requestedLab.getCapacity()));
                lblGetRoomType.setText("Lab");
                lblGetOperatingSystem.setText(requestedLab.getOperatingSystem());
                lblGetNumberOfPCs.setText(Integer.toString(requestedLab.getNumberOfPCs()));
            }else{
                JOptionPane.showMessageDialog(rootPane, "Room not found, enter an existing ID");
                resetRoomDetails();
            }

        }else if (requestedRoomID.startsWith("hall")){
            LectureHall requestedHall = viewHall(requestedRoomID);
            if(requestedHall != null && !requestedRoomID.isEmpty()){
                //call method for viewing lecture halls
                lblGetRoomID.setText(requestedHall.getRoomID());
                lblGetRoomNumber.setText(Integer.toString(requestedHall.getRoomNumber()));
                lblGetFloor.setText(Integer.toString(requestedHall.getFloor()));
                lblGetCapacity.setText(Integer.toString(requestedHall.getCapacity()));
                lblGetRoomType.setText("Lecture Hall");
                lblGetMicrophoneType.setText(requestedHall.getMicrophoneType());
                boolean tieredSeating = requestedHall.getTieredSeating();
                if (tieredSeating == true){
                    lblGetTieredSeating.setText("Yes");
                }else{
                    lblGetTieredSeating.setText("no");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Room not found, enter an existing room ID");
                resetRoomDetails();
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Room not found, enter an existing room ID");
            resetRoomDetails();
        }
    }//GEN-LAST:event_btnSubmitRoomIDActionPerformed

    private void btnResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFormActionPerformed
        resetRoomDetails();
    }//GEN-LAST:event_btnResetFormActionPerformed

    private void btnSubmitRoomIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitRoomIDMouseEntered
       btnSubmitRoomID.setBackground(Color.green);
    }//GEN-LAST:event_btnSubmitRoomIDMouseEntered

    private void btnSubmitRoomIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitRoomIDMouseExited
        btnSubmitRoomID.setBackground(new java.awt.Color(153,255,153));
    }//GEN-LAST:event_btnSubmitRoomIDMouseExited

    private void btnResetFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetFormMouseEntered
       btnResetForm.setBackground(Color.red);
    }//GEN-LAST:event_btnResetFormMouseEntered

    private void btnResetFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetFormMouseExited
        btnResetForm.setBackground(new java.awt.Color(255,102,102));
    }//GEN-LAST:event_btnResetFormMouseExited

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "From the room menu you can add new rooms or view\n"
        + "rooms that already exist!");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AppLib.roomList = new scrRoomList();
        AppLib.roomList.setVisible(true);
        AppLib.roomMenu.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(scrRoomMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scrRoomMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scrRoomMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrRoomMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scrRoomMenu().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnResetForm;
    private javax.swing.JButton btnSubmitNewRoom;
    private javax.swing.JButton btnSubmitRoomID;
    private javax.swing.JComboBox<String> ddlMicrophoneType;
    private javax.swing.JComboBox<String> ddlOperatingSystem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAddRoom;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelViewRoom;
    private javax.swing.JLabel lblAddRoom;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblFloor;
    private javax.swing.JLabel lblGetCapacity;
    private javax.swing.JLabel lblGetFloor;
    private javax.swing.JLabel lblGetMicrophoneType;
    private javax.swing.JLabel lblGetNumberOfPCs;
    private javax.swing.JLabel lblGetOperatingSystem;
    private javax.swing.JLabel lblGetRoomID;
    private javax.swing.JLabel lblGetRoomNumber;
    private javax.swing.JLabel lblGetRoomType;
    private javax.swing.JLabel lblGetTieredSeating;
    private javax.swing.JLabel lblMicrophoneType;
    private javax.swing.JLabel lblNumOfPCs;
    private javax.swing.JLabel lblOperatingSystem;
    private javax.swing.JLabel lblRoomID;
    private javax.swing.JLabel lblRoomMenu;
    private javax.swing.JLabel lblRoomNumber;
    private javax.swing.JLabel lblRoomType;
    private javax.swing.JLabel lblSubmissionMessage;
    private javax.swing.JLabel lblTieredSeating;
    private javax.swing.JLabel lblViewCapacity;
    private javax.swing.JLabel lblViewFloor;
    private javax.swing.JLabel lblViewRoomID;
    private javax.swing.JLabel lblViewRoomNumber;
    private javax.swing.JLabel lblViewRoomType;
    private javax.swing.JLabel lblViewroom;
    private javax.swing.JRadioButton rdoBtnLab;
    private javax.swing.JRadioButton rdoBtnLectureHall;
    private javax.swing.JRadioButton rdoBtnNo;
    private javax.swing.JRadioButton rdoBtnYes;
    private javax.swing.ButtonGroup roomTypeGroup;
    private javax.swing.JSpinner spinnerNumOfPCs;
    private javax.swing.ButtonGroup tieredSeatingGroup;
    private javax.swing.JTextField txtFieldCapacity;
    private javax.swing.JTextField txtFieldFloor;
    private javax.swing.JTextField txtFieldRequestRoomID;
    private javax.swing.JTextField txtFieldRoomID;
    private javax.swing.JTextField txtFieldRoomNumber;
    // End of variables declaration//GEN-END:variables
}
