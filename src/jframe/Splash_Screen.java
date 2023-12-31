/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author saifb
 */
public class Splash_Screen extends javax.swing.JFrame  implements Runnable{

    /**
     * Creates new form Splash_Screen
     */
    public Splash_Screen() {
        initComponents();
        Thread t = new Thread(this);
        t.start();
       
    }
    
     @Override
    public void run() {
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         for(int i=0;i<=100;i++){
             try {
                 Thread.sleep(100);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             loadingValue.setText(i+"%");
                if(i==10){
                    loadingLabel.setText("Turning on modules...");
                }
                else if(i==30){
                    loadingLabel.setText("Starting modules...");
                }
                else if(i==50){
                    loadingLabel.setText("Done loading modules...");
                }
                if(i==80){
                     loadingLabel.setText("Launching Application...");
                }
             loadingBar.setValue(i);
         }
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        loadingBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loadingLabel = new javax.swing.JLabel();
        loadingValue = new javax.swing.JLabel();
        BackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BackgroundPanel.setBackground(new java.awt.Color(51, 255, 51));
        BackgroundPanel.setPreferredSize(new java.awt.Dimension(650, 500));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BackgroundPanel.add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 650, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/Untitled design(2).png"))); // NOI18N
        BackgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 310, 230));

        jLabel2.setFont(new java.awt.Font("SF UI  Text 2", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Library Management System");
        BackgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        loadingLabel.setFont(new java.awt.Font("SF UI  Text", 0, 12)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadingLabel.setText("Loading...");
        BackgroundPanel.add(loadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        loadingValue.setFont(new java.awt.Font("SF UI  Text", 0, 12)); // NOI18N
        loadingValue.setForeground(new java.awt.Color(255, 255, 255));
        loadingValue.setText("0%");
        BackgroundPanel.add(loadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 460, 40, -1));

        BackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/splash_screen2.png"))); // NOI18N
        BackgroundPanel.add(BackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Splash_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash_Screen().setVisible(true);
            }
        });
//        try {
//            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//        }
       
//        try {
//            for(int i=0;i<=100;i++){
//                Thread.sleep(100);
//                loadingValue.setText(i+"%");
//                if(i==10){
//                    loadingLabel.setText("Turning on modules...");
//                }
//                if(i==80){
//                     loadingLabel.setText("Launching Application...");
//                }
//                 loadingBar.setValue(i);
//            }
//           
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JLabel loadingValue;
    // End of variables declaration//GEN-END:variables

   
}
