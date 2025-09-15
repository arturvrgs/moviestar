package model.factory;

import model.entity.MovieUserCollection;

public class MovieUserCollectionFactory {
    public static MovieUserCollection createCollection(
            int id, int user, String[] movies, String description
    ) {
        return new MovieUserCollection(id,user,movies,description);
    }
}
