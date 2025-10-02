
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    JButton nback;
    department(){
        setLayout(null);
        setVisible(true);
        setBounds(400,200,700,480);
        getContentPane().setBackground(Color.WHITE);
        
        
         back = new JButton("Back");
        back.setBounds(270,400,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        JLabel j1 = new JLabel("Department");
        j1.setBounds(70,10,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Budget");
        j2.setBounds(450,10,100,20);
        add(j2);
       
        
        table = new JTable();
        table.setBounds(0,40,700,400);
        add(table);
        
        try {
            
            Conn c = new Conn();
            String query = " select * from department";
            ResultSet rs = c.s.executeQuery(query) ;
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
         nback = new JButton("Back");
         nback.setBounds(10,100,120,30);
        nback.setBackground(Color.black);
        nback.setForeground(Color.WHITE);
        add(nback);
        
        
       
        
        
    }
     public static void main(String[]args){
        new department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
       
    }
}
