package model.factory;

import model.entity.Movie;
import model.entity.Review;

public class ReviewFactory {
    public static Review createReview(
            int id, int user, Movie movie, int stars, String comment, String publishDate
    ) {
        return new Review(id, user, movie, stars, comment, publishDate);
    }
}
