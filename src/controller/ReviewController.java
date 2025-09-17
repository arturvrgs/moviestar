package controller;

import model.entity.Review;
import service.ReviewService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class ReviewController {
    private final ReviewService reviewService;

    Scanner scan = new Scanner(System.in);

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public void showAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        int id =  Display.showAllReviews(scan, reviews);
        showReviewById(id);
    }

    public void showReviewById(int id) {
        Review review = reviewService.getReviewById(id);
        Display.showReviewById(review);
    }
}
