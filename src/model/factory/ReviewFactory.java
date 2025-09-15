package model.factory;

import model.entity.Review;

public class ReviewFactory {
    public static Review createReview(
            int id, int user, int movie, int stars, String comment, String publishDate
    ) {
        return new Review(id, user, movie, stars, comment, publishDate);
    }
}
