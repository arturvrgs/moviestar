package controller;

import model.entity.Movie;
import model.entity.Review;
import service.ReviewService;
import view.Display;

import java.util.List;

public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public void showAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        Display.showAllReviews(reviews);
    }

    public void showReviewById(int id) {
        Review review = reviewService.getReviewById(id);
        Display.showReviewById(review);
    }
}
