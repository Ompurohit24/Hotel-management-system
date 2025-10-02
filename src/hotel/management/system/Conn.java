/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;
import java.sql.Connection;
public class Conn {
    Connection c;
    Statement s;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/hotelmanagementsystem","root","om5123");
            s =  c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
