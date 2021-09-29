package src.ms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.sql.*;

public class Registration extends JFrame implements ActionListener 
{
    private JFrame signup_frame;
    private JLabel fullName,userName,email,cont_no,add,pass;
    private JTextField e_fullName,e_userName,e_email,e_contact,e_add,e_pass;
    private int valx=100, valy=40;
    private JButton confirm_reg,Exit,Back;
    private int bx=(valx+170), by=valy+360;
    int val;
    ResultSet result;

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public Registration()
    {
        signup_frame = new JFrame();
        signup_frame.setTitle("Registration");
        signup_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signup_frame.setSize(900,600);
        signup_frame.setResizable(false);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()-signup_frame.getWidth()));
        int y = (int) ((dimension.getHeight()-signup_frame.getHeight()));
        signup_frame.setLocation(x/2,y/2);
        
        fullName = new JLabel(" Full Name ");
        fullName.setFont(new Font("Arial",Font.BOLD,30));
        fullName.setBounds(valx,valy,190,50);
        fullName.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(fullName);
        
        userName = new JLabel(" UserName: ");
        userName.setFont(new Font("Arial",Font.BOLD,30));
        userName.setBounds(valx,valy+60,190,50);
        userName.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(userName);
        
        email = new JLabel(" Email: ");
        email.setFont(new Font("Arial",Font.BOLD,30));
        email.setBounds(valx,valy+120,190,50);
        email.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(email);
        
        cont_no = new JLabel(" Contact:  ");
        cont_no.setFont(new Font("Arial",Font.BOLD,30));
        cont_no.setBounds(valx,valy+180,190,50);
        cont_no.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(cont_no);
        
        add = new JLabel(" Address: ");
        add.setFont(new Font("Arial",Font.BOLD,30));
        add.setBounds(valx,valy+240,190,50);
        add.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(add);
        
        pass = new JLabel(" Password: ");
        pass.setFont(new Font("Arial",Font.BOLD,30));
        pass.setBounds(valx,valy+300,190,50);
        pass.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(pass);

        confirm_reg = new JButton(" Confirm Registration ");
        confirm_reg.setFont(new Font("Arial",Font.BOLD,30));
        confirm_reg.setBounds(bx,by,350,50);
        confirm_reg.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(confirm_reg);
        
        Back = new JButton(" Back ");
        Back.setFont(new Font("Arial",Font.BOLD,30));
        Back.setBounds(bx,by +55,350,50);
        Back.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(Back);
        
        Exit = new JButton(" Exit ");
        Exit.setFont(new Font("Arial",Font.BOLD,30));
        Exit.setBounds(bx,by +110,350,50);
        Exit.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(Exit);
        
        e_fullName = new JTextField();
        e_fullName.setBounds(valx+230,valy,480,48);
        e_fullName.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_fullName);

        e_userName = new JTextField();
        e_userName.setBounds(valx+230,valy+60,480,48);
        e_userName.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_userName);

        e_email = new JTextField();
        e_email.setBounds(valx+230,valy+120,480,48);
        e_email.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_email);

        e_contact = new JTextField();
        e_contact.setBounds(valx+230,valy+180,480,48);
        e_contact.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_contact);

        e_add = new JTextField();
        e_add.setBounds(valx+230,valy+240,480,48);
        e_add.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_add);

        e_pass = new JTextField();
        e_pass.setBounds(valx+230,valy+300,480,48);
        e_pass.setFont(new Font("Arial",Font.BOLD,30));
        signup_frame.add(e_pass);

        confirm_reg.addActionListener(this);
        Back.addActionListener(this);
        Exit.addActionListener(this);

        signup_frame.setLayout(null);
        signup_frame.setVisible(true);
    }

    public static void main(String args[])
    {
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        String a = e_fullName.getText();
        String b = e_userName.getText();
        String c = e_email.getText();
        String d = e_contact.getText();
        String add_e = e_add.getText();
        String f = e_pass.getText();

        if (e.getSource()==confirm_reg)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String Url="jdbc:mysql://localhost:3306/ms";
                String User="root";
                String Password="root";
                Connection db=DriverManager.getConnection(Url,User,Password);
                Statement st=db.createStatement();
                result=st.executeQuery("SELECT email FROM ms.customer_details WHERE email='"+c+"';");

                if(a!="" || b!="" || c!="" || d!="" || add_e!="" || f!="")
                {
                    if(!result.next())
                    {
                        String query="INSERT INTO ms.customer_details(fullname,username,email,password,address,contact) VALUES('"+a+"','"+b+"','"+c+"','"+f+"','"+add_e+"','"+d+"');";
                        val=st.executeUpdate(query);
                        if(val>0)
                        {
                            JOptionPane.showMessageDialog(null,"Registered successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else if(c==result.getString(1))
                    {
                    JOptionPane.showMessageDialog(null,"Entry Already Exists!","Failed!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Empty Field(s)!","Failed!",JOptionPane.INFORMATION_MESSAGE);
                }
                db.close();
            }
            catch(Exception z)
            {
                System.out.println(z);
            }
            finally
            {
                System.out.println("Closed database");
            }

        }
        else if(e.getSource()==Back)
        {
            signup_frame.setVisible(false);
            new Registration().setVisible(true);
        }
        else if (e.getSource()==Exit)
        {
            signup_frame.setVisible(false);
        }
    }
}