import controller.MovieController;
import controller.ReviewController;
import repository.MovieRepository;
import repository.ReviewRepository;
import service.MovieService;
import service.ReviewService;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        MovieRepository movieRepository = new MovieRepository(new File("data/movies.txt"));
        MovieService movieService = new MovieService(movieRepository);
        MovieController movieController = new MovieController(movieService);

        ReviewRepository reviewRepository = new ReviewRepository(new File("data/reviews.txt"));
        ReviewService reviewService = new ReviewService(reviewRepository);
        ReviewController reviewController = new ReviewController(reviewService);


        reviewController.showAllReviews();
    }
}
