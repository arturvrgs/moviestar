package controller;

import model.entity.MovieUserCollection;
import model.entity.Review;
import service.MovieUserCollectionService;
import service.ReviewService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class MovieUserCollectionController {
    private final MovieUserCollectionService movieUserCollectionService;
    Scanner scan = new Scanner(System.in);

    public MovieUserCollectionController(MovieUserCollectionService movieUserCollectionService) {
        this.movieUserCollectionService = movieUserCollectionService;
    }

    public void showAllCollections() {
        List<MovieUserCollection> collections = movieUserCollectionService.getAllCollections();

        int id = Display.showAllCollections(scan, collections);

        if(id == 0) {
            return;
        } else {
            showCollectionById(id);
        }
    }

    public void showCollectionById(int id) {
        MovieUserCollection collection = movieUserCollectionService.getCollectionById(id);
        Display.showCollectionById(scan, collection);
    }
}
