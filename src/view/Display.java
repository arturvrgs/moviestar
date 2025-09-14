package view;

import model.entity.Movie;
import java.util.Arrays;
import java.util.List;

public class Display {
    public static void showAllMovies(List<Movie> movies) {
       for(Movie movie : movies) {
           System.out.println("Título: " + movie.getTitle());
           System.out.println("Gêneros: " + Arrays.toString(movie.getGenres()));
       }
    }
}
