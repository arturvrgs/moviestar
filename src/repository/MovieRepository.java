package repository;

import model.entity.Movie;
import model.factory.MovieFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRepository {

    private final File moviesFile;

    public MovieRepository(File moviesFile) {
        this.moviesFile = moviesFile;
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
                        Integer.parseInt(colunas[5]), //TOTAL REVIEWS
                        Integer.parseInt(colunas[6]), //STARS
                        Integer.parseInt(colunas[7]), //RELEASE YEAR
                        Integer.parseInt(colunas[8]) //RUNTIME (IN MINUTES)
                );

                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }
}
