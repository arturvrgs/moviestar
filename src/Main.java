import controller.MovieController;
import repository.MovieRepository;
import service.MovieService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository(new File("data/movies.txt"));
        MovieService movieService = new MovieService(movieRepository);
        MovieController movieController = new MovieController(movieService);

        movieController.showAllMovies();
    }
}
