package controller;

import model.entity.Movie;
import service.MovieService;
import view.Display;

import java.util.List;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void showAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        Display.showAllMovies(movies);
    }
}
