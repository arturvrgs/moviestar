package controller;

import model.entity.Movie;
import model.entity.Review;
import service.MovieService;
import service.ReviewService;
import service.UserService;
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

        if(id == 0) {
            return;
        } else {
            showReviewById(id);
        }
    }

    public void showReviewById(int id) {
        Review review = reviewService.getReviewById(id);

        int option = Display.showReviewById(scan, review);

        if(option == 0) {
            return;
        }
    }

    public void showReviewForm(String movieTitle) {
        String[] reviewInfo = Display.showReviewForm(scan, movieTitle);
        reviewService.createReview(reviewInfo);
        System.out.println("Review criada com sucesso!");

        showAllReviews();
    }
}
