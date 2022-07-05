package DAOclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class DAOPlayLists {
    Scanner sc = new Scanner(System.in);

    public void createPlayList(int pass) {
        try {
            getConnection();
            System.out.println(" Enter PlayList Name ");
            String playListName = sc.next();
            String query = " Insert into playList values ('" + playListName + "','" + pass + "')";
            Statement st = getConnection().createStatement();
            int rows = st.executeUpdate(query);
            System.out.println(" PlayList Created ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void deletePlayList(int pass, String playListName) {
        try {
            getConnection();
            String query = " Delete from playList where  playListName = ?";
            PreparedStatement creatlist = getConnection().prepareStatement(query);
            creatlist.setString(1, playListName);
            int rows = creatlist.executeUpdate();
            System.out.println(" PlayList Deleted ");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void showPlaylist() {
        try {
            getConnection();
            String query = "Select * from playList";
            Statement st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while (rs1.next())
            {
                 System.out.println(rs1.getString("playlistName") + "\t" + rs1.getString(2));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
