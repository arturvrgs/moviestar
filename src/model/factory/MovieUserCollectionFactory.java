package model.factory;

import model.entity.Movie;
import model.entity.MovieUserCollection;
import model.entity.User;

import java.util.List;

public class MovieUserCollectionFactory {
    public static MovieUserCollection createCollection(
            int id, User user, List<Movie> movies, String description
    ) {
        return new MovieUserCollection(id,user,movies,description);
    }
}
