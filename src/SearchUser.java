

import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.math.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import javax.swing.table.*;
/**

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicholas
 */
public class SearchUser extends javax.swing.JFrame {

    /**
     * Creates new form SearchUser
     */
    public SearchUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldUsernameSearch = new javax.swing.JTextField();
        jTextFieldEmailSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSearch = new javax.swing.JTable();
        jButtonSearch1 = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Email");

        jButtonSearch.setText("Show All");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "UserPassword", "FirstName", "LastName", "DOB", "UserType", "EmailAddress", "CreateDate"
            }
        ));
        jScrollPane1.setViewportView(jTableSearch);

        jButtonSearch1.setText("Search");
        jButtonSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearch1ActionPerformed(evt);
            }
        });

        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setText("Search Users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsernameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmailSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch1)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReturn)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsernameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmailSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonSearch1)
                    .addComponent(jButtonReturn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javauser", "root", "B!gB1ueBear");
            ResultSet rs;
            DefaultTableModel dtModel = (DefaultTableModel)jTableSearch.getModel();
            String username = jTextFieldUsernameSearch.toString();
            String emailAddress = jTextFieldEmailSearch.toString();
            String search = "SELECT * FROM javauserdetails"; //WHERE Username='" + username + "' and " + "EmailAddress='" + emailAddress + "';";
            Statement myStmt = conn.createStatement();
            rs = myStmt.executeQuery(search);
            dtModel.setRowCount(0);
            while (rs.next()){
                String uid = String.valueOf(rs.getInt("UserID"));
                String un = rs.getString("Username");
                String pw = rs.getString("UserPassword");
                String fn = rs.getString("FirstName");
                String ln = rs.getString("LastName");
                String dob = String.valueOf(rs.getDate("DOB"));
                String ut = rs.getString("UserType");
                String ea = rs.getString("EmailAddress");
                String cd = String.valueOf(rs.getDate("CreateDate"));
                String tabledata[] = {uid, un, pw, fn, ln, dob, ut, ea, cd};           
                dtModel.addRow(tabledata);
            }
            
            
            
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearch1ActionPerformed
        if ((jTextFieldUsernameSearch.getText() == null)  && (jTextFieldEmailSearch.getText()) == null)
        {
            JOptionPane.showMessageDialog(null, "Both Username and EmailAddress must be filled");
            return;
        }
        else{
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javauser", "root", "B!gB1ueBear");
            ResultSet rs;
            String username = jTextFieldUsernameSearch.getText();
            String emailAddress = jTextFieldEmailSearch.getText();
            String search = "SELECT * FROM javauserdetails WHERE Username='" + username + "' OR EmailAddress='" + emailAddress + "';";
            Statement myStmt = conn.createStatement();
            rs = myStmt.executeQuery(search);
            while (rs.next()){
                String uid = String.valueOf(rs.getInt("UserID"));
                String un = rs.getString("Username");
                String pw = rs.getString("UserPassword");
                String fn = rs.getString("FirstName");
                String ln = rs.getString("LastName");
                String dob = String.valueOf(rs.getDate("DOB"));
                String ut = rs.getString("UserType");
                String ea = rs.getString("EmailAddress");
                String cd = String.valueOf(rs.getDate("CreateDate"));
                String tabledata[] = {uid, un, pw, fn, ln, dob, ut, ea, cd};
                
                DefaultTableModel dtModel = (DefaultTableModel)jTableSearch.getModel();
                dtModel.setRowCount(0);
                dtModel.addRow(tabledata);
            }
            
           
            
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}   
        }// TODO add your handling code here:
                                                   // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSearch1ActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
    MainMenu mm = new MainMenu();
    mm.setVisible(true);
    this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturnActionPerformed

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
            java.util.logging.Logger.getLogger(SearchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearch1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSearch;
    private javax.swing.JTextField jTextFieldEmailSearch;
    private javax.swing.JTextField jTextFieldUsernameSearch;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
