package service;

import model.entity.MovieUserCollection;
import repository.MovieUserCollectionRepository;

import java.util.List;

public class MovieUserCollectionService {
    private final MovieUserCollectionRepository movieUserCollectionRepository;

    public MovieUserCollectionService(MovieUserCollectionRepository movieUserCollectionRepository) {
        this.movieUserCollectionRepository = movieUserCollectionRepository;
    }

    public List<MovieUserCollection> getAllCollections() {
        return movieUserCollectionRepository.getData();
    }

    public MovieUserCollection getCollectionById(int id) {

        for(MovieUserCollection collection : getAllCollections()) {
            if(collection.getId() == id) {
                return collection;
            }
        }

        return null;
    }
}
