package src.ms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Registration extends JFrame implements ActionListener 
{
    private JFrame signup_frame;
    private JLabel fullName,userName,email,cont_no,add,pass;
    private JTextField e_fullName,e_userName,e_email,e_contact,e_add,e_pass;
    private int valx=100, valy=40;
    private JButton confirm_reg,Exit,Back;
    private int bx=(valx+170), by=valy+360;

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

    