package model.entity;

import java.util.List;

public class Movie {

    private int id;
    private String title;
    private String language;
    private List<String> mainCasting;
    private List<String> genres;
    private int totalReviews, stars, releaseYear;
    private double runtime;

    public Movie(int totalReviews, List<String> genres, List<String> mainCasting, String language, String title, int releaseYear, double runtime) {
        this.totalReviews = totalReviews;
        this.genres = genres;
        this.mainCasting = mainCasting;
        this.language = language;
        this.title = title;
        this.releaseYear = releaseYear;
        this.runtime = runtime;
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

    public List<String> getMainCasting() {
        return mainCasting;
    }

    public void setMainCasting(List<String> mainCasting) {
        this.mainCasting = mainCasting;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
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

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

