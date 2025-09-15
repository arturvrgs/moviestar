package model.entity;

public class MovieUserCollection {
    private int id;
    private int user;
    private String[] movies;
    private String description;

    public MovieUserCollection(int id, int user, String[] movies, String description) {
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String[] getMovies() {
        return movies;
    }

    public void setMovies(String[] movies) {
        this.movies = movies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
