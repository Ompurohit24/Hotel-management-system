/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener  {
    JButton newcustomer,department,allEmployee,ManagerInfo,customers,SearchRoom,UpdateStatus,UpdateRoomStatus,Pickup;
     JButton rooms,Checkout,logout;
     reception(){
        setLayout(null);
        setBounds(350,200,800,570);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

         newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,50,200,30);
        newcustomer.setBackground(Color.black);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);

         rooms = new JButton("Rooms");
        rooms.setBounds(10,90,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

         department = new JButton("Department");
        department.setBounds(10,130,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

         allEmployee = new JButton("EmployeeInfo");
        allEmployee.setBounds(10,170,200,30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customers");
        customers.setBounds(10,210,200,30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

         ManagerInfo = new JButton("ManagerInfo");
        ManagerInfo.setBounds(10,250,200,30);
        ManagerInfo.setBackground(Color.black);
        ManagerInfo.setForeground(Color.WHITE);
        ManagerInfo.addActionListener(this);
        add(ManagerInfo);

        Checkout = new JButton("Checkout");
        Checkout.setBounds(10,290,200,30);
        Checkout.setBackground(Color.black);
        Checkout.setForeground(Color.WHITE);
        Checkout.addActionListener(this);
        add(Checkout);


         UpdateStatus = new JButton("Update Status");
        UpdateStatus.setBounds(10,330,200,30);
        UpdateStatus.setBackground(Color.black);
        UpdateStatus.setForeground(Color.WHITE);
        UpdateStatus.addActionListener(this);
        add(UpdateStatus);
        
        UpdateRoomStatus = new JButton("Update Room Status");
        UpdateRoomStatus.setBounds(10,370,200,30);
        UpdateRoomStatus.setBackground(Color.black);
        UpdateRoomStatus.setForeground(Color.WHITE);
        UpdateRoomStatus.addActionListener(this);
        add(UpdateRoomStatus);

         Pickup = new JButton("Pickup Service");
        Pickup.setBounds(10,410,200,30);
        Pickup.setBackground(Color.black);
        Pickup.setForeground(Color.WHITE);
        Pickup.addActionListener(this);
        add(Pickup);

         SearchRoom = new JButton("Search Room");
        SearchRoom.setBounds(10,450,200,30);
        SearchRoom.setBackground(Color.black);
        SearchRoom.setForeground(Color.WHITE);
        SearchRoom.addActionListener(this);
        add(SearchRoom);

       logout = new JButton("Logout");
        logout.setBounds(10,490,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,50,500,470);
        add(image);

    }
    public static void main(String[]args){
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newcustomer){
             setVisible(false);
        new addcustomer();
        }else if(e.getSource() == rooms){
            setVisible(false);
            new room();
        }else if(e.getSource() == department){
            setVisible(false);
            new department();
        }else if(e.getSource() == allEmployee){
            setVisible(false);
            new employeeinfo();
    }else if(e.getSource() == ManagerInfo){
            setVisible(false);
            new managerinfo();
    } else if(e.getSource() == customers){
            setVisible(false);
            new customerinfo();
}else if(e.getSource() == SearchRoom){
            setVisible(false);
            new searchRoom();
        
}else if(e.getSource() == UpdateStatus){
            setVisible(false);
            new updateCheck();
}else if(e.getSource() == UpdateRoomStatus){
            setVisible(false);
            new updateRoom();
}else if(e.getSource() == Pickup){
            setVisible(false);
            new pickup();
}else if(e.getSource() == Checkout){
            setVisible(false);
            new checkOut();
}
        else if(e.getSource() == logout){
            setVisible(false);
            new checkOut();
            System.exit(0);
}
}
}