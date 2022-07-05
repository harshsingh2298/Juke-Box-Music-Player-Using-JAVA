package Model;

import Model.User;

public class Songs
{
    private String songName;
    private String genre;
    private String duration;
    private User user;
    private String filepath;

    public Songs() {}

    public Songs(String filepath) {
        this.filepath = filepath;
    }

    public Songs(String songName, String genre, String duration, User user, String filepath) {
        this.songName = songName;
        this.genre = genre;
        this.duration = duration;
        this.user = user;
        this.filepath=filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songName='" + songName + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", user=" + user +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
