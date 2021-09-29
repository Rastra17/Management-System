package src.ms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener
{
  private static JPanel panel;
  private static JFrame frame;
  private static JButton login;
  private static JTextField userText;
  private static JPasswordField password;
  private static JLabel user;
  private static JLabel pass;
  private static JButton delete;
  static JLabel NewLabel;
  ResultSet result;

  public static void main(String args[])
  {
    panel=new JPanel();
    frame=new JFrame();
    userText=new JTextField(20);
    password=new JPasswordField(20);
    password.setBounds(100,50,165,25);
    login=new JButton("Login");
    delete=new JButton("Delete");
    login.setBounds(55,80,80,25);
    delete.setBounds(150,80,80,25);
    login.addActionListener(new Login());
    panel.setBackground(new Color(0,0,0,100));
    panel.setLayout(null);

    frame.setSize(500,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    userText.setBounds(100,20,165,25);

    frame.add(panel);
    frame.setTitle("Login System");

    panel.setLayout(null);

    user=new JLabel("Email:");
    user.setBounds(10,20,80,25);
    pass=new JLabel("Password:");
    pass.setBounds(10,50,80,25);

    panel.add(user);
    panel.add(login);
    panel.add(pass);
    panel.add(password);
    panel.add(userText);
    panel.add(delete);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
    String userget=userText.getText();
    String passget=new String(password.getPassword());
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String Url="jdbc:mysql://localhost:3306/ms";
      String User="root";
      String Password="root";
      Connection db=DriverManager.getConnection(Url,User,Password);
      Statement st=db.createStatement();

      if(e.getSource()==login)
      {

        if(userget!="" || passget!="")
        {
          String query="SELECT email, password FROM ms.customer_details WHERE email='"+userget+"' AND password='"+passget+"';";
          result=st.executeQuery(query);
          result.next();
          String echeck=result.getString("email");
          String pcheck=result.getString("password");
          
          if(userget.equals(echeck) && passget.equals(pcheck))
          {
            JOptionPane.showMessageDialog(null,"Logged in successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
          }
          
          else
          {
            JOptionPane.showMessageDialog(null,"Entry does not exist!","Failed",JOptionPane.INFORMATION_MESSAGE);
          }
          
        }
        else
        {
          JOptionPane.showMessageDialog(null,"Empty Fields!","Failed",JOptionPane.INFORMATION_MESSAGE);
        }
      }
      else if(e.getSource()==delete)
      {
        if(userget!="" || passget!="")
        {
          String query="SELECT email, password FROM ms.customer_details WHERE email='"+userget+"' AND password='"+passget+"';";
          result=st.executeQuery(query);
          result.next();
          String echeck=result.getString("email");
          String pcheck=result.getString("password");
        
          if(userget.equals(echeck) && passget.equals(pcheck))
          {
            st.executeUpdate("DELETE FROM Management.users WHERE email='"+userget+"' AND password='"+passget+"';");
          }
        
          else
          {
            JOptionPane.showMessageDialog(null,"Entry does not exist!","Failed",JOptionPane.INFORMATION_MESSAGE);
          }
        
        }
        else
        {
          JOptionPane.showMessageDialog(null,"Empty Fields!","Failed",JOptionPane.INFORMATION_MESSAGE);
        }
      }

      db.close();
    }
    catch(Exception f)
    {
      System.out.println(f);
    }
    finally
    {
      System.out.println("Closed Database!");
    }
  }
}
