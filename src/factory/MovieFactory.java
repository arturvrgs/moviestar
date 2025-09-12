package factory;

import entity.Movie;

import java.util.List;

public class MovieFactory {
    public static Movie createMovie(
            int id, String title, String language,
            String director, String genres, int totalReviews,
            int stars, int releaseYear
    ) {
        return new Movie(id,  title,  language,
                         director,  genres,  totalReviews,
                         stars, releaseYear);
    }
}
