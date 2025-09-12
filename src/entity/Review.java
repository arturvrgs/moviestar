package entity;

import java.util.Date;

public class Review {

    private int id;
    private User user;
    private Movie movie;
    private int stars;
    private String comment;
    private Date publishDate;

    public Review(User user, Movie movie, int stars, String comment, Date publishDate) {
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
