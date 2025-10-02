/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
/**
 *
 * @author Dell
 */
public class updateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField troom,tavailable,tstatus,tpaid,tpending;
    JButton check,update,back;
    
    updateRoom(){
        setBounds(300,200,980,450);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel jid = new JLabel("Customer ID");
        jid.setBounds(30,80,100,20);
        add(jid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        
        try {
            
            Conn c = new Conn();
            String query = " select * from customer ";
            ResultSet rs = c.s.executeQuery(query) ;
            while(rs.next()){
                ccustomer.add(rs.getString("dcnumber"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel jroom = new JLabel("Room Number");
        jroom.setBounds(30,130,100,20);
        add(jroom);
        
        troom = new JTextField();
        troom.setBounds(200,130,150,25);
        add(troom);
        
        JLabel jname = new JLabel("Availability");
        jname.setBounds(30,180,100,20);
        add(jname);
        
        tavailable = new JTextField();
        tavailable.setBounds(200,180,150,25);
        add(tavailable);
        
        JLabel jcheckin = new JLabel("Cleaning Status");
        jcheckin.setBounds(30,230,100,20);
        add(jcheckin);
        
        tstatus = new JTextField();
        tstatus.setBounds(200,230,150,25);
        add(tstatus);
        
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
    }
    public static void main (String[]args){
        new updateRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new reception();
        }
        if(ae.getSource() == check){
           String id = ccustomer.getSelectedItem();
        String query = "select * from customer where dcnumber =   '"+id+"' ";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                troom.setText(rs.getString("room"));
            }
            String query2= " select * from room where roomnumber = "+troom.getText()+" ";
            ResultSet rs2 = c.s.executeQuery(query2);
            while(rs2.next()){
                tavailable.setText(rs2.getString("availability"));
                tstatus.setText(rs2.getString("cleaning_status"));
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = troom.getText();
            String available = tavailable.getText();
            String status = tstatus.getText();
       
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"' ");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            
        }
        
    }
}
