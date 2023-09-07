/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;
import java.sql.*;
/**
 *
 * @author saifb
 */
public class DBConnection {
    static Connection con = null;
    
    public static Connection getConnection(){
         String db_url="jdbc:mysql://localhost:3306/library_ms";  
        String db_user = "root";
        String db_pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(db_url,db_user,db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
