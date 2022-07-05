package Model;

import Model.User;

public class PlayList
{
   private User user;
   private  String playListName;

    public PlayList() {}

    public PlayList(User user, String playListName) {
        this.user = user;
        this.playListName = playListName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "user=" + user +
                ", playListName='" + playListName + '\'' +
                '}';
    }
}
