package service;

import model.entity.Movie;
import model.entity.Review;
import repository.MovieRepository;
import repository.ReviewRepository;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getMovies();
    }

    public Movie getMovieById(int id) {
        for(Movie movie : getAllMovies()) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
}
