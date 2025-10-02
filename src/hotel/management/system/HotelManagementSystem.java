
package hotel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener  {
       HotelManagementSystem(){
           setLayout(null);
           setBounds(100,100,1366,565);
           setVisible(true);
           
           
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(485,70,1500,50);
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.BOLD,30));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1200,450,100,50);
        image.add(next);
        next.addActionListener(this);
        setLayout(null);
        setVisible(true);
       }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new login();
        
    }
    
}
