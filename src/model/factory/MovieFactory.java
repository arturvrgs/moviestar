package model.factory;

import model.entity.Movie;

public class MovieFactory {
    public static Movie createMovie(
            int id, String title, String language,
            String director, String[] genres, int totalReviews,
            int stars, int releaseYear, int runtime
    ) {
        return new Movie(id,  title,  language,
                         director,  genres,  totalReviews,
                         stars, releaseYear, runtime);
    }
}
