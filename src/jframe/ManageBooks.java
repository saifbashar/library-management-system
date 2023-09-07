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
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String book_name, author, category;
    int quantity, book_id;
    DefaultTableModel model;

    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }

//    fetch data from database for book details
    public void setBookDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String bookName = rs.getString("book_name");
                String authorName = rs.getString("author");
                String categoryName = rs.getString("category");
                int quantityTotal = rs.getInt("quantity");
                Object[] obj = {bookId, bookName, authorName, categoryName, quantityTotal};
                model = (DefaultTableModel) tbl_book_details.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearText() {
        txt_bookId.setText("");
        txt_quantity.setText("");
        txt_bookName.setText("");
        txt_authorName.setText("");
        txt_category.setText("");
    }
//    This method is used to add Book

    public boolean addBook() {
        book_id = Integer.parseInt(txt_bookId.getText());
        quantity = Integer.parseInt(txt_quantity.getText());
        book_name = txt_bookName.getText();
        author = txt_authorName.getText();
        category = txt_category.getText();
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
            String sql = "insert into book_details values(?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setString(2, book_name);
            pst.setString(3, author);
            pst.setString(4, category);
            pst.setInt(5, quantity);
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

    // method to update books
    public boolean updateBook() {
        book_id = Integer.parseInt(txt_bookId.getText());
        quantity = Integer.parseInt(txt_quantity.getText());
        book_name = txt_bookName.getText();
        author = txt_authorName.getText();
        category = txt_category.getText();
        boolean isUpdated = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set book_name = ?,author = ?, category = ?, quantity = ? where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, book_name);
            pst.setString(2, author);
            pst.setString(3, category);
            pst.setInt(4, quantity);
            pst.setInt(5, book_id);
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

    // method to delete books
    public boolean deleteBook() {
        boolean isDeleted = false;
        book_id = Integer.parseInt(txt_bookId.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from book_details where book_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);

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

    // clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_book_details.getModel();
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
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_authorName = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_category = new app.bolivia.swing.JCTextField();
        jPanel2 = new javax.swing.JPanel();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_book_details = new rojeru_san.complementos.RSTableMetro();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 0, new java.awt.Color(0, 0, 0)));
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
        jLabel16.setText("Enter Book Id");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 40));

        jLabel15.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-id-32.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 40));

        txt_bookId.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id..");
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
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 40));

        txt_bookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_bookName.setPlaceholder("Enter Book Name..");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 210, 40));

        jLabel17.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-book-32.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 40, 40));

        jLabel18.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Enter Book Name:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, 40));

        txt_authorName.setBackground(new java.awt.Color(102, 102, 255));
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authorName.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_authorName.setPlaceholder("Enter author name...");
        txt_authorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authorNameFocusLost(evt);
            }
        });
        txt_authorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, 40));

        jLabel19.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-author-32.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 40, 40));

        jLabel20.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Author Name");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 130, 40));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_quantity.setPlaceholder("Quantity");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 210, 40));

        jLabel21.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-data-quantity-32.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 40, 40));

        jLabel22.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Quantity");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 100, 40));

        rSButtonHover1.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover1.setText("Update");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover1.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 90, -1));

        rSButtonHover2.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover2.setText("ADD");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover2.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 70, -1));

        rSButtonHover3.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover3.setText("Delete");
        rSButtonHover3.setColorHover(new java.awt.Color(255, 51, 51));
        rSButtonHover3.setFont(new java.awt.Font("SF UI  Text Med", 1, 14)); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 80, -1));

        jLabel25.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/my/icons8-category-32(1).png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 40, 40));

        jLabel24.setFont(new java.awt.Font("SF UI  Text", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Category");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 100, 40));

        txt_category.setBackground(new java.awt.Color(102, 102, 255));
        txt_category.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_category.setFont(new java.awt.Font("SF UI  Text G", 0, 18)); // NOI18N
        txt_category.setPlaceholder("Category..");
        txt_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_categoryFocusLost(evt);
            }
        });
        txt_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryActionPerformed(evt);
            }
        });
        jPanel1.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 2, new java.awt.Color(0, 0, 0)));
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

        tbl_book_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Category", "Quantity"
            }
        ));
        tbl_book_details.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_book_details.setFont(new java.awt.Font("SF UI  Text G", 0, 10)); // NOI18N
        tbl_book_details.setFuenteFilas(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_book_details.setFuenteFilasSelect(new java.awt.Font("SF UI  Text 2", 1, 12)); // NOI18N
        tbl_book_details.setFuenteHead(new java.awt.Font("SF UI  Text 2", 1, 14)); // NOI18N
        tbl_book_details.setRowHeight(30);
        tbl_book_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_book_detailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_book_details);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 650, 460));

        jLabel23.setFont(new java.awt.Font("SF UI  Text G 3", 0, 24)); // NOI18N
        jLabel23.setText("Manage Books");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 255, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 210, 5));

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

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void txt_authorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameFocusLost

    private void txt_authorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameActionPerformed

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        String book_id1 = txt_bookId.getText();
        String quantity1 = txt_quantity.getText();
        String book_name1 = txt_bookName.getText();
        String author1 = txt_authorName.getText();
        String category1 = txt_category.getText();

        if (book_id1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book id.");
        } else if (book_name1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book name.");
        } else if (author1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book author name.");
        } else if (category1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book category.");
        } else if (quantity1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book quantity.");
        } else {
            if (updateBook()) {
                JOptionPane.showMessageDialog(this, "Book information updated Sucessfully.");
                clearTable();
                setBookDetailsToTable();
                clearText();

            } else {
                JOptionPane.showMessageDialog(this, "Book updation failed");
                clearText();
                
            }
        }
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
        String book_id1 = txt_bookId.getText();
        String quantity1 = txt_quantity.getText();
        String book_name1 = txt_bookName.getText();
        String author1 = txt_authorName.getText();
        String category1 = txt_category.getText();

        if (book_id1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book id.");
        } else if (book_name1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book name.");
        } else if (author1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book author name.");
        } else if (category1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book category.");
        } else if (quantity1.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book quantity.");
        } else {
            if (addBook()) {
                JOptionPane.showMessageDialog(this, "Book Added Sucessfully.");
                clearTable();
                setBookDetailsToTable();
                clearText();
            } else {
                JOptionPane.showMessageDialog(this, "Addition Failed");
                clearText();
            }
        }


    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        // TODO add your handling code here:
        if (txt_bookId.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter book id.");
        } else {
            if (deleteBook()) {
                JOptionPane.showMessageDialog(this, "Book Deletion Sucessfully.");
                clearTable();
                setBookDetailsToTable();
                clearText();
            } else {
                JOptionPane.showMessageDialog(this, "Book Deletion Failed");
                clearText();
                
            }
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

    private void tbl_book_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_book_detailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_book_details.getSelectedRow();
        TableModel model = tbl_book_details.getModel();
//        column will start usually 0
        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_category.setText(model.getValueAt(rowNo, 3).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 4).toString());

    }//GEN-LAST:event_tbl_book_detailsMouseClicked

    private void txt_categoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_categoryFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryFocusLost

    private void txt_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private rojeru_san.complementos.RSTableMetro tbl_book_details;
    private app.bolivia.swing.JCTextField txt_authorName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_category;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
