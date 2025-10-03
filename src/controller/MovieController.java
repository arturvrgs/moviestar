package controller;

import model.entity.Movie;
import service.MovieService;
import service.UserService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class MovieController {

    private final MovieService movieService;
    private final ReviewController reviewController;
    private final UserController userController;

    Scanner scan = new Scanner(System.in);

    public MovieController(MovieService movieService, ReviewController reviewController, UserController userController) {
        this.movieService = movieService;
        this.reviewController = reviewController;
        this.userController = userController;
    }

    public void showAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        int id;

        while (true) {
            id = Display.showAllMovies(scan, movies);

            if(id < 0 || id > movies.size()) {
                System.out.println("Opção Inválida.");
                continue;
            }

            if(id == 0) {
                return;
            } else {
                showMovieById(id);
            }
        }
    }

    public void showMovieById(int id) {
        Movie movie = movieService.getMovieById(id);
        int option = Display.showMovieById(scan, movie);

        if(option == 0) {
            showAllMovies();
        }

        if(option == 1) {
            reviewController.showReviewForm(movie.getTitle());
        }
    }
}
