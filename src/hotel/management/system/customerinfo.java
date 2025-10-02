
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    customerinfo(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        
  
        JLabel j1 = new JLabel("Document Type");
        j1.setBounds(10,10,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Number");
        j2.setBounds(160,10,100,20);
        add(j2);
        
          JLabel j3 = new JLabel("Name");
        j3.setBounds(290,10,100,20);
        add(j3);
        
         JLabel j4 = new JLabel("Gender");
        j4.setBounds(410,10,100,20);
        add(j4);
        
         JLabel j5 = new JLabel("Country");
        j5.setBounds(540,10,100,20);
        add(j5);
        
         JLabel j6 = new JLabel("Room Number");
        j6.setBounds(640,10,100,20);
        add(j6);
        
         JLabel j7 = new JLabel("CheckIn Time");
        j7.setBounds(760,10,100,20);
        add(j7);
        
         JLabel j8 = new JLabel("Deposit");
        j8.setBounds(900,10,100,20);
        add(j8);
        
        
        
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
         try {
            
            Conn c = new Conn();
            String query = " select * from customer ";
            ResultSet rs = c.s.executeQuery(query) ;
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
        
        
        back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
    }
     public static void main(String[]args){
        new customerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
       
    }
}
