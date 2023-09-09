/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saifb
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    public ViewAllRecord() {
        initComponents();
        setStudentDetailsToTable();
    }
    DefaultTableModel model;

    public void setStudentDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");
            while (rs.next()) {
                String issueId = rs.getString("id");
                String bookName = rs.getString("book_name");
                String bookId = rs.getString(("book_id"));
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                String phoneNo = rs.getString("phone_no");
                Object[] obj = {issueId, bookId, bookName, studentId, studentName, phoneNo, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//   To clear table

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }

// To fetch data using data field
    public void search() {
        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date between ? and ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            ResultSet rs = pst.executeQuery();
            boolean flag = true;
            while (rs.next()) {
                flag = false;
                String issueId = rs.getString("id");
                String bookName = rs.getString("book_name");
                String bookId = rs.getString("book_id");
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                String phoneNo = rs.getString("phone_no");
                Object[] obj = {issueId, bookId, bookName, studentId, studentName, phoneNo, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this, "No record found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByStudentId() {
        int studentId1 = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where student_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId1);

            ResultSet rs = pst.executeQuery();
            boolean flag = true;
            while (rs.next()) {
                flag = false;
                String issueId = rs.getString("id");
                String bookName = rs.getString("book_name");
                String bookId = rs.getString("book_id");
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                String phoneNo = rs.getString("phone_no");
                Object[] obj = {issueId, bookId, bookName, studentId, studentName, phoneNo, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this, "No record found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByBookId() {
        int bookId1 = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId1);

            ResultSet rs = pst.executeQuery();
            boolean flag = true;
            while (rs.next()) {
                flag = false;
                String issueId = rs.getString("id");
                String bookName = rs.getString("book_name");
                String bookId = rs.getString("book_id");
                String studentName = rs.getString("student_name");
                String studentId = rs.getString("student_id");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                String phoneNo = rs.getString("phone_no");

                Object[] obj = {issueId, bookId, bookName, studentId, studentName, phoneNo, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
            if (flag) {
                JOptionPane.showMessageDialog(this, "No record found.");
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
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        rSButtonHover4 = new rojeru_san.complementos.RSButtonHover();
        jLabel22 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        rSButtonHover5 = new rojeru_san.complementos.RSButtonHover();
        jLabel24 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        rSButtonHover6 = new rojeru_san.complementos.RSButtonHover();
        panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();
        rSButtonHover7 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("SF UI  Text G 3", 1, 24)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-give-32.png"))); // NOI18N
        jLabel12.setText("Issue Book Details");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 270, 4));

        date_fromDate.setColorBackground(new java.awt.Color(51, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(51, 51, 51));
        date_fromDate.setFuente(new java.awt.Font("SF UI  Text 2", 0, 14)); // NOI18N
        date_fromDate.setPlaceholder("Select Date..");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 220, -1));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel21.setText("From Date:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 40));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel23.setText("To Date:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 80, 40));

        date_toDate.setColorBackground(new java.awt.Color(51, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(51, 51, 51));
        date_toDate.setFuente(new java.awt.Font("SF UI  Text 2", 0, 14)); // NOI18N
        date_toDate.setPlaceholder("Select Date..");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 220, -1));

        rSButtonHover3.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonHover3.setText("SEARCH");
        rSButtonHover3.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover3.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 100, -1));

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
        jPanel1.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 30, 30));

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
        jPanel1.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 30, 30));

        rSButtonHover4.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonHover4.setText("All");
        rSButtonHover4.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover4.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 140, 110, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel22.setText("Student Id:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, 40));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 204, 51)));
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
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 220, 40));

        rSButtonHover5.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonHover5.setText("SEARCH");
        rSButtonHover5.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover5.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 100, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel24.setText("Book Id:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 80, 40));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 204, 51)));
        txt_bookId.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter book Id...");
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
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 220, 40));

        rSButtonHover6.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonHover6.setText("SEARCH");
        rSButtonHover6.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover6.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover6ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 250));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Book id", "Book Name", "Student Id", "Student Name", "Phone", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_issueBookDetails.setFont(new java.awt.Font("SF UI  Text G", 0, 10)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_issueBookDetails.setFuenteHead(new java.awt.Font("SF UI  Text 2", 1, 14)); // NOI18N
        tbl_issueBookDetails.setRowHeight(30);
        tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1160, 290));

        rSButtonHover7.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonHover7.setText("Print");
        rSButtonHover7.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover7.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover7ActionPerformed(evt);
            }
        });
        panel_table.add(rSButtonHover7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 110, -1));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1200, 400));

        setSize(new java.awt.Dimension(1200, 654));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        // TODO add your handling code here:
        if (date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
            clearTable();
            search();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a date");
        }
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

    private void kButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton1ActionPerformed

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

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
        // TODO add your handling code here:
        date_fromDate.setDatoFecha(null);
        date_toDate.setDatoFecha(null);
        txt_studentId.setText("");
        txt_bookId.setText("");
        clearTable();
        setStudentDetailsToTable();

    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSButtonHover5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover5ActionPerformed
        // TODO add your handling code here:

        if (txt_studentId.getText().length() != 0) {
            date_fromDate.setDatoFecha(null);
            date_toDate.setDatoFecha(null);
            txt_bookId.setText("");
            clearTable();
            searchByStudentId();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter valid student id.");
        }
    }//GEN-LAST:event_rSButtonHover5ActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSButtonHover6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover6ActionPerformed
        // TODO add your handling code here:
        if (txt_bookId.getText().length() != 0) {
            date_fromDate.setDatoFecha(null);
            date_toDate.setDatoFecha(null);
            txt_studentId.setText("");
            clearTable();
            searchByBookId();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter valid book id.");
        }
    }//GEN-LAST:event_rSButtonHover6ActionPerformed

    private void rSButtonHover7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover7ActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        if (path != "") {
            Document doc = new Document();
            doc.setMargins(0, 0, 20, 0);

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path + "all records.pdf"));
                doc.open();
                Font f = new Font(FontFamily.TIMES_ROMAN, 50.0f, Font.UNDERLINE, BaseColor.GREEN);
                Font f1 = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD, BaseColor.BLACK);
                Font f2 = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.NORMAL, BaseColor.RED);
                Font f3 = new Font(FontFamily.COURIER, 12.0f, Font.NORMAL, BaseColor.BLACK);
                Paragraph docTitle = new Paragraph("All Records", f);
                docTitle.setSpacingAfter(15);
                docTitle.setAlignment(Element.ALIGN_CENTER);

                doc.add(docTitle);
                Paragraph docTitle1 = new Paragraph("This pdf is generated by library management system", f3);
                docTitle1.setSpacingAfter(5);
                docTitle1.setAlignment(Element.ALIGN_CENTER);
                doc.add(docTitle1);
                java.util.Date date = new java.util.Date();
                Paragraph docTitle2 = new Paragraph("Date: " + date.toString(), f3);
                docTitle2.setSpacingAfter(20);
                docTitle2.setAlignment(Element.ALIGN_CENTER);
                doc.add(docTitle2);

