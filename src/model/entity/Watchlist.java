package model.entity;

import java.util.List;

public class Watchlist {

    private int id;
    private User user;
    private List<Movie> watchlist;
    private String description;

    public Watchlist(User user, List<Movie> watchlist, String description) {
        this.user = user;
        this.watchlist = watchlist;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(List<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
