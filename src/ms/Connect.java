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
      
