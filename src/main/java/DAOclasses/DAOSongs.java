package DAOclasses;

import InterFaces.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class DAOSongs implements Song {
    Scanner sc = new Scanner(System.in);
    @Override
    public void searchSong()
    {
        try {
            getConnection();
            System.out.println( "Enter Song Name" );
            String songNmae = sc.next();
            String query = "Select * from songs where songNmae =?";
            PreparedStatement creatlist = getConnection().prepareStatement(query);
            creatlist.setString(1,songNmae);
            ResultSet rs1 = creatlist.executeQuery();
            while (rs1.next())
            {
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(rs1.getString("userId") + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4) + "\t" + rs1.getString(5));
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void shotSong() {
        try {
            getConnection();
            String query = "Select * from songs order by songNmae ";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(rs1.getString("userId") + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4) + "\t" + rs1.getString(5));
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public void displayAllSong() {
        try {
            getConnection();
            String query = "Select * from songs";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
                System.out.println(rs1.getString("userId") + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4) + "\t" + rs1.getString(5));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
