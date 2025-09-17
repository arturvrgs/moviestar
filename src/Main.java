import controller.MovieController;
import controller.MovieUserCollectionController;
import controller.ReviewController;
import controller.UserController;
import repository.MovieRepository;
import repository.MovieUserCollectionRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import service.MovieService;
import service.MovieUserCollectionService;
import service.ReviewService;
import service.UserService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File MOVIES_FILE = new File("data/movies.txt");
        File REVIEWS_FILE = new File("data/reviews.txt");
        File USERS_FILE = new File("data/users.txt");
        File MOVIE_USER_COLLECTIONS = new File("data/movie_user_collections.txt");

        MovieRepository movieRepository = new MovieRepository(MOVIES_FILE);
        MovieService movieService = new MovieService(movieRepository);
        MovieController movieController = new MovieController(movieService);

        UserRepository userRepository = new UserRepository(USERS_FILE);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        ReviewRepository reviewRepository = new ReviewRepository(REVIEWS_FILE, userService, movieService);
        ReviewService reviewService = new ReviewService(reviewRepository);
        ReviewController reviewController = new ReviewController(reviewService);

        MovieUserCollectionRepository movieUserCollectionRepository = new MovieUserCollectionRepository(MOVIE_USER_COLLECTIONS,userService, movieService);
        MovieUserCollectionService movieUserCollectionService = new MovieUserCollectionService(movieUserCollectionRepository);
        MovieUserCollectionController movieUserCollectionController = new MovieUserCollectionController(movieUserCollectionService);

        userController.registerUser();
        userController.menuOption(movieController, reviewController, userController, movieUserCollectionController);
    }
}
