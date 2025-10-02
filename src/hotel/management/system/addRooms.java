/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class addRooms extends JFrame implements ActionListener {
     JButton add,cancel;
    JTextField troom,tprice;
    JComboBox availablecombo,cleancombo,typecombo;
    
    addRooms() {
        setLayout(null);
        setBounds(330,220,940,470);
        setVisible(true);


        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Serif", Font.PLAIN, 17));
        add(heading);

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(60,80,120,30);
        roomno.setFont(new Font("Serif", Font.PLAIN, 17));
        add(roomno);


         troom = new JTextField();
        troom.setBounds(200,80,150,30);
        add(troom);

        JLabel available = new JLabel("Available");
        available.setBounds(60,130,120,30);
        available.setFont(new Font("Serif", Font.PLAIN, 17));
        add(available);

        String availableoptions[]= {"Available","Occupied"};
        availablecombo = new JComboBox(availableoptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(60,180,120,30);
        clean.setFont(new Font("Serif", Font.PLAIN, 17));
        add(clean);

        String cleanop[]= {"Clean","Dirty"};
         cleancombo = new JComboBox(cleanop);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);


        JLabel price = new JLabel("Price");
        price.setBounds(60,230,180,30);
        price.setFont(new Font("Serif", Font.PLAIN, 17));
        add(price);


         tprice = new JTextField();
        tprice.setBounds(200,230,150,30);
        add(tprice);

        JLabel btype = new JLabel("Bed Type");
        btype.setBounds(60,280,120,30);
        btype.setFont(new Font("Serif", Font.PLAIN, 17));
        add(btype);

        String typeop[]= {"Single Bed","Double Bed"};
         typecombo = new JComboBox(typeop);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

         add = new JButton("Add Room");
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

         cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,70,500,320);
        add(image);


    }
     public static void main(String[] args) {
        new addRooms();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == add){

            String room = troom.getText();
            String available = (String)availablecombo.getSelectedItem();
            String status = (String)cleancombo.getSelectedItem();
            String price  = tprice.getText();
            String type = (String)typecombo.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
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
