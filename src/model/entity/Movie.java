package model.entity;

import java.sql.SQLOutput;

public class Movie {

    private int id;
    private String title;
    private String language;
    private String director;
    private String[] genres;
    private int totalReviews, stars, releaseYear;
    private int runtime;

    public Movie(
                int id, String title, String language,
                String director, String[] genres, int totalReviews,
                int stars, int releaseYear, int runtime
    ) {
        this.runtime = runtime;
        this.releaseYear = releaseYear;
        this.totalReviews = totalReviews;
        this.genres = genres;
        this.director = director;
        this.title = title;
        this.language = language;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}

