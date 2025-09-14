package model.entity;
import java.time.LocalDate;
import java.util.Date;

public class Review {

    private int id;
    private int user;
    private Movie movie;
    private int stars;
    private String comment;
    private String publishDate;

    public Review(int id, int user, Movie movie, int stars, String comment, String publishDate) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.stars = stars;
        this.comment = comment;
        this.publishDate = publishDate;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
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
