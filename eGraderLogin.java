/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import smartGrader.Database.DatabaseConnection;

/**
 *
 * @author LabaPc
 */
public class eGraderLogin extends javax.swing.JFrame {

    PreparedStatement myStmt = null;
    ResultSet myRs = null;
    Connection myConn = null;
    String currentAdmin = null;

    /**
     * Creates new form eGraderLogin
     */
    public eGraderLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelPass = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonCreateAcc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(725, 474));

        jPanel1.setBackground(new java.awt.Color(56, 9, 134));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartGrader/images/itzGood.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 9, 134)));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 9, 134));
        jLabel2.setText(" LOGIN");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel3.setText("UserName");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jTextFieldUserName.setText("laba");
        jTextFieldUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserNameActionPerformed(evt);
            }
        });

        jPasswordFieldPass.setText("laba");

        jButtonLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(56, 9, 134));
        jButtonLogin.setText("LOGIN  >>");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonCreateAcc.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButtonCreateAcc.setForeground(new java.awt.Color(56, 9, 134));
        jButtonCreateAcc.setText("Don't  have an  account?");
        jButtonCreateAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPassLayout = new javax.swing.GroupLayout(jPanelPass);
        jPanelPass.setLayout(jPanelPassLayout);
        jPanelPassLayout.setHorizontalGroup(
            jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonLogin)
                        .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(jTextFieldUserName))
                    .addComponent(jButtonCreateAcc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPassLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanelPassLayout.setVerticalGroup(
            jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonLogin)
                .addGap(18, 18, 18)
                .addComponent(jButtonCreateAcc)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanelPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanelPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserNameActionPerformed
    private String getUserName() {
        String UserName = jTextFieldUserName.getText().toLowerCase();
        String user = null;
        String Sqlstmt = "SELECT * FROM logininfo WHERE UserName= " + UserName;
        try {
            DatabaseConnection cnn = new DatabaseConnection();
            myConn = cnn.myconnection();
            myStmt = myConn.prepareStatement(Sqlstmt);
            myRs = myStmt.executeQuery();
            if (myRs.next()) {
                user = myRs.getString("UserName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(eGrader_Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    private String getPassword() {
        String Password = String.valueOf(jPasswordFieldPass.getPassword()).toLowerCase();
        String pass = null;
        String Sqlstmt = "Select Password from logininfo Where Password= " + Password;
        try {
            DatabaseConnection cnn = new DatabaseConnection();
            myConn = cnn.myconnection();
            myStmt = myConn.prepareStatement(Sqlstmt);
            myRs = myStmt.executeQuery();
            if (myRs.next()) {
                pass = myRs.getString("UserName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(eGrader_Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pass;
    }
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        String UserName = jTextFieldUserName.getText().toLowerCase();
        String Password = String.valueOf(jPasswordFieldPass.getPassword()).toLowerCase();
        if (UserName.isEmpty() || Password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Make Sure all fields are filled", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String user = null;
        String pass = null;
        DatabaseConnection myconnect = new DatabaseConnection();
        myConn = myconnect.myconnection();
        String Sqlstmt = "Select * from logininfo Where UserName='" + UserName + "' and Password='" + Password + "'";
        // String Sqlstmt = "SELECT UserName,Password FROM adminlogin WHERE UserName=UserName AND Password=Password";
        try {
            DatabaseConnection cnn = new DatabaseConnection();
            myConn = cnn.myconnection();
            myStmt = myConn.prepareStatement(Sqlstmt);
            myRs = myStmt.executeQuery();
//            user = getUserName();
//            pass = getPassword();
            if (myRs.next()) {
                user = myRs.getString("UserName");
                pass = myRs.getString("Password");

                currentAdmin = UserName;
                if ((UserName.equalsIgnoreCase(user) & (Password.equalsIgnoreCase(pass)))) {
                    eGrader_Worker eWorker = new eGrader_Worker(currentAdmin);
                    eWorker.setVisible(true);
                    this.dispose();
                }
            } else if (UserName.equalsIgnoreCase(user) & !(Password.equalsIgnoreCase(pass))) {
                // {
                JOptionPane.showMessageDialog(this, "Password Is Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "UserName or Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(eGrader_Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCreateAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAccActionPerformed
        // TODO add your handling code here:
        createAccount cA = new createAccount();
        cA.setLocationRelativeTo(null);
        cA.setVisible(true);
    }//GEN-LAST:event_jButtonCreateAccActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eGraderLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eGraderLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateAcc;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelPass;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
