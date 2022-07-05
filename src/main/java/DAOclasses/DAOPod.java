package DAOclasses;

import InterFaces.Pod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class DAOPod implements Pod {
    Scanner sc = new Scanner(System.in);
    @Override
    public void displayPodcast() {
        try {
            getConnection();
            String query = "Select * from podcast";
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

    @Override
    public void searchAllPod() {
        try {
            getConnection();
            System.out.println( "Enter PodCast Name" );
            String songNmae = sc.next();
            String query = "Select * from podcast where podName =?";
            PreparedStatement creatlist = getConnection().prepareStatement(query);
            creatlist.setString(1,songNmae);
            ResultSet rs1 = creatlist.executeQuery();
            while (rs1.next())
            {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(rs1.getString("userId") + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4) + "\t" + rs1.getString(5));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public void shortPod() {
        try {
            getConnection();
            String query = "Select * from podcast order by podName ";
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
    public void deletePodCast() {
        try {

            getConnection();
            String query = "Select * from podcast";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
                System.out.println("->" +rs1.getString("podName"));
            }
            System.out.println("----------------------------------------------");
            System.out.println(" --- Enter podCast You Want To Delete --- ");
            String playId = sc.next();
            String query2 = " Delete from songs where  podName = ?";
            PreparedStatement creatlist = getConnection().prepareStatement(query2);
            creatlist.setString(1, playId);
            int rows = creatlist.executeUpdate();
            System.out.println(" *-*- PodCast Deleted -*-*- ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
