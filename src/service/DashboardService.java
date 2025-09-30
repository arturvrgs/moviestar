package service;

import model.entity.MovieUserCollection;
import model.entity.Review;

import java.util.*;

public class DashboardService {
    private MovieService movieService;
    private UserService userService;
    private ReviewService reviewService;
    private MovieUserCollectionService collectionService;

    public DashboardService(MovieService movieService, UserService userService, ReviewService reviewService, MovieUserCollectionService collectionService) {
        this.movieService = movieService;
        this.userService = userService;
        this.reviewService = reviewService;
        this.collectionService = collectionService;
    }

    //ve todas reviews e todas coleções, ver qual filme mais aparece em cada
    public String getMostPopularMovie() {

        List<String> movieTitles = new ArrayList<>();

        for(Review review : reviewService.getAllReviews()) {
            movieTitles.add(review.getMovie());
        }

        for(MovieUserCollection collection : collectionService.getAllCollections()) {
            for(String movie : collection.getMovies()) {
                movieTitles.add(movie);
            }
        }

        //ver qual filme mais se repete
        String mostPopularMovie = null;
        int maxCount = 0;

        for(String movie : movieTitles) {
            int counter = 0;

            for(String item : movieTitles) {
                if(item.equals(movie)) {
                    counter++;
                }
            }

            if(counter > maxCount) {
                maxCount = counter;
                mostPopularMovie = movie;
            }
        }

        return mostPopularMovie;
    }
}