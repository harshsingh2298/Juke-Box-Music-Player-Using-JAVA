package Harsh.Singh;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class PlayerAudio
{
    Scanner sc = new Scanner(System.in);
    public List<String> playSongs()
    {
        List<String> song = new ArrayList<>();
       try
       {
           String query = "Select filepath from songs";
           Statement st = getConnection().createStatement();
           ResultSet rs1 = st.executeQuery(query);
           while (rs1.next())
           {
//               song.add(rs1.getString(1));
//               System.out.println("all songs ->" +song);

               String location = rs1.getString(1);
                AddAudio addAudio = new AddAudio();
                addAudio.readAudio(location,1);

           }


       }
       catch (Exception e)
       {
           System.out.println(e);
       }
        return song;

    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<String> playPodCast()
    {
        List<String> podCast = new ArrayList<>();
        try
        {
            String query = "Select filepath from podcast";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
//                podCast.add(rs1.getString("podName")) ;
//                System.out.println("all Pod Cast->" +podCast);

                String location = rs1.getString(1);
                AddAudio addAudio = new AddAudio();
                addAudio.readAudio(location,1);

            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return podCast;
    }

//***********************************************************************************************************************************************************

    public void deleteSong()
    {
        try {

            getConnection();
            String query = "Select * from songs";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
                System.out.println("->" +rs1.getString("songNmae") );
            }
            System.out.println("----------------------------------------------");
            System.out.println(" --- Enter song You Want To Delete --- ");
            String playId = sc.next();
            String query2 = " Delete from songs where  songNmae = ?";
            PreparedStatement creatlist = getConnection().prepareStatement(query2);
            creatlist.setString(1, playId);
            int rows = creatlist.executeUpdate();
            System.out.println("-*-*- Song Deleted -*-*-");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//**********************************************************************************************************************************************************************



}
