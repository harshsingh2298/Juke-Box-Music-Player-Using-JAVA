package Harsh.Singh;

import java.sql.DriverManager;

public class Connection
{
    public static java.sql.Connection getConnection()
    {
        java.sql.Connection con=null;
        try
        {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JunkBox","root","Harsh@12345");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;

    }

}
