import DAOclasses.*;
import Harsh.Singh.*;
import DAOclasses.DAOSongs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Junit {

    DAOSongs obj=null;
    @BeforeEach
    public void setUp() throws SQLException {
        obj =new DAOSongs();
    }
    @AfterEach
    public void tearDown()
    {
        obj=null;
    }
    @Test
    public void displayAllSongTest() throws SQLException {
      //  assertEquals(2,obj.displayAllSong().size());
    }
    @Test
    public void displayAllSongTest1() throws SQLException {
      //  assertEquals("sid1",obj.displayAllSong().get(0).getSongId());
    }

    CreateNew obj1=null;

    @BeforeEach
    public void setUp1() throws SQLException {
        obj1 =new CreateNew();
    }
    @AfterEach
    public void tearDown1()
    {
        obj1=null;
    }

    @Test
    public void loginUserTest() throws SQLException {
       // assertEquals(false,obj1.existingUser("Sonu113","pass@!23"));
    }
    @Test
    public void loginUserTest1() throws SQLException {
       // assertEquals(false,obj1.existingUser("21112","123"));
    }
    @Test
    public void sortSongTest() throws SQLException {
       // assertEquals("Maiya",obj.shotSong().get(0).getSongName());
    }

    @Test
    public void sortSongTest1() throws SQLException {
       // assertEquals("song112",obj.shotSong("genre").get(1).getSongId());
    }




}
