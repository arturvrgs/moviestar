package service;

import model.entity.Review;
import model.entity.User;
import model.factory.ReviewFactory;
import repository.ReviewRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    public void createReview(String[] reviewInfo) {

        int id = reviewRepository.getReviews().getLast().getId() + 1;
        User user = userRepository.getUsers().getLast();
        String movieTitle = reviewInfo[0];
        int stars = Integer.parseInt(reviewInfo[1]);
        String comment = reviewInfo[2];
        String publishDate = LocalDate.now().toString();

        Review review = ReviewFactory.createReview(id, user, movieTitle, stars, comment, publishDate);

        reviewRepository.save(review);
        userRepository.saveUserReview(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.getReviews();
    }

    public Review getReviewById(int id) {
        for(Review review : getAllReviews()) {
            if(review.getId() == id) {
                return review;
            }
        }
        return null;
    }

}
