package repository;

import model.entity.Movie;
import model.entity.Review;
import model.entity.User;
import model.factory.MovieFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRepository {

    private final File moviesFile;
    private final List<Movie> movies = new ArrayList<>();
    private ReviewRepository reviewRepository;

    public MovieRepository(File moviesFile) {
        this.moviesFile = moviesFile;
        getData();
    }

    public List<Movie> getData() {

        List<Movie> movies = new ArrayList<>();

        try (Scanner scanner = new Scanner(moviesFile)) {

            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                String[] genres = colunas[4].split(",");

                Movie movie = MovieFactory.createMovie(
                        Integer.parseInt(colunas[0]), //ID
                        colunas[1], //TITLE
                        colunas[2], //LANGUAGE
                        colunas[3], //DIRECTOR
                        genres, //GENRES
                        Integer.parseInt(colunas[5]), //RELEASE YEAR
                        Integer.parseInt(colunas[6]) //RUNTIME (IN MINUTES)
                );

                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
