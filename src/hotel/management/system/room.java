
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    room(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,1050,600);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(5,10,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Availability");
        j2.setBounds(100,10,100,20);
        add(j2);
        
          JLabel j3 = new JLabel("Status");
        j3.setBounds(205,10,100,20);
        add(j3);
        
         JLabel j4 = new JLabel("Price");
        j4.setBounds(310,10,100,20);
        add(j4);
        
         JLabel j5 = new JLabel("Bed-Type");
        j5.setBounds(415,10,100,20);
        add(j5);
        
        
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try {
            
            Conn c = new Conn();
            String query = " select * from room ";
            ResultSet rs = c.s.executeQuery(query) ;
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
    }
     public static void main(String[]args){
        new room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
       
    }
}