//            Font f=new Font(FontFamily.TIMES_ROMAN,50.0f,Font.UNDERLINE,BaseColor.GREEN);
//            Font f1=new Font(FontFamily.TIMES_ROMAN,12.0f,Font.BOLD,BaseColor.BLACK);
//              Font f2=new Font(FontFamily.TIMES_ROMAN,12.0f,Font.NORMAL,BaseColor.RED);
//            Paragraph docTitle = new Paragraph("All Records",f);
//            docTitle.setSpacingAfter(50);
//            docTitle.setAlignment(Element.ALIGN_CENTER);
//            doc.add(docTitle);
                PdfPTable tbl = new PdfPTable(9);

                tbl.addCell(new Paragraph("Issue Id", f1));
                tbl.addCell(new Paragraph("Book Id", f1));
                tbl.addCell(new Paragraph("Book Name", f1));
                tbl.addCell(new Paragraph("Student Id", f1));
                tbl.addCell(new Paragraph("Student Name", f1));
                tbl.addCell(new Paragraph("Phone", f1));
                tbl.addCell(new Paragraph("Issue Date", f1));
                tbl.addCell(new Paragraph("Due Date", f1));
                tbl.addCell(new Paragraph("Status", f1));

                for (int i = 0; i < tbl_issueBookDetails.getRowCount(); i++) {
                    String issueId = tbl_issueBookDetails.getValueAt(i, 0).toString();
                    String bookId = tbl_issueBookDetails.getValueAt(i, 1).toString();
                    String bookName = tbl_issueBookDetails.getValueAt(i, 2).toString();
                    String studentId = tbl_issueBookDetails.getValueAt(i, 3).toString();
                    String studentName = tbl_issueBookDetails.getValueAt(i, 4).toString();
                    String phone = tbl_issueBookDetails.getValueAt(i, 5).toString();
                    String issueDate = tbl_issueBookDetails.getValueAt(i, 6).toString();
                    String dueDate = tbl_issueBookDetails.getValueAt(i, 7).toString();
                    String status = tbl_issueBookDetails.getValueAt(i, 8).toString();
                    tbl.addCell(issueId);
                    tbl.addCell(bookId);
                    tbl.addCell(bookName);
                    tbl.addCell(studentId);
                    tbl.addCell(studentName);
                    tbl.addCell(phone);
                    tbl.addCell(issueDate);
                    tbl.addCell(dueDate);
                    if ("Pending".equals(status) == false) {
                        tbl.addCell(status);
                    } else {
                        tbl.addCell(new Paragraph(status, f2));
                    }
                }
                doc.add(tbl);
                JOptionPane.showMessageDialog(null, "PDF generated.");

            } catch (Exception e) {
//            e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }
            doc.close();
        }
        
    }//GEN-LAST:event_rSButtonHover7ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton8;
    private javax.swing.JPanel panel_table;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover5;
    private rojeru_san.complementos.RSButtonHover rSButtonHover6;
    private rojeru_san.complementos.RSButtonHover rSButtonHover7;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
