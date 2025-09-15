package controller;

import model.entity.MovieUserCollection;
import model.entity.Review;
import service.MovieUserCollectionService;
import service.ReviewService;
import view.Display;

import java.util.List;

public class MovieUserCollectionController {
    private final MovieUserCollectionService movieUserCollectionService;

    public MovieUserCollectionController(MovieUserCollectionService movieUserCollectionService) {
        this.movieUserCollectionService = movieUserCollectionService;
    }

    public void showAllCollections() {
        List<MovieUserCollection> collections = movieUserCollectionService.getAllCollections();
        Display.showAllCollections(collections);
    }

    public void showCollectionById(int id) {
        MovieUserCollection collection = movieUserCollectionService.getCollectionById(id);
        Display.showCollectionById(collection);
    }
}
