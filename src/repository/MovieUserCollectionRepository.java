package repository;

import model.entity.Movie;
import model.entity.MovieUserCollection;
import model.entity.User;
import model.factory.MovieUserCollectionFactory;
import service.MovieService;
import service.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieUserCollectionRepository {
    private final File movieUserCollectionsFile;
    private final UserService userService;
    private final MovieService movieService;
    private final List<MovieUserCollection> collections = new ArrayList<>();

    public MovieUserCollectionRepository(File movieUserCollectionsFile, UserService userService, MovieService movieService) {
        this.movieUserCollectionsFile = movieUserCollectionsFile;
        this.userService = userService;
        this.movieService = movieService;
        getData();
    }

    public List<MovieUserCollection> getData() {

        List<MovieUserCollection> collections = new ArrayList<>();

        try (Scanner scanner = new Scanner(movieUserCollectionsFile)) {

            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                String[] moviesIDS = colunas[2].split(",");

                List<Movie> movies = new ArrayList<>();

                for(String movieID : moviesIDS) {
                   movies.add(movieService.getMovieById(Integer.parseInt(movieID)));
                }

                MovieUserCollection collection = MovieUserCollectionFactory.createCollection(
                        Integer.parseInt(colunas[0]), //ID
                        userService.getUserById(Integer.parseInt(colunas[1])), //USER
                        movies, //MOVIES
                        colunas[3] //DESCRIPTION
                );

                collections.add(collection);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return collections;
    }

    public List<MovieUserCollection> getCollections() {
        return collections;
    }
}
