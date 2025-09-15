package repository;

import model.entity.MovieUserCollection;
import model.factory.MovieUserCollectionFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieUserCollectionRepository {
    private final File movieUserCollectionsFile;

    public MovieUserCollectionRepository(File movieUserCollectionsFile) {
        this.movieUserCollectionsFile = movieUserCollectionsFile;
    }

    public List<MovieUserCollection> getData() {

        List<MovieUserCollection> collections = new ArrayList<>();

        try (Scanner scanner = new Scanner(movieUserCollectionsFile)) {

            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                String[] movies = colunas[2].split(",");

                MovieUserCollection collection = MovieUserCollectionFactory.createCollection(
                        Integer.parseInt(colunas[0]), //ID
                        Integer.parseInt(colunas[1]), //USER
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
}
