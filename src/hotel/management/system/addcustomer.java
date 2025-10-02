/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.*;
import java.sql.*;
public class addcustomer extends JFrame implements ActionListener{
   JComboBox comboid;
    JTextField tnumber,tname,tcountry,tdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel jchkin;
    JButton add,back;
    addcustomer(){
        setLayout(null);
        setVisible(true);

        setBounds(350,200,800,550);
        getContentPane().setBackground(Color.WHITE);


        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,0,300,100);
        text.setFont(new Font("Raleway",Font.BOLD,17));
        add(text);

        JLabel jid = new JLabel("ID");
        jid.setBounds(35,80,100,20);
        jid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jid);

        String options[]={"Adhar Card","Passport","Voter ID Card","Driving License"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        add(comboid);

        JLabel jnumber = new JLabel("Number");
        jnumber.setBounds(35,120,100,20);
        jnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jnumber);

        tnumber=new JTextField();
        tnumber.setBounds(200,120,150,25);
        add(tnumber);

        JLabel jname = new JLabel("Name");
        jname.setBounds(35,160,100,20);
        jname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jname);

        tname=new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);

        JLabel jgender = new JLabel("Gender");
        jgender.setBounds(35,200,100,20);
        jgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        JLabel jcountry = new JLabel("Country");
        jcountry.setBounds(35,240,100,20);
        jcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jcountry);

        tcountry=new JTextField();
        tcountry.setBounds(200,240,150,25);
        add(tcountry);

        JLabel jroom = new JLabel("AllocateRoom");
        jroom.setBounds(35,280,160,20);
        jroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jroom);

        croom = new Choice();
        try{
            Conn c = new Conn();
            String query = "select * from  room where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);


        JLabel jtime = new JLabel("Check IN");
        jtime.setBounds(35,320,160,20);
        jtime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jtime);


        Date date = new Date();


        jchkin = new JLabel(""+date);
        jchkin.setBounds(200,320,150,20);
        jchkin.setFont(new Font("Raleway",Font.PLAIN,15));
        add(jchkin);
        
        JLabel jdeposit = new JLabel("Deposit");
        jdeposit.setBounds(35,360,100,20);
        jdeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(jdeposit);

        tdeposit=new JTextField();
        tdeposit.setBounds(200,360,150,25);
        add(tdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);
        
         back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

    } 
    public static void main(String[]args){
        new addcustomer();
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            String id = (String)comboid.getSelectedItem();
            String number = tnumber.getText();
            String name = tname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            
            String country = tcountry.getText();
            String room = croom.getSelectedItem();
            String time = jchkin.getText();
            String deposit = tdeposit.getText();
            
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new reception();
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else if (e.getSource() == back){
            setVisible(false);
                new reception();
                
        }
        
    }
}
