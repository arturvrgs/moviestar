import entity.Movie;
import entity.User;
import repository.MovieRepository;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository(new File("src/data/movies.txt"));
       //listagem filmes

        movieRepository.showAll();
    }
}
