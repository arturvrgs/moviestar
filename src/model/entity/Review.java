package model.entity;

public class Review {

    private int id;
    private User user;
    private Movie movie;
    private int stars;
    private String comment;
    private String publishDate;

    public Review(int id, User user, Movie movie, int stars, String comment, String publishDate) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.stars = stars;
        this.comment = comment;
        this.publishDate = publishDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
