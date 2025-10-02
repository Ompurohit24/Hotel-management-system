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
public class updateCheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField troom,tname,tcheckin,tpaid,tpending;
    JButton check,update,back;
    
    updateCheck(){
        setBounds(300,200,980,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        jroom.setBounds(30,120,100,20);
        add(jroom);
        
        troom = new JTextField();
        troom.setBounds(200,120,150,25);
        add(troom);
        
        JLabel jname = new JLabel("Name");
        jname.setBounds(30,160,100,20);
        add(jname);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
        JLabel jcheckin = new JLabel("CheckIn");
        jcheckin.setBounds(30,200,100,20);
        add(jcheckin);
        
        tcheckin = new JTextField();
        tcheckin.setBounds(200,200,150,25);
        add(tcheckin);
        
        JLabel jpaid = new JLabel("Amount Paid");
        jpaid.setBounds(30,240,100,20);
        add(jpaid);
        
        tpaid = new JTextField();
        tpaid.setBounds(200,240,150,25);
        add(tpaid);
        
        JLabel jpending = new JLabel("Pending Amount");
        jpending.setBounds(30,280,100,20);
        add(jpending);
        
        tpending = new JTextField();
        tpending.setBounds(200,280,150,25);
        add(tpending);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
       
    }
    public static void main (String[]args){
        new updateCheck();
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
                tname.setText(rs.getString("name"));
                tcheckin.setText(rs.getString("checkin"));
                tpaid.setText(rs.getString("deposit"));
            }
            String query2=" select * from room where roomnumber = '"+troom.getText()+"' ";
            ResultSet rs2 = c.s.executeQuery(query2);
            while(rs2.next()){
                String price = rs2.getString("price");
                int amountPaid = Integer.parseInt(price) - Integer.parseInt(tpaid.getText());
                tpending.setText( ""  + amountPaid);
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = troom.getText();
            String name = tname.getText();
            String checkin = tcheckin.getText();
            String deposit = tpaid.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkin = '"+checkin+"', deposit = '"+deposit+"' where dcnumber = '"+number+"' ");
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
