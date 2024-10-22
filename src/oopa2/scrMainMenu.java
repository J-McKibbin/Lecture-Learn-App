/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oopa2;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author jonnymckibbin
 */
public class scrMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form mainMenu
     */
    public scrMainMenu() {
        initComponents();
    }

    
    public void exitProgram(){
        try{
            String message = "Are You sure you want to exit?\n\nSelect ok to confirm";
            int option = JOptionPane.showConfirmDialog(rootPane, message,
            "Confirm Room Details",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(option == JOptionPane.OK_OPTION){
                System.exit(0);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }//method
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMainMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBookings = new javax.swing.JButton();
        btnRooms = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 110, 40));

        jPanel3.setBackground(new java.awt.Color(29, 94, 115));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LectureLearn");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("™");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel4)))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 710, -1));

        lblMainMenu.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblMainMenu.setText("Main Menu");
        jPanel1.add(lblMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel2.setText("Select an option");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        btnBookings.setBackground(new java.awt.Color(229, 229, 229));
        btnBookings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopa2/icons8-book-50.png"))); // NOI18N
        btnBookings.setToolTipText("Bookings");
        btnBookings.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnBookings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookings.setOpaque(true);
        btnBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookingsMouseExited(evt);
            }
        });
        btnBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnBookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, 110));

        btnRooms.setBackground(new java.awt.Color(229, 229, 229));
        btnRooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopa2/icons8-classroom-50 (1).png"))); // NOI18N
        btnRooms.setToolTipText("Rooms");
        btnRooms.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnRooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRooms.setOpaque(true);
        btnRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRoomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRoomsMouseExited(evt);
            }
        });
        btnRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomsActionPerformed(evt);
            }
        });
        jPanel1.add(btnRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 150, 110));

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopa2/icons8-help-48.png"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setBorder(null);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jPanel1.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 50, 50));
        btnHelp.getAccessibleContext().setAccessibleName("Help");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel5.setText("Rooms");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel6.setText("Bookings");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 270, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setForeground(Color.black);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new java.awt.Color(201, 0, 0));
        btnExit.setForeground(Color.white);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       exitProgram();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "This is the main menu you can view rooms or manage bookings,"
        + "\nselect an option from the buttons below or exit the program!");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnBookingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingsMouseEntered
        btnBookings.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnBookingsMouseEntered

    private void btnBookingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingsMouseExited
        btnBookings.setBackground(new java.awt.Color(229,229,229));
    }//GEN-LAST:event_btnBookingsMouseExited

    private void btnRoomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomsMouseEntered
        btnRooms.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRoomsMouseEntered

    private void btnRoomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomsMouseExited
        btnRooms.setBackground(new java.awt.Color(229,229,229));
    }//GEN-LAST:event_btnRoomsMouseExited

    private void btnRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomsActionPerformed
        AppLib.mainMenu.setVisible(false);
        AppLib.roomMenu = new scrRoomMenu();
        AppLib.roomMenu.setVisible(true);
    }//GEN-LAST:event_btnRoomsActionPerformed

    private void btnBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingsActionPerformed
        AppLib.mainMenu.setVisible(false);
        AppLib.bookingMenu = new scrBookingMenu();
        AppLib.bookingMenu.setVisible(true);
    }//GEN-LAST:event_btnBookingsActionPerformed

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
            java.util.logging.Logger.getLogger(scrMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scrMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scrMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scrMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookings;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRooms;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblMainMenu;
    // End of variables declaration//GEN-END:variables
}
