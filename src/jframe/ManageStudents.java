/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author saifb
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String student_name, session, department, degree,phone_no;
    int student_id;
    DefaultTableModel model;

    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }

//    fetch data from database for book details
    public void setStudentDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("name");
                String session = rs.getString("session");
                String department = rs.getString("department");
                String degree = rs.getString("degree");
                String phoneNo = rs.getString("phone_no");
                Object[] obj = {studentId, studentName,phoneNo, session, department, degree};
                model = (DefaultTableModel) tbl_student_details.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    This method is used to add student to student_details
    public boolean addStudent() {
        student_id = Integer.parseInt(txt_studentId.getText());
        student_name = txt_StudentName.getText();
        phone_no = txt_phoneNo.getText();
        session = combo_session.getSelectedItem().toString();
        department = combo_department.getSelectedItem().toString();
        degree = combo_degree.getSelectedItem().toString();
        boolean isAdded = false;
        try {
            Connection con = DBConnection.getConnection();
            /*
            My snippet
            String sql = "select * from book_details where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                
            }
            
            
             */
            // modify
            String sql = "insert into student_details values(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            pst.setString(2, student_name);
            pst.setString(3, session);
            pst.setString(4, degree);
            pst.setString(5, department);
            pst.setString(6,phone_no);

            int row_count = pst.executeUpdate();
            if (row_count > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAdded;

    }

    // method to update student
    public boolean updateStudent() {
        student_id = Integer.parseInt(txt_studentId.getText());
        student_name = txt_StudentName.getText();
        session = combo_session.getSelectedItem().toString();
        department = combo_department.getSelectedItem().toString();
        degree = combo_degree.getSelectedItem().toString();
        phone_no = txt_phoneNo.getText();
        boolean isUpdated = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?,session = ?, department = ?, degree = ?, phone_no = ? where student_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, student_name);
            pst.setString(2, session);
            pst.setString(3, department);
            pst.setString(4, degree);
            pst.setString(5,phone_no);
            pst.setInt(6, student_id);
            int row_count = pst.executeUpdate();
            if (row_count > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    // method to delete students
    public boolean deleteStudent() {
        boolean isDeleted = false;
        student_id = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    // clear text field
    public void clearTextField(){
        txt_studentId.setText("");
        txt_StudentName.setText("");
        txt_phoneNo.setText("");
    }
    // clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_student_details.getModel();
        model.setRowCount(0);
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
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_StudentName = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        combo_department = new javax.swing.JComboBox<>();
        combo_degree = new javax.swing.JComboBox<>();
        combo_session = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txt_phoneNo = new app.bolivia.swing.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_student_details = new rojeru_san.complementos.RSTableMetro();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-rewind-16.png"))); // NOI18N
        kButton1.setText("Back Button");
        kButton1.setFont(new java.awt.Font("SF UI Display", 1, 12)); // NOI18N
        kButton1.setkAllowGradient(false);
        kButton1.setkBackGroundColor(new java.awt.Color(102, 102, 255));
        kButton1.setkHoverColor(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton1MouseClicked(evt);
            }
        });
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel16.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Student Id");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 40));

        jLabel15.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-id-32.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 40));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id..");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 40));

        txt_StudentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_StudentName.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_StudentName.setPlaceholder("Enter Student Name..");
        txt_StudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentNameFocusLost(evt);
            }
        });
        txt_StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 210, 40));

        jLabel17.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-book-32.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, 40));

        jLabel18.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Enter Student Name:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 190, 40));

        jLabel19.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-author-32.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 40, 40));

        jLabel20.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Session");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 130, 40));

        jLabel21.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-data-quantity-32.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 40, 40));

        jLabel22.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Degree");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 100, 40));

        rSButtonHover1.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover1.setText("Update");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover1.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 90, -1));

        rSButtonHover2.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover2.setText("ADD");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover2.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 70, -1));

        rSButtonHover3.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover3.setText("Delete");
        rSButtonHover3.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover3.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 80, -1));

        jLabel25.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-category-32(1).png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 40, 40));

        jLabel24.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Department");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 160, 40));

        combo_department.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        combo_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "EEE", "ME", "CIVIL", "URP", "IPE" }));
        jPanel1.add(combo_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 210, 30));

        combo_degree.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        combo_degree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC" }));
        jPanel1.add(combo_degree, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 210, 30));

        combo_session.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        combo_session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018-2019", "2019-2020", "2020-2021", "2021-2022", "2022-2023" }));
        jPanel1.add(combo_session, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 210, 30));

        jLabel27.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Contact No");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 100, 40));

        txt_phoneNo.setBackground(new java.awt.Color(102, 102, 255));
        txt_phoneNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_phoneNo.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_phoneNo.setPlaceholder("Enter your contact no...");
        txt_phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneNoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_phoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 210, 40));

        jLabel26.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-contact-32.png"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 30, 30));

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
        jPanel2.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 30));

        tbl_student_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Phone no", "Session", "Department", "Degree"
            }
        ));
        tbl_student_details.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_student_details.setFont(new java.awt.Font("SF UI  Text G", 0, 10)); // NOI18N
        tbl_student_details.setFuenteFilas(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_student_details.setFuenteFilasSelect(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_student_details.setFuenteHead(new java.awt.Font("SF UI  Text 2", 1, 14)); // NOI18N
        tbl_student_details.setRowHeight(30);
        tbl_student_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_student_detailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_student_details);
        if (tbl_student_details.getColumnModel().getColumnCount() > 0) {
            tbl_student_details.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 680, 200));

        jLabel23.setFont(new java.awt.Font("SF UI  Text G 3", 0, 24)); // NOI18N
        jLabel23.setText("Manage Students");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 255, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 225, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 700, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_StudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentNameFocusLost

    private void txt_StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentNameActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        if (updateStudent()) {
            JOptionPane.showMessageDialog(this, "Student information updated Sucessfully.");
            clearTable();
            setStudentDetailsToTable();
            clearTextField();
        } else {
            JOptionPane.showMessageDialog(this, "Student updation failed");
        }
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
        if (addStudent()) {
            JOptionPane.showMessageDialog(this, "Student Added Sucessfully.");
            clearTable();
            setStudentDetailsToTable();
            clearTextField();
        } else {
            JOptionPane.showMessageDialog(this, "Student addition Failed");
        }
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        // TODO add your handling code here:
        if (deleteStudent()) {
            JOptionPane.showMessageDialog(this, "Student Deletion Sucessfully.");
            clearTable();
            clearTextField();
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Student Deletion Failed");
        }
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void kButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_kButton6MouseClicked

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kButton6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton6KeyPressed

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

    private void tbl_student_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_student_detailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_student_details.getSelectedRow();
        TableModel model = tbl_student_details.getModel();
//        column will start usually 0
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_StudentName.setText(model.getValueAt(rowNo, 1).toString());
        txt_phoneNo.setText(model.getValueAt(rowNo, 2).toString());
        combo_session.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        combo_department.setSelectedItem(model.getValueAt(rowNo, 4).toString());
        combo_degree.setSelectedItem(model.getValueAt(rowNo, 5).toString());

    }//GEN-LAST:event_tbl_student_detailsMouseClicked

    private void txt_phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneNoActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_degree;
    private javax.swing.JComboBox<String> combo_department;
    private javax.swing.JComboBox<String> combo_session;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton8;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSTableMetro tbl_student_details;
    private app.bolivia.swing.JCTextField txt_StudentName;
    private app.bolivia.swing.JCTextField txt_phoneNo;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
