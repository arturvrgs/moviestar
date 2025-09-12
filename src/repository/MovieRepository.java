package repository;

import entity.Movie;
import factory.MovieFactory;
import factory.UserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRepository {

    private final File moviesFile;
    private List<Movie> movies;

    public MovieRepository(File moviesFile) {
        this.moviesFile = moviesFile;
        this.movies = new ArrayList<>();
    }

    public List<Movie> getMovies() {

        try (Scanner scanner = new Scanner(moviesFile)) {

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                Movie movie = MovieFactory.createMovie(
                        Integer.parseInt(colunas[0]),
                        colunas[1],
                        colunas[2],
                        colunas[3],
                        colunas[4],
                        Integer.parseInt(colunas[5]),
                        Integer.parseInt(colunas[6]),
                        Integer.parseInt(colunas[7])
                );
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    public void showAll() {
        for (Movie movie : getMovies()) {
            System.out.println("Título: " + movie.getTitle());
            System.out.println("Diretor: " + movie.getDirector());
            System.out.println("Generos: " + movie.getGenres());
            System.out.println("Ano de Lançamento: " + movie.getReleaseYear());
        }
    }
}
