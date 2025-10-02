/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.jar.JarEntry;
import java.sql.ResultSet;
public class login extends JFrame implements ActionListener {
     JLabel user,pass;
    JTextField username,password;
    JButton login,cancel;
    public login(){
        getContentPane().setBackground(Color.WHITE);


        setLayout(null);

        user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

         pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        username = new JTextField();
        username.setBounds(130,20,150,30);
        add(username);

        password = new JTextField();
        password.setBounds(130,70,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == login){
                String user = username.getText();
                String pass = password.getText();
                
             try{
            Conn c = new Conn();
            String query = "select * from login where username = '"+user+"' and password = '"+ pass+"'";
            ResultSet rs = c.s.executeQuery(query) ;
                if (rs.next()) {
                    new dashboard();

                } else {

                    JOptionPane.showMessageDialog(null, "invalid");
                }
            } catch (Exception ae) {
            ae.printStackTrace();
        }
             
         }else if(e.getSource() == cancel){
             setVisible(false);
         }
    }
}
