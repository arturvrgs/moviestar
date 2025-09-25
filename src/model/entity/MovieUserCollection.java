package model.entity;

import java.util.List;

public class MovieUserCollection {
    private int id;
    private User user;
    private List<String> movies;
    private String description;

    public MovieUserCollection(int id, User user, List<String> movies, String description) {
        this.id = id;
        this.user = user;
        this.movies = movies;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
