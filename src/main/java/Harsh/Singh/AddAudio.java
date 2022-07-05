package Harsh.Singh;
import Model.PodCast;
import Model.Songs;

import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Statement;
import java.util.Scanner;

import static Harsh.Singh.Connection.getConnection;

public class AddAudio {
   {    Main main = new Main();
      /*  new Main().readAudio("F:\\Java course\\MyJunkBox\\src\\main\\resources\\songs\\Alive.wav",2);
       new Main().readAudio("F:\\Java course\\MyJunkBox\\src\\main\\resources\\songs\\Animals (Original Mix).wav",2);
       new Main().readAudio("F:\\Java course\\MyJunkBox\\src\\main\\resources\\songs\\Get Low.wav",2);*/
   }


    public void readAudio(String audioSrcFile, int count){
        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count - 1;
        try {

            playAudio.playAudio1(audioSrcFile, count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("---------------------------------------------------- Playing Track ---------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                System.out.println( " 1. pause  \n 2. Resume  \n 3. Restart  \n 4. Next  \n 5. Stop" );
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                if (c == 4) {
                    break;
                }
                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                    case 5:
                        playAudio.pause();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
    public void musicInsert(int userId)
    {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Song Name");
        String songname = scanner.next();
            Songs songs = new Songs();
            songs.setSongName(songname);

//        System.out.println("user Id");
//        int userId = scanner.nextInt();
        System.out.println("Genre");
        String genre = scanner.next();
        songs.setGenre(genre);
        System.out.println("Duration");
        String duration = scanner.next();
        songs.setDuration(duration);
        System.out.println("Enter file Path URL");
        String filepath = scanner.next();
        songs.setFilepath(filepath);
        String query = " insert into songs values (" + userId + ",'" + songs.getSongName() + "','" + songs.getGenre() + "','" + songs.getDuration() + "','" + songs.getFilepath() + "')";
        Statement st = getConnection().createStatement();
        int rows = st.executeUpdate(query);
        System.out.println(" Song Inserted ");
    }catch (Exception e)
    {
        System.out.println(e);
    }
    }
    public void PodCast(int userId)
    {
        try{
            Scanner scanner = new Scanner(System.in);
            PodCast podCast = new PodCast();
            System.out.println("Enter PodCast");
            String podname = scanner.next();
            podCast.setPodCastName(podname);
//            System.out.println("user Id");
//            int userId = scanner.nextInt();
            System.out.println("Genre");
            String genre = scanner.next();
            podCast.setGenre(genre);
            System.out.println("Episode");
            String episode = scanner.next();
            podCast.setEpisode(episode);
            System.out.println("Enter file Path URL");
            String filepath = scanner.next();
            podCast.setFilepath(filepath);
            String query = " insert into podcast values (" + userId + ",'" + podCast.getPodCastName() + "','" + podCast.getGenre() + "','" + podCast.getEpisode() + "','" + podCast.getFilepath() + "')";
            Statement st = getConnection().createStatement();
            int rows = st.executeUpdate(query);
            System.out.println(" Song Inserted ");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    }



