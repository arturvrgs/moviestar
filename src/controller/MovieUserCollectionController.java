package controller;

import model.entity.MovieUserCollection;
import model.entity.Review;
import service.MovieService;
import service.MovieUserCollectionService;
import service.ReviewService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class MovieUserCollectionController {
    private final MovieUserCollectionService movieUserCollectionService;
    private final MovieService movieService;

    Scanner scan = new Scanner(System.in);

    public MovieUserCollectionController(MovieUserCollectionService movieUserCollectionService, MovieService movieService) {
        this.movieUserCollectionService = movieUserCollectionService;
        this.movieService = movieService;
    }

    public void showAllCollections() {
        List<MovieUserCollection> collections = movieUserCollectionService.getAllCollections();

        int id = Display.showAllCollections(scan, collections);

        if(id == 0) {
            showCollectionForm();
        } else {
            showCollectionById(id);
        }
    }

    public void showCollectionById(int id) {
        MovieUserCollection collection = movieUserCollectionService.getCollectionById(id);
        Display.showCollectionById(scan, collection);
    }

    public void showCollectionForm() {
        String[] collectionInfo = Display.showCollectionForm(scan, movieService.getAllMovies());
        movieUserCollectionService.createCollection(collectionInfo);
        System.out.println("Coleção criada com sucesso!");
    }
}
