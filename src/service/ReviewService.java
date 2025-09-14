package service;

import model.entity.Review;
import repository.ReviewRepository;

import java.util.List;

public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.getData();
    }
}
