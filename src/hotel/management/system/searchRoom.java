
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class searchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    searchRoom(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel jbed = new JLabel("Bed Type");
        jbed.setBounds(50,100,100,20);
        add(jbed);
        
        bedtype = new JComboBox(new String [] {"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only Display Available");
        available.setBackground(Color.WHITE);
        available.setBounds(650,100,150,25);
        add(available);
        
        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(50,160,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Availability");
        j2.setBounds(270,160,100,20);
        add(j2);
        
          JLabel j3 = new JLabel("Cleaning Status");
        j3.setBounds(450,160,100,20);
        add(j3);
        
         JLabel j4 = new JLabel("Price");
        j4.setBounds(670,160,100,20);
        add(j4);
        
         JLabel j5 = new JLabel("Bed-Type");
        j5.setBounds(870,160,100,20);
        add(j5);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try {
            Conn c = new Conn();
            String query = " select * from room ";
            ResultSet rs = c.s.executeQuery(query) ;
            table.setModel(DbUtils.resultSetToTableModel(rs));   
        }catch(Exception e){
            e.printStackTrace();
        }
        
         submit = new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        back = new JButton("Back");
        back.setBounds(500,520,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
     
    }
     public static void main(String[]args){
        new searchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         
        
        if(ae.getSource() == submit){
            try{
                 Conn c = new Conn();
                ResultSet rs;
                String query1 = "select *  from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select *  from room where availability  = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'  ";
               
                if(available.isSelected()){
                    rs= c.s.executeQuery(query2);
                }else{
                    rs= c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
               e.printStackTrace();
            }
            
        }else {
                setVisible(false);
        new reception();
                }
       
       
    }
}
