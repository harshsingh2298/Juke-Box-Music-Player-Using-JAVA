package Model;

public class PlayListDetail
{
    private int playListDetailId;
    private String songs;
    private String podcast;

    public PlayListDetail() {}
 public PlayListDetail(String songs , String podcast){this.podcast=podcast;this.songs=songs;}
    public PlayListDetail(int playListDetailId, String songs, String podcast) {
        this.playListDetailId = playListDetailId;
        this.songs = songs;
        this.podcast = podcast;
    }

    public int getPlayListDetailId() {
        return playListDetailId;
    }

    public void setPlayListDetailId(int playListDetailId) {
        this.playListDetailId = playListDetailId;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public String getPodcast() {
        return podcast;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

    @Override
    public String toString() {
        return "PlayListDetail{" +
                "playListDetailId=" + playListDetailId +
                ", songs=" + songs +
                ", podcast=" + podcast +
                '}';
    }
}
