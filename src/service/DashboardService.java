package service;

import model.entity.MovieUserCollection;
import model.entity.Review;

import java.util.*;

public class DashboardService {
    private MovieService movieService;
    private ReviewService reviewService;
    private MovieUserCollectionService collectionService;

    public DashboardService(MovieService movieService, MovieUserCollectionService collectionService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
        this.collectionService = collectionService;
    }

    // RETORNA O FILME MAIS RECORRENTE EM COLEÇÕES E REVIEWS
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

        return findMostPopular(movieTitles);
    }

    // RETORNA O GENERO MAIS RECORRENTE EM COLEÇÕES E REVIEWS
    public String getMostPopularGender() {

        List<String> genderNames = new ArrayList<>();

        for(Review review : reviewService.getAllReviews()) {
            for(String gender : movieService.getMovieByTitle(review.getMovie()).getGenres()) {
                genderNames.add(gender);
            }
        }

        for(MovieUserCollection collection : collectionService.getAllCollections()) {
            for(String movie : collection.getMovies()) {
               for(String genre : movieService.getMovieByTitle(movie).getGenres()) {
                   genderNames.add(genre);
               }
            }
        }

        return findMostPopular(genderNames);
    }

    // RETORNA A STRING MAIS RECORRENTE DE UMA LISTA
    private String findMostPopular(List<String> list) {
        String mostPopular = null;
        int maxCount = 0;

        for(String i : list) {
            int counter = 0;

            for(String item : list) {
                if(item.equals(i)) {
                    counter++;
                }
            }

            if(counter > maxCount) {
                maxCount = counter;
                mostPopular = i;
            }
        }

        return mostPopular;
    }
}