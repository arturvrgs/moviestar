package service;

import model.entity.Movie;
import repository.MovieRepository;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    // RETORNA TODOS FILMES
    public List<Movie> getAllMovies() {
        return movieRepository.getMovies();
    }


    // RETORNA FILME PELO ID
    public Movie getMovieById(int id) {
        for(Movie movie : getAllMovies()) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }


    // RETORNA FILME PELO TITULO
    public Movie getMovieByTitle(String title) {
        for(Movie movie : getAllMovies()) {
            if(movie.getTitle() == title) {
                return movie;
            }
        }
        return null;
    }
}
