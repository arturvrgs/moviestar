import controller.MovieController;
import controller.ReviewController;
import repository.MovieRepository;
import repository.ReviewRepository;
import service.MovieService;
import service.ReviewService;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File MOVIES_FILE = new File("data/movies.txt");
        File REVIEWS_FILE = new File("data/reviews.txt");

        MovieRepository movieRepository = new MovieRepository(MOVIES_FILE);
        MovieService movieService = new MovieService(movieRepository);
        MovieController movieController = new MovieController(movieService);

        ReviewRepository reviewRepository = new ReviewRepository(REVIEWS_FILE);
        ReviewService reviewService = new ReviewService(reviewRepository);
        ReviewController reviewController = new ReviewController(reviewService);


        reviewController.showAllReviews();
    }
}
