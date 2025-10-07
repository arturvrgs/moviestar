package model.factory;

import model.entity.Review;
import model.entity.User;

//CLASSE CRIADORA DE OBJETO REVIEW
public class ReviewFactory {
    public static Review createReview(
            int id, User user, String movie, int stars, String comment, String publishDate
    ) {
        return new Review(id, user, movie, stars, comment, publishDate);
    }
}
