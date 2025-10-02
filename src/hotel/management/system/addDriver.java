/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tname,tcompany,tage,tmodel,tlocation;
    JComboBox avlcombo,gendercombo;
    addDriver() {
        setLayout(null);
        setBounds(300,220,980,470);
        setVisible(true);


        JLabel heading = new JLabel("Add Driver");
        heading.setBounds(150,0,200,20);
        heading.setFont(new Font("Serif", Font.PLAIN, 17));
        add(heading);

        JLabel roomno = new JLabel("Name");
        roomno.setBounds(60,50,120,30);
        roomno.setFont(new Font("Serif", Font.PLAIN, 17));
        add(roomno);


        tname = new JTextField();
        tname.setBounds(200,50,150,30);
        add(tname);

        JLabel available = new JLabel("Age");
        available.setBounds(60,100,120,30);
        available.setFont(new Font("Serif", Font.PLAIN, 17));
        add(available);

        tage = new JTextField();
        tage.setBounds(200,100,150,30);
        add(tage);

        JLabel clean = new JLabel("Gender");
        clean.setBounds(60,150,120,30);
        clean.setFont(new Font("Serif", Font.PLAIN, 17));
        add(clean);

        String cleanop[]= {"Male","Female"};
        gendercombo = new JComboBox(cleanop);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);


        JLabel price = new JLabel("Car Company");
        price.setBounds(60,200,180,30);
        price.setFont(new Font("Serif", Font.PLAIN, 17));
        add(price);


        tcompany = new JTextField();
        tcompany.setBounds(200,200,150,30);
        add(tcompany);

        JLabel btype = new JLabel("Car Model");
        btype.setBounds(60,250,120,30);
        btype.setFont(new Font("Serif", Font.PLAIN, 17));
        add(btype);

        tmodel = new JTextField();
        tmodel.setBounds(200,250,150,30);
        add(tmodel);

        JLabel javailable = new JLabel("Available");
        javailable.setBounds(60,300,120,30);
        javailable.setFont(new Font("Serif", Font.PLAIN, 17));
        add(javailable);

        String avltype[]= {"Available","Busy"};
        avlcombo = new JComboBox(avltype);
        avlcombo.setBounds(200,300,150,30);
        avlcombo.setBackground(Color.WHITE);
        add(avlcombo);

        JLabel jlocation = new JLabel("Location");
        jlocation.setBounds(60,350,120,30);
        jlocation.setFont(new Font("Serif", Font.PLAIN, 17));
        add(jlocation);

        tlocation = new JTextField();
        tlocation.setBounds(200,350,150,30);
        add(tlocation);

        add = new JButton("Add Driver");
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setBounds(60,400,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(210,400,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,370);
        add(image);

    }
     public static void main(String[] args) {
        new addDriver();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == add){

            String name = tname.getText();
            String age = tage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company  = tcompany.getText();
            String model = (String)tmodel.getText();
            String available = (String)avlcombo.getSelectedItem();
            String location = tlocation.getText();
            
            try{
                Conn c = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
                
            }catch(Exception ae){
                ae.printStackTrace();
            }

        }
        else {
            setVisible(false);
        }
        
    }

}
