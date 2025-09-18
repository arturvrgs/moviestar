package controller;

import model.entity.Movie;
import service.MovieService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class MovieController {

    private final MovieService movieService;
    private final ReviewController reviewController;

    Scanner scan = new Scanner(System.in);

    public MovieController(MovieService movieService, ReviewController reviewController) {
        this.movieService = movieService;
        this.reviewController = reviewController;
    }

    public void showAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        int id = Display.showAllMovies(scan, movies);

        showMovieById(id);
    }

    public void showMovieById(int id) {
        Movie movie = movieService.getMovieById(id);
        int option = Display.showMovieById(scan, movie);

        if(option == 1) {
            reviewController.showReviewForm(movie.getTitle());
        }
    }
}
