package model.entity;

import java.util.List;

public class User {

    private int id;
    private String username;
    private List<String>  reviews;

    public User(int id, String username, List<String>  reviews) {
        this.id = id;
        this.username = username;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String>  getReviews() {
        return reviews;
    }

    public void setReviews(List<String>  reviews) {
        this.reviews = reviews;
    }
}
