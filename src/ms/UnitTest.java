package src.ms;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTest 
{
    boolean isUserAvailable = false;
    boolean result;
    String user = "asd@gmail.com";
    String pass ="sad";

    String contactno = "";
    String address = "";
    String Fullname = "";

    @Before
    public void init() throws SQLException 
    {

        result = false;
        Connection connection = DriverManager.getConnection("jdbc:mysql:jdbc:mysql://localhost:3306/ms","root","root");
        PreparedStatement checkUser = connection.prepareStatement("SELECT * from customer_details WHERE email = ? and password = ?");
        checkUser.setString(1,user);
        checkUser.setString(2,pass);
        ResultSet resultSet = checkUser.executeQuery();
        if (resultSet.next())
        {
            contactno = resultSet.getString("contact");
            address = resultSet.getString("address");
            Fullname = resultSet.getString("fullname");
            resultSet.close();
            checkUser.close();
            isUserAvailable = true;
            result = true;

        }
        else 
        {
            resultSet.close();
            checkUser.close();
            connection.close();
        }

    }

    @Test
    public void UserCheck()
    {
        assertTrue(isUserAvailable);
    }
    @Test
    public void UserContact()
    {

        assertEquals("0123456789",contactno);
    }
    @Test
    public void UserAddress()
    {
        assertEquals("London",address);
    }
    @Test
    public void UserFullname()
    {
        assertEquals("Robin",Fullname);
    }

    @Test
    public void LoginCheck()
    {
        assertTrue(result);
    }

}