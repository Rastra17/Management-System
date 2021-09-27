//Making a Login GUI in Java
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

public class Login implements ActionListener
{
  private static JPanel panel;
  private static JFrame frame;
  private static JButton button;
  private static JTextField userText;
  private static JPasswordField password;
  private static JLabel user;
  private static JLabel pass;

  public static void main(String args[])
  {
    panel=new JPanel();
    frame=new JFrame();
    userText=new JTextField(20);
    password=new JPasswordField(20);
    password.setBounds(100,50,165,25);
    button=new JButton("Login");
    button.setBounds(100,80,80,25);
    button.addActionListener(new Login());

    frame.setSize(300,150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    userText.setBounds(100,20,165,25);

    frame.add(panel);
    frame.setTitle("Login System");

    panel.setLayout(null);

    user=new JLabel("Username:");
    user.setBounds(10,20,80,25);
    pass=new JLabel("Password:");
    pass.setBounds(10,50,80,25);

    panel.add(user);
    panel.add(button);
    panel.add(pass);
    panel.add(password);
    panel.add(userText);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
    String userget=userText.getText();
    String passget=new String(password.getPassword());
    System.out.println("Username: "+userget);
    System.out.println("Password: "+passget);
    if (userget.equals("admin") && passget.equals("password"))
    {
      JOptionPane.showMessageDialog(null,"Logged in successfully!","Success"
      ,JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      JOptionPane.showMessageDialog(null,"Entry mismatch","Failed!"
      ,JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
