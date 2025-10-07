package service;

import model.entity.MovieUserCollection;
import model.entity.User;
import model.factory.MovieUserCollectionFactory;
import repository.MovieUserCollectionRepository;
import repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class MovieUserCollectionService {
    private final MovieUserCollectionRepository movieUserCollectionRepository;
    private final UserRepository userRepository;
    private final MovieService movieService;

    public MovieUserCollectionService(MovieUserCollectionRepository movieUserCollectionRepository, UserRepository userRepository, MovieService movieService) {
        this.movieUserCollectionRepository = movieUserCollectionRepository;
        this.userRepository = userRepository;
        this.movieService = movieService;
    }

    // CRIA NOVA COLEÇÃO
    public void createCollection(String[] collectionInfo) {

        int id = movieUserCollectionRepository.getCollections().getLast().getId() + 1;
        User user = userRepository.getUsers().getLast();

        String description = collectionInfo[0];

        String movieIDS = collectionInfo[1]
                .replace("[", "")
                .replace("]", "");

        String[] moviesIDSArray = movieIDS.split(",");

        List<String> moviesTitle = new ArrayList<>();

        for (int i = 0; i < moviesIDSArray.length; i++) {
            moviesTitle.add(movieService.getMovieById(Integer.parseInt(moviesIDSArray[i].trim())).getTitle());
        }

        MovieUserCollection collection = MovieUserCollectionFactory.createCollection(id, user, moviesTitle, description);
        movieUserCollectionRepository.save(collection);
    }

    // RETORNA TODAS COLEÇÕES
    public List<MovieUserCollection> getAllCollections() {
        return movieUserCollectionRepository.getCollections();
    }

    // RETORNA COLEÇÃO PELO ID
    public MovieUserCollection getCollectionById(int id) {

        for(MovieUserCollection collection : getAllCollections()) {
            if(collection.getId() == id) {
                return collection;
            }
        }

        return null;
    }
}
