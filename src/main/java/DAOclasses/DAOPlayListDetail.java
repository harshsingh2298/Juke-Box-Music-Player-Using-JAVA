package DAOclasses;

import Harsh.Singh.AddAudio;
import Model.PlayListDetail;
import Model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class DAOPlayListDetail {
    Scanner sc = new Scanner(System.in);

    public void addSongsPlaylist() {
        try {
            getConnection();
            System.out.println(" Enter PlayList NAME ");
            String playId = sc.next();
            System.out.println(" Songs Available \n 1. Alive \n 2. Animal \n 3. Get Low ");
            String songName = sc.next();
            System.out.println(" PodCast Available \n 1. Laughter \n 2. The_Love \n 3. Daily_Habits \n 4. Good_Life");
            String podName = sc.next();
            getConnection();
            String query = "Select * from playList";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next()) {
                System.out.println(" ----------------- PlayList Genre -------------------- ");
                System.out.println(rs1.getString("playlistName"));
            }
            String playlist = sc.next();
            String query1 = " Insert into playlistDetail values('" + playId + "','" + songName + "','" + podName + "','" + playlist + "')";
            Statement st1 = getConnection().createStatement();
            int rows = st1.executeUpdate(query1);
            System.out.println(" PlayList Song and PodCast Added ");
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public void displayPlaylistDetails() {
        try {
            getConnection();
            String query = "Select * from playlistDetail";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next()) {
                System.out.println(rs1.getString("playId") + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void deletePlayList() {
        try {

            getConnection();
            String query = "Select * from playlistDetail";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next()) {
                System.out.println("->" + rs1.getString("playId"));
            }
            System.out.println("----------------------------------------------");
            System.out.println(" --- Enter PLay List You Want To Delete --- ");
            String playId = sc.next();
            String query2 = " Delete from playlistDetail where  playListName =?";
            PreparedStatement creatlist = getConnection().prepareStatement(query2);
            creatlist.setString(1, playId);
            int rows = creatlist.executeUpdate();
            System.out.println(" PlayList Deleted ");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  List<PlayListDetail> playListPLAY() {
        List<PlayListDetail> playlist = new ArrayList<>();
        String pod = "";
        String song = "";
        try {

            getConnection();
            System.out.println("Enter Play Id");
            String playId = sc.next();
            String quey = "select * from playlistDetail where playId =?";
            PreparedStatement creatlist = getConnection().prepareStatement(quey);
            creatlist.setString(1,playId);
            ResultSet rs1 = creatlist.executeQuery();
            while (rs1.next()) {
                pod = rs1.getString(3);
                song = rs1.getString(2);
                playlist.add(new PlayListDetail(song, pod));
            }


        }
        catch (Exception e) {
            System.out.println(e);
        }
        return playlist;

    }


     public List<Songs> listPlay(){
         List<PlayListDetail> podsong = this.playListPLAY();
         String podname = "";
         String songname = "";
         String filepath = "";
         List<Songs> songpath = new ArrayList<>();


         for (PlayListDetail x:podsong) {
             try {
                 podname = x.getPodcast();
                 songname = x.getSongs();
                 String query = "select filepath from songs where songNmae =?";
                 PreparedStatement creatlist = getConnection().prepareStatement(query);
                 creatlist.setString(1, songname);
                 ResultSet rs = creatlist.executeQuery();
                 while (rs.next()) {
                     filepath = rs.getString(1);
                     songpath.add(new Songs(filepath));
                 }


             } catch (Exception e) {
                 System.out.println(e);
             }
         }
          return songpath;
        }

        public void playPlayListSongs()
        {
            AddAudio addAudio = new AddAudio();

            String filelocation = "";
            List<Songs> filepath = this.listPlay();
            for (Songs x: filepath)
            {
                filelocation = x.getFilepath();
                addAudio.readAudio(filelocation,2);
            }
        }
//-------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Songs> listPod(){
        List<PlayListDetail> podsong = this.playListPLAY();
        String podname = "";
        String songname = "";
        String filepath = "";
        List<Songs> songpath = new ArrayList<>();


        for (PlayListDetail x:podsong) {
            try {
                podname = x.getPodcast();
                songname = x.getSongs();
                String query = "select filepath from songs where songNmae =?";
                PreparedStatement creatlist = getConnection().prepareStatement(query);
                creatlist.setString(1, songname);
                ResultSet rs = creatlist.executeQuery();
                while (rs.next()) {
                    filepath = rs.getString(1);
                    songpath.add(new Songs(filepath));
                }


            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return songpath;
    }

    public void playPlayListPod()
    {
        AddAudio addAudio = new AddAudio();

        String filelocation = "";
        List<Songs> filepath = this.listPlay();
        for (Songs x: filepath)
        {
            filelocation = x.getFilepath();
            addAudio.readAudio(filelocation,2);
        }
    }



    }

