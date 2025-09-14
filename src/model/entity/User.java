package model.entity;

public class User {

    private int id;
    private String username;
    private Review[] reviews;

    public User(int id, String username, Review[] reviews) {
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

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }
}
