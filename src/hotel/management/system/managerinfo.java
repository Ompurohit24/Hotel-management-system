
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class managerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    managerinfo(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        
  
        JLabel j1 = new JLabel("Name");
        j1.setBounds(40,10,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Age");
        j2.setBounds(170,10,100,20);
        add(j2);
        
          JLabel j3 = new JLabel("Gender");
        j3.setBounds(290,10,100,20);
        add(j3);
        
         JLabel j4 = new JLabel("Job");
        j4.setBounds(400,10,100,20);
        add(j4);
        
         JLabel j5 = new JLabel("Salary");
        j5.setBounds(540,10,100,20);
        add(j5);
        
         JLabel j6 = new JLabel("Number");
        j6.setBounds(670,10,100,20);
        add(j6);
        
         JLabel j7 = new JLabel("Email");
        j7.setBounds(790,10,100,20);
        add(j7);
        
         JLabel j8 = new JLabel("Aadhar");
        j8.setBounds(910,10,100,20);
        add(j8);
        
        
        
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
         try {
            
            Conn c = new Conn();
            String query = " select * from employee where job = 'Manager' ";
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
        new managerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
       
    }
}
