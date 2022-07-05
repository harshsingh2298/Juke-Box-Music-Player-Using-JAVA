package Harsh.Singh;

import Model.User;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static Harsh.Singh.Connection.getConnection;

public class CreateNew
{
    Scanner sc = new Scanner(System.in);
    User user = new User();
    public void createNewUser()
    {
        System.out.println("********************************************************* Creating New User **********************************************************");
        String name = "";
        String num ="";
        System.out.println(" Please Enter Your Name ");
             name = sc.next();

        String str1 = "[a-zA-Z]";
        String str = "^[0-9]{10}$";
        Pattern pattern1 = Pattern.compile(str1);
        Matcher matcher1 = pattern1.matcher(name);
             if (matcher1.find()==true){
                 user.setName(name);
            System.out.println(" Please Enter Your Mobile Number ");
             num = sc.next();
                 Pattern pattern = Pattern.compile(str);
                 Matcher matcher = pattern.matcher(num);
            if (matcher.find() == true) {
            user.setMobile(num);
            System.out.println(" Create User ID ");
            int userId = sc.nextInt();
            user.setUserId(userId);
            System.out.println(" Create Password ");
            String pp = sc.next();
            System.out.println("------------------------------------");
            System.out.println(" Re-enter Your Password ");
            String pass = sc.next();
            user.setPass(pass);
            System.out.println("---------------------------- Welcome User --------------------------------");}
        else {
            System.out.println("PLEASE CHECK YOUR NUMBER");
        }

        }else {
                 System.out.println("CHECK YOUR NAME");
             }
    }


    public void insert()
    {
        try
        {   getConnection();
            String query = "Insert into UserDetail values (" + user.getUserId() + ",'" + user.getPass() + "','" + user.getName() + "'," + user.getMobile() +")";
            Statement st = getConnection().createStatement();
            int rows = st.executeUpdate(query);
            System.out.println(" Details Saved ");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void existingUser( int userId , String pass)
    {
        try
        {   String validate = "";
            getConnection();

            String query = " select * from UserDetail where userId= "+userId;
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
               // System.out.println(rs1.getString(userId) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getLong(4));
                validate= rs1.getString(2);
            }
                if (validate.equals(pass)) {
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(" <---- WELCOME USER ----> ");
                    user.setUserId(userId);
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                } else
                {
                    System.out.println(" Invalid User ID or PASSWORD Please Try again ");

                }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}


