/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import org.apache.commons.validator.routines.EmailValidator;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author saifb
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public LoginPage() {
        System.out.println();
        initComponents();
    }

    public boolean validateLogin() {
        String name = txt_username.getText();
        String pwd = String.valueOf(txt_password.getPassword());

        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter your username.");
            return false;
        }
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter your password");
            return false;
        }
        return true;
    }

    public void login() {
        String name = txt_username.getText();
        String pwd = String.valueOf(txt_password.getPassword());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from users where username = ? and password = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this,"Login Sucessfull");
                HomePage home = new HomePage(); 
                home.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel11 = new javax.swing.JLabel();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        txt_password = new rojerusan.RSPasswordTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SF UI Display", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Store");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        jLabel2.setFont(new java.awt.Font("SF UI Display", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Book Store");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 170, 50));

        jLabel3.setFont(new java.awt.Font("SF UI Display", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Book");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/20230823140432_[fpdl.in]_library-with-books-shelves-laptop-table_107791-1758_normal.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 590, 460));

        jLabel6.setFont(new java.awt.Font("SF UI Display", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 640));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Login into your account");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 230, 50));

        txt_username.setBackground(new java.awt.Color(102, 102, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_username.setPlaceholder("Enter your username...");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 260, 40));

        jLabel15.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-user-32(1).png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 40, 40));

        jLabel16.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Username");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 40));

        jLabel17.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-password-32.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 40, 40));

        jLabel18.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Password");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 100, 40));

        kButton2.setBorder(null);
        kButton2.setForeground(new java.awt.Color(0, 0, 0));
        kButton2.setText("LOGIN");
        kButton2.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        kButton2.setkAllowGradient(false);
        kButton2.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton2.setkBorderRadius(50);
        kButton2.setkEndColor(new java.awt.Color(153, 255, 255));
        kButton2.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton2.setkHoverColor(new java.awt.Color(0, 140, 186));
        kButton2.setkHoverEndColor(new java.awt.Color(0, 140, 186));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(0, 140, 186));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 230, -1));

        jLabel11.setFont(new java.awt.Font("SF UI Display", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Login Page");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 140, 50));

        kButton4.setBorder(null);
        kButton4.setForeground(new java.awt.Color(0, 0, 0));
        kButton4.setText("SIGNUP");
        kButton4.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        kButton4.setkAllowGradient(false);
        kButton4.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton4.setkBorderRadius(50);
        kButton4.setkEndColor(new java.awt.Color(153, 255, 255));
        kButton4.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverColor(new java.awt.Color(0, 140, 186));
        kButton4.setkHoverEndColor(new java.awt.Color(0, 140, 186));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(0, 140, 186));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kButton4KeyPressed(evt);
            }
        });
        jPanel2.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 230, -1));

        kButton6.setBorder(null);
        kButton6.setForeground(new java.awt.Color(0, 0, 0));
        kButton6.setText("×");
        kButton6.setFont(new java.awt.Font("SF UI  Text", 0, 36)); // NOI18N
        kButton6.setkAllowGradient(false);
        kButton6.setkBackGroundColor(new java.awt.Color(102, 102, 255));
        kButton6.setkBorderRadius(0);
        kButton6.setkEndColor(new java.awt.Color(153, 255, 255));
        kButton6.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton6.setkHoverColor(new java.awt.Color(153, 0, 0));
        kButton6.setkHoverEndColor(new java.awt.Color(0, 140, 186));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(0, 140, 186));
        kButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton6MouseClicked(evt);
            }
        });
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });
        kButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kButton6KeyPressed(evt);
            }
        });
        jPanel2.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 30));

        kButton8.setBorder(null);
        kButton8.setForeground(new java.awt.Color(0, 0, 0));
        kButton8.setText("-");
        kButton8.setFont(new java.awt.Font("SF UI  Text", 0, 36)); // NOI18N
        kButton8.setkAllowGradient(false);
        kButton8.setkBackGroundColor(new java.awt.Color(102, 102, 255));
        kButton8.setkBorderRadius(0);
        kButton8.setkEndColor(new java.awt.Color(153, 255, 255));
        kButton8.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton8.setkHoverColor(new java.awt.Color(102, 51, 255));
        kButton8.setkHoverEndColor(new java.awt.Color(0, 140, 186));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(0, 140, 186));
        kButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton8MouseClicked(evt);
            }
        });
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });
        kButton8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kButton8KeyPressed(evt);
            }
        });
        jPanel2.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 30));

        txt_password.setBackground(new java.awt.Color(102, 102, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        txt_password.setPhColor(new java.awt.Color(0, 0, 0));
        txt_password.setPlaceholder("Enter your password..");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 260, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 470, 640));

        setSize(new java.awt.Dimension(1100, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_usernameActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:

        if (validateLogin()) {
            login();
        };
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        SignupPage book = new SignupPage();
        book.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kButton4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton4KeyPressed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kButton6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton6KeyPressed

    private void kButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton6MouseClicked

    private void kButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton8MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_kButton8MouseClicked

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton8ActionPerformed

    private void kButton8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kButton8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton8KeyPressed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton8;
    private rojerusan.RSPasswordTextPlaceHolder txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}