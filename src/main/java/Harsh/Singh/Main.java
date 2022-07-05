package Harsh.Singh;
import DAOclasses.DAOPlayListDetail;
import DAOclasses.DAOPlayLists;
import DAOclasses.DAOPod;
import DAOclasses.DAOSongs;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner sc = new Scanner(System.in);
        CreateNew create = new CreateNew();
        DAOPlayLists daoPlayLists = new DAOPlayLists();
        AddAudio add = new AddAudio();
        DAOPlayListDetail daoPlayListDetail = new DAOPlayListDetail();
        System.out.println("*****************************************************************************************************************************");
        System.out.println("------------------------------------------------------ WELCOME TO MY JUKE BOX -----------------------------------------------");


        while (true) {
            System.out.println(" Select Your Choice   \n 1. New User \n 2. Existing User ");
            int choice = sc.nextInt();
            if (choice == 1) {
                create.createNewUser();
                create.insert();
            }
//*************************************************************************************************************************************************************************************

            if (choice == 2) {
                System.out.println(" Please Enter Your User Id ");
                int userId = sc.nextInt();
                System.out.println(" Enter your Password ");
                String pass = sc.next();
                create.existingUser(userId, pass);
                //System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                System.out.println("-------------------------------------- PLAYING PLAYLIST SONGS -----------------------------------------");
                System.out.println();
                DAOPlayListDetail daoPlayListDetail1 = new DAOPlayListDetail();
                daoPlayListDetail1.playPlayListSongs();
                System.out.println();

                while (true) {
                    System.out.println(" 1. Play Music  \n 2. Play PodCast  \n 3. Songs And PodCast  \n 4. PlayLIst And PlayListDetail \n 5. Exit ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    int a = sc.nextInt();
                    PlayerAudio playerAudio = new PlayerAudio();
                    if (a == 1) {
                        playerAudio.playSongs();
                    }
                    if (a == 2) {
                        playerAudio.playPodCast();
                    }
                    if (a == 3) {
                        System.out.println(" 1. Add Songs To Juke Box  \n 2. Add PodCast To Juke Box   \n 3. Search Songs  \n 4. Search PodCast  \n 5. Delete Song  \n 6. Delete PodCast \n 7. Short Songs  \n 8. Short PodCast  \n 9. Exit");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        int b = sc.nextInt();
                        AddAudio ad = new AddAudio();
                        if (b == 1) {
                            ad.musicInsert(userId);
                        }
                        if (b == 2) {
                            ad.PodCast(userId);
                        }
                        if (b == 3) {
                            DAOSongs daoSongs = new DAOSongs();
                            daoSongs.searchSong();

                        }
                        if (b == 4) {
                            DAOPod daoPod = new DAOPod();
                            daoPod.searchAllPod();
                        }
                        if (b == 5) {
                            playerAudio.deleteSong();
                        }
                        if (b == 6) {
                            DAOPod daoPod = new DAOPod();
                            daoPod.deletePodCast();
                        }
                        if (b == 7) {
                            DAOSongs daoSongs = new DAOSongs();
                            daoSongs.shotSong();
                        }
                        if (b == 8) {
                            DAOPod daoPod = new DAOPod();
                            daoPod.shortPod();
                        }
                        if (b == 9) {
                            return;
                        }
                    }
                    if (a == 4) {
                        System.out.println(" 1. Create PlayList  \n 2. Delete PlayList  \n 3. Display Songs \n 4. Add Songs and PodCast In PlayList  \n 5. Show Play Lists Details  \n 6. Delete PlayList Detail \n 7. Display PodCast \n 8. Display Playlist \n 9. Exit");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        int c = sc.nextInt();
                        if (c == 1) {
                            daoPlayLists.createPlayList(userId);
                             return;
                        }
                        if (c == 2) {
                            System.out.println(" Enter PlayList Name ");
                            String playListName = sc.next();
                            daoPlayLists.deletePlayList(userId, playListName);
                            return;
                        }
                        if (c == 3) {

                            DAOSongs daoSongs = new DAOSongs();
                            daoSongs.displayAllSong();
                            return;
                        }
                        if (c == 4) {
                            daoPlayListDetail.addSongsPlaylist();
                            return;
                        }
                        if (c == 5) {
                            daoPlayListDetail.displayPlaylistDetails();
                            return;
                        }
                        if (c == 6) {
                            daoPlayListDetail.deletePlayList();
                            return;
                        }
                        if (c == 7)
                        {
                            DAOPod daoPod = new DAOPod();
                            daoPod.displayPodcast();
                        }
                        if (c==8)
                        {
                            daoPlayLists.showPlaylist();
                        }
                        if (a==7)
                            return;
                    }

                }
            }
        }

    }
    public void readAudio(String s, int i) {}
}

