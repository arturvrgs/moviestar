package model.entity;

public class User {

    private int id;
    private String username;
    private String[] reviews;

    public User(int id, String username, String[] reviews) {
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

    public String[] getReviews() {
        return reviews;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
}
