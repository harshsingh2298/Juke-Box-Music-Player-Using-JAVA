package Model;

import Model.User;

public class PodCast
{
    private String podCastName;
    private String genre;
    private String episode;
    private String duration;
    private User user;
    private String filepath;

    public PodCast() {}

    public PodCast(String podCastName, String genre, String episode, String duration, User user, String filepath) {
        this.podCastName = podCastName;
        this.genre = genre;
        this.episode = episode;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPodCastName() {
        return podCastName;
    }

    public void setPodCastName(String podCastName) {
        this.podCastName = podCastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PodCast{" +
                "podCastName='" + podCastName + '\'' +
                ", genre='" + genre + '\'' +
                ", episode='" + episode + '\'' +
                ", duration=" + duration +
                ", user=" + user +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
