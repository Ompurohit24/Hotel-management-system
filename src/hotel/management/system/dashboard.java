/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard  extends JFrame implements ActionListener {
    dashboard(){
            setBounds(0,0,1590,1000);
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1590,1000,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,1590,1000);
            add(image);

            JLabel text = new JLabel("THE SUN GROUP WELCOMES YOU");
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Serif", Font.PLAIN, 46));
            text.setBounds(400, 60, 1000, 85);
            image.add(text);

            JMenuBar mb = new JMenuBar();
            mb.setBounds(0,0,1550,30);
            image.add(mb);


            JMenu hotel = new JMenu("HOTEL MANAGEMENT");
            hotel.setForeground(Color.BLUE);
            mb.add(hotel);

            JMenu admin = new JMenu("Admin");
            admin.setForeground(Color.black);
            mb.add(admin);

            JMenuItem reception = new JMenuItem("RECEPTION");
            reception.addActionListener(this);
            reception.addActionListener(this);
            hotel.add(reception);

            JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
            addEmployee.addActionListener(this);
            admin.add(addEmployee);

            JMenuItem addrooms = new JMenuItem("ADD ROOMS");
            addrooms.addActionListener(this);
            admin.add(addrooms);

            JMenuItem adddriver = new JMenuItem("ADD DRIVER");
            adddriver.addActionListener(this);
            admin.add(adddriver);

            setVisible(true);
        }
    public static void main(String[]args){
        new dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ADD EMPLOYEE")){
                new addEmployee();
            } else if (e.getActionCommand().equals(("ADD ROOMS"))) {
                new addRooms();

            }else if (e.getActionCommand().equals("ADD DRIVER")){
                new addDriver();
        } else if (e.getActionCommand().equals("RECEPTION")) {
                new reception();
            }
    }
    
}
