//To test the database in Java with exception handlers
package src.ms;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Connect
{
  public static void main(String args[])
  {
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String Url="jdbc:mysql://localhost:3306/ms";
      String User="root";
      String Password="root";
      Connection db=DriverManager.getConnection(Url,User,Password);

      Statement st=db.createStatement();
      st.executeUpdate("CREATE TABLE IF NOT EXISTS customer_details(user_id INTEGER AUTO_INCREMENT Primary Key,fullname VARCHAR(255),username VARCHAR(255),email VARCHAR(255),password VARCHAR(255),address VARCHAR(255),contact VARCHAR(255));");
      db.close();

    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    finally
    {
      System.out.println("Closed database");
    }
  }
}
