
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addEmployee extends JFrame implements ActionListener {
    
        JTextField tname,temail,tphone,tage,tsalary,taadhar;
        JRadioButton rbmale,rbfemale;
        JButton submit;
        JComboBox cbjob;

        addEmployee(){
        setLayout(null);
        setBounds(350,200,850,540);
        setVisible(true);
            getContentPane().setBackground(Color.WHITE);

        JLabel jname = new JLabel("Name");
        jname.setBounds(60,30,100,30);
        jname.setFont(new Font("Serif", Font.PLAIN, 17));
        add(jname);


        tname = new JTextField();
        tname.setBounds(130,30,100,30);
        add(tname);

        JLabel jage = new JLabel("Age");
        jage.setBounds(60,90,100,30);
        jage.setFont(new Font("Serif", Font.PLAIN, 17));
        add(jage);

         tage = new JTextField();
        tage.setBounds(130,90,100,30);
        add(tage);

            JLabel jgender = new JLabel("Gender");
            jgender.setBounds(60,150,100,30);
            jgender.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jgender);

             rbmale = new JRadioButton("Male");
            rbmale.setBounds(130,150,70,30);
            rbmale.setFont(new Font("Serif", Font.PLAIN, 17));
            add(rbmale);

            rbfemale = new JRadioButton("Female");
            rbfemale.setBounds(220,150,100,30);
            rbfemale.setFont(new Font("Serif", Font.PLAIN, 17));
            add(rbfemale);

            JLabel jjob = new JLabel("Job");
            jjob.setBounds(60,200,100,30);
            jjob.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jjob);

            String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            cbjob = new JComboBox(str);
            cbjob.setBounds(130,200,150,30);
            cbjob.setBackground(Color.WHITE);
            add(cbjob);

            JLabel jsalary = new JLabel("Salary");
            jsalary.setBounds(60,260,100,30);
            jsalary.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jsalary);

            tsalary = new JTextField();
            tsalary.setBounds(130,260,100,30);
            add(tsalary);

            JLabel jphone = new JLabel("Phone");
            jphone.setBounds(60,310,100,30);
            jphone.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jphone);

             tphone = new JTextField();
            tphone.setBounds(130,310,100,30);
            add(tphone);

            JLabel jemail = new JLabel("Email");
            jemail.setBounds(60,360,100,30);
            jemail.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jemail);

             temail = new JTextField();
            temail.setBounds(130,360,100,30);
            add(temail);

            JLabel jaadhar = new JLabel("Aadhar");
            jaadhar.setBounds(60,420,100,30);
            jaadhar.setFont(new Font("Serif", Font.PLAIN, 17));
            add(jaadhar);

            taadhar = new JTextField();
            taadhar.setBounds(130,420,100,30);
            add(taadhar);

             submit = new JButton("SUBMIT");
            submit.setBounds(130,460,100,30);
            submit.addActionListener(this);
            add(submit);
            
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        }
        public static void main(String[]args){
            new addEmployee();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String name = tname.getText();
        String age = tage.getText();
        String salary = tsalary.getText();
        String phone = tphone.getText();
        String aadhar = taadhar.getText();
        String email = temail.getText();

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        String gender = null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name Should Not Be Empty");
            return;
        }
        if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age Should Not Be Empty");
            return;
        }
        if(email.equals("") && email.contains("@") && email.contains(".com")) {
        
            JOptionPane.showMessageDialog(null,"Email Should Not Be Empty");
            return;
        
    }

        if(rbmale.isSelected()){
            gender = "male";

        }else if(rbfemale.isSelected()){
            gender = "female";
        }
        String job = (String) cbjob.getSelectedItem();
        
        try{
            
            Conn c = new Conn();
            
            
            String query ="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
}
