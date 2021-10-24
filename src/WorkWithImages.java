
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicholas
 */
public class WorkWithImages extends javax.swing.JFrame {
    ImageIcon imageAustralia = new ImageIcon(new ImageIcon("australia.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageAfghanistan = new ImageIcon(new ImageIcon("afghanistan.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageChina = new ImageIcon(new ImageIcon("china.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageIndia = new ImageIcon(new ImageIcon("india.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageNewZealand = new ImageIcon(new ImageIcon("newZealand.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageKangaroo = new ImageIcon(new ImageIcon("kangaroo.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageLeopard = new ImageIcon(new ImageIcon("leopard.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imagePanda = new ImageIcon(new ImageIcon("panda.jpg").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageTiger = new ImageIcon(new ImageIcon("tiger.jpg").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
    ImageIcon imageKiwi = new ImageIcon(new ImageIcon("kiwibird.png").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));//Creates an image Icon with selected images within the javaGUI project
    //Also sets them to a specific format
    
    public WorkWithImages() {
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

        jButtonTest = new javax.swing.JButton();
        jLabelPic = new javax.swing.JLabel();
        jComboBoxCountries = new javax.swing.JComboBox<>();
        jLabelPic1 = new javax.swing.JLabel();
        jLabelPic2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Work With Images");

        jButtonTest.setText("Pictures");
        jButtonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestActionPerformed(evt);
            }
        });

        jComboBoxCountries.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Australia", "China", "India", "New Zealand" }));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Working With Images");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jComboBoxCountries, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelPic1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPic2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonTest, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPic)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPic1)
                        .addComponent(jLabelPic2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTest)
                    .addComponent(jComboBoxCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestActionPerformed
        String s = jComboBoxCountries.getSelectedItem().toString();
        if (s == "Australia")
        {
            jLabelPic1.setIcon(imageAustralia);
            jLabelPic2.setIcon(imageKangaroo);
        }
        else if (s == "Afghanistan")
        {
            jLabelPic1.setIcon(imageAfghanistan);
            jLabelPic2.setIcon(imageLeopard);
        }
         else if (s == "China")
        {
            jLabelPic1.setIcon(imageChina);
            jLabelPic2.setIcon(imagePanda);
        }
         else if (s == "India")
        {
            jLabelPic1.setIcon(imageIndia);
            jLabelPic2.setIcon(imageTiger);
        }
         else if (s == "New Zealand")
        {
            jLabelPic1.setIcon(imageNewZealand);
            jLabelPic2.setIcon(imageKiwi);
        }//If the country name is selected via the combobox and then the pictures button is pressed the countries flag/map and national animal will appear on the screen
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonTestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    MainMenu mm = new MainMenu();
    mm.setVisible(true);
    this.setVisible(false);// TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(WorkWithImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkWithImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkWithImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkWithImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkWithImages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JComboBox<String> jComboBoxCountries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPic;
    private javax.swing.JLabel jLabelPic1;
    private javax.swing.JLabel jLabelPic2;
    // End of variables declaration//GEN-END:variables
}
