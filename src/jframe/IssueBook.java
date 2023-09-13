/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author saifb
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    // to fetch the book details from the database and display it to book details panel
    public void getBookDetails() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from book_details where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_category.setText(rs.getString("category"));
                lbl_quantity.setText(rs.getString("quantity"));
                lbl_bookError.setText("");
            } else {
                lbl_bookError.setText("Invalid book id");
            }
            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // to fetch the student details from the database and display it to student details panel
    public void getStudentDetails() {
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from student_details where student_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_department.setText(rs.getString("department"));
                lbl_session.setText(rs.getString("session"));
                lbl_degree.setText(rs.getString("degree"));
                lbl_phoneNo.setText(rs.getString("phone_no"));
                lbl_studentError.setText("");
            } else {
                lbl_studentError.setText("Invalid student id");
            }
            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // enter isssue book details into database
    public boolean issueBook() {
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        String phoneNo = lbl_phoneNo.getText();
//        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uIssueDate = mDate_issueDate.getDate();
//        Date uDueDate = date_DueDate.getDatoFecha();
        Date uDueDate = mDate_dueDate.getDate();
        
        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status,phone_no) values(?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "Pending");
            pst.setString(8, phoneNo);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }

            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;
    }

    // updating book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        int quantity = Integer.parseInt(lbl_quantity.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity-1 where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, bookId);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book Count Updated.");
                quantity = quantity - 1;
                lbl_quantity.setText(Integer.toString(quantity));
            } else {
                JOptionPane.showMessageDialog(this, "Can't update book count.");
            }

            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // checking wheather book is allocated or not
    public boolean isAlreadyIssued() {
        boolean isAlreadyIssue = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "Pending");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isAlreadyIssue = true;
            } else {
                isAlreadyIssue = false;
            }

            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssue;
    }
    
    
    public boolean isWithinMax() {
        boolean flag = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select count(*) as cnt from issue_book_details where student_id = ? and status = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

           
            pst.setInt(1, studentId);
            pst.setString(2, "Pending");

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String cnt = rs.getString("cnt");
                System.out.println(cnt);
                int cnt1 = Integer.parseInt(cnt);
                if(cnt1 >= 3){
                     flag = true;
                }
                else{
                    flag = false;
                }
               
            } else {
                flag = false;
            }

            /*
            if (rs.next()) {
               
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid book id");
                txt_bookId.setText("");
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_category = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_degree = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_session = new javax.swing.JLabel();
        lbl_department = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_phoneNo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        kButton8 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();
        mDate_issueDate = new com.toedter.calendar.JDateChooser();
        mDate_dueDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-rewind-16.png"))); // NOI18N
        kButton1.setText("Back Button");
        kButton1.setFont(new java.awt.Font("SF UI Display", 1, 12)); // NOI18N
        kButton1.setkAllowGradient(false);
        kButton1.setkBackGroundColor(new java.awt.Color(0, 204, 51));
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

        jLabel1.setFont(new java.awt.Font("SF UI  Text G 3", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-book-32.png"))); // NOI18N
        jLabel1.setText("Book Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 250, 2));

        lbl_bookError.setFont(new java.awt.Font("SF UI  Text 2", 0, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 51, 51));
        lbl_bookError.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                lbl_bookErrorAncestorResized(evt);
            }
        });
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 180, 30));

        lbl_quantity.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 240, 30));

        jLabel4.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel4.setText("Book Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel5.setText("Author:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel6.setText("Category:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel7.setText("Book Id:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 240, 30));

        lbl_bookName.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 220, 30));

        lbl_author.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 260, 30));

        lbl_category.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel1.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 240, 30));

        jLabel3.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel3.setText("Quantity:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 650));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 250, 2));

        jLabel13.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel13.setText("Degree:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        lbl_degree.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_degree, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 250, 30));

        jLabel15.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel15.setText("Phone no:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel16.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel16.setText("Session:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel17.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel17.setText("Department:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel18.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel18.setText("Student Id:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 220, 30));

        lbl_studentName.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 190, 30));

        lbl_session.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_session, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 250, 30));

        lbl_department.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 210, 30));

        jLabel14.setFont(new java.awt.Font("SF UI  Text G 3", 1, 24)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-students-32.png"))); // NOI18N
        jLabel14.setText("Student Details");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 30));

        lbl_studentError.setFont(new java.awt.Font("SF UI  Text 2", 1, 24)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 51, 51));
        jPanel5.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 210, 30));

        jLabel20.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel20.setText("Student Name:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lbl_phoneNo.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jPanel5.add(lbl_phoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 190, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 360, 650));

        jLabel12.setFont(new java.awt.Font("SF UI  Text G 3", 1, 24)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-give-32.png"))); // NOI18N
        jLabel12.setText("Issue Books");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, -1, 30));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 210, 3));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 204, 51));
        jLabel19.setText("Book Id:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 100, 40));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 51)));
        txt_bookId.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id....");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 220, 40));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 204, 51));
        jLabel21.setText("Issue Date:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 100, 40));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 51)));
        txt_studentId.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
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
        jPanel3.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 220, 40));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 204, 51));
        jLabel22.setText("Student Id:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 100, 40));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 204, 51));
        jLabel23.setText("Due Date:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 100, 40));

        rSButtonHover2.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover2.setText("ISSUE BOOK");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover2.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel3.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 240, -1));

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
        jPanel3.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 30, 30));

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
        jPanel3.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 30, 30));

        mDate_issueDate.setBackground(new java.awt.Color(255, 255, 255));
        mDate_issueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 2));
        mDate_issueDate.setFont(new java.awt.Font("SF UI  Text 2", 0, 14)); // NOI18N
        jPanel3.add(mDate_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 220, 30));

        mDate_dueDate.setBackground(new java.awt.Color(255, 255, 255));
        mDate_dueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 2));
        mDate_dueDate.setFont(new java.awt.Font("SF UI  Text 2", 0, 14)); // NOI18N
        jPanel3.add(mDate_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 220, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton1ActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
        if (!txt_bookId.getText().equals("")) {
            getBookDetails();
        }

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
        if (!txt_studentId.getText().equals("")) {
            getStudentDetails();
        }

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
        String bookId = txt_bookId.getText();
        String studentId = txt_studentId.getText();
//        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uIssueDate = mDate_issueDate.getDate();
//        Date uDueDate = date_DueDate.getDatoFecha();
        Date uDueDate = mDate_dueDate.getDate();
        if (bookId.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book id.");
        } else if (studentId.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter student id.");
        } else if (uIssueDate == null) {
            JOptionPane.showMessageDialog(this, "Please enter a issue date.");
        } else if (uDueDate == null) {
            JOptionPane.showMessageDialog(this, "Please enter a due date.");
        } else {
            Long l1 = uIssueDate.getTime();
            Long l2 = uDueDate.getTime();
            if (l1 < l2) {
                if (isAlreadyIssued()) {
                    JOptionPane.showMessageDialog(this, "This student already has this books.");
                }
                else if(isWithinMax()){
                    JOptionPane.showMessageDialog(this, "This student exceeds it's books limit.");
                }
                else {
                    int quantity = Integer.parseInt(lbl_quantity.getText());
                    if (issueBook() && quantity > 0) {
                        JOptionPane.showMessageDialog(this, "Book Issued Sucessfully.");
                        updateBookCount();
                    } else if (quantity == 0) {
                        JOptionPane.showMessageDialog(this, "Book is not available.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Can't Issue book.");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Due date.");
            }
        }


    }//GEN-LAST:event_rSButtonHover2ActionPerformed

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

    private void lbl_bookErrorAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lbl_bookErrorAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookErrorAncestorResized

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_degree;
    private javax.swing.JLabel lbl_department;
    private javax.swing.JLabel lbl_phoneNo;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_session;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private com.toedter.calendar.JDateChooser mDate_dueDate;
    private com.toedter.calendar.JDateChooser mDate_issueDate;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
