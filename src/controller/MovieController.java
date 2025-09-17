package controller;

import model.entity.Movie;
import service.MovieService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class MovieController {

    private final MovieService movieService;

    Scanner scan = new Scanner(System.in);

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void showAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        int id = Display.showAllMovies(scan, movies);

        showMovieById(id);
    }

    public void showMovieById(int id) {
        Movie movie = movieService.getMovieById(id);
        Display.showMovieById(movie);
    }
}
