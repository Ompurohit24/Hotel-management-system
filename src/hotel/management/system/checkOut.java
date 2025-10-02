
package hotel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class checkOut extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel jrnumber,jcheckinTime,jcheckoutTime;
     JButton chkout,back;
    checkOut(){
        
        setLayout(null);
        setVisible(true);
        setBounds(370,200,800,400);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text = new JLabel("Checkout");
         text.setBounds(100,20,100,30);
         text.setForeground(Color.BLACK);
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         add(text);
         
         JLabel jid = new JLabel("Customer ID:");
         jid.setBounds(30,80,100,30);
         add(jid);
         
          ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        
      
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        
        
        JLabel jroom = new JLabel("Room Number");
         jroom.setBounds(30,130,100,30);
         add(jroom);
         
             jrnumber = new JLabel("");
         jrnumber.setBounds(150,130,100,30);
         add(jrnumber);
         
         
         JLabel jcheckin = new JLabel("CheckIn Time");
         jcheckin.setBounds(30,180,100,30);
         add(jcheckin);
         
         
         Date date = new Date();
         jcheckinTime = new JLabel("" );
         jcheckinTime.setBounds(150,180,100,30);
         add(jcheckinTime);
         
           try {
            
            Conn c = new Conn();
            String query = " select * from customer ";
            ResultSet rs = c.s.executeQuery(query) ;
            while(rs.next()){
                ccustomer.add(rs.getString("dcnumber"));
                jrnumber.setText(rs.getString("room"));
                jcheckinTime.setText(rs.getString("checkin"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         
          JLabel jcheckout = new JLabel("CheckOut Time");
         jcheckout.setBounds(30,230,100,30);
         add(jcheckout);
         
             jcheckoutTime = new JLabel("" + date);
         jcheckoutTime.setBounds(150,230,150,30);
         add(jcheckoutTime);
         
         chkout = new JButton("Checkout");
         chkout.setBounds(30,280,120,30);
         chkout.setForeground(Color.WHITE);
         chkout.setBackground(Color.BLACK);
         chkout.addActionListener(this);
         add(chkout);
         
         back = new JButton("Back");
         back.setBounds(170,280,120,30);
         back.setForeground(Color.WHITE);
         back.setBackground(Color.BLACK);
         back.addActionListener(this);
         add(back);
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 =  new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,70,400,250);
        add(image);
         
         
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == chkout){
           
            String query1 = "delete from customer where dcnumber =  '"+ccustomer.getSelectedItem()+"'  ";
            String query2 = " update room set availability = 'Available' where roomnumber = '"+jrnumber.getText()+"' ";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                   setVisible(false);
            new reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
             setVisible(false);
            new reception();
        }
    }
    public static void main(String[]args){
        new checkOut();
    }
}
