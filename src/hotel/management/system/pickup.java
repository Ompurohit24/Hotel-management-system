
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
public class pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeOfCar;
    JCheckBox available;
    pickup(){
        setLayout(null);
        setVisible(true);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("PickUp Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel jbed = new JLabel("Type OF Car");
        jbed.setBounds(50,100,100,20);
        add(jbed);
        
       typeOfCar = new Choice();
       typeOfCar.setBounds(150,10,200,25);
       add(typeOfCar);
       
       try {
           Conn c = new Conn();
           String query = "select * from driver";
           ResultSet rs  =c.s.executeQuery(query);
           while(rs.next()){
               typeOfCar.add(rs.getString("brand"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
        JLabel j1 = new JLabel("Name");
        j1.setBounds(50,160,100,20);
        add(j1);
        
         JLabel j2 = new JLabel("Age");
        j2.setBounds(200,160,100,20);
        add(j2);
        
          JLabel j3 = new JLabel("Gender");
        j3.setBounds(330,160,100,20);
        add(j3);
        
         JLabel j4 = new JLabel("Company");
        j4.setBounds(460,160,100,20);
        add(j4);
        
         JLabel j5 = new JLabel("Brand");
        j5.setBounds(630,160,100,20);
        add(j5);
        JLabel j6 = new JLabel("Avalaibility");
        j6 .setBounds(740,160,100,20);
        add(j6 );
        JLabel j7 = new JLabel("Location");
        j7.setBounds(890,160,100,20);
        add(j7);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try {
            Conn c = new Conn();
            String query = " select * from driver ";
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
        new pickup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         
        if(ae.getSource() == back){
            setVisible(false);
            new reception();
            
        }
       if(ae.getSource() == submit){
            try{
                 Conn c = new Conn();
                String query = "select *  from driver where brand = '"+typeOfCar.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
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
