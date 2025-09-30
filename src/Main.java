import controller.*;
import repository.MovieRepository;
import repository.MovieUserCollectionRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import service.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File MOVIES_FILE = new File("data/movies.txt");
        File REVIEWS_FILE = new File("data/reviews.txt");
        File USERS_FILE = new File("data/users.txt");
        File MOVIE_USER_COLLECTIONS = new File("data/movie_user_collections.txt");

        MovieRepository movieRepository = new MovieRepository(MOVIES_FILE);
        MovieService movieService = new MovieService(movieRepository);

        UserRepository userRepository = new UserRepository(USERS_FILE, movieService);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        ReviewRepository reviewRepository = new ReviewRepository(REVIEWS_FILE, userService, movieService);
        ReviewService reviewService = new ReviewService(reviewRepository, userRepository);

        ReviewController reviewController = new ReviewController(reviewService);
        MovieController movieController = new MovieController(movieService, reviewController, userController);

        MovieUserCollectionRepository movieUserCollectionRepository = new MovieUserCollectionRepository(MOVIE_USER_COLLECTIONS,userService, movieService);
        MovieUserCollectionService movieUserCollectionService = new MovieUserCollectionService(movieUserCollectionRepository, userRepository, movieService);
        MovieUserCollectionController movieUserCollectionController = new MovieUserCollectionController(movieUserCollectionService, movieService);

        DashboardService dashboardService = new DashboardService(movieService, userService, reviewService, movieUserCollectionService);
        DashboardController dashboardController = new DashboardController(dashboardService);

        userController.registerUser();

        while(true)
            userController.menuOption(movieController, reviewController, userController, movieUserCollectionController, dashboardController);
    }
}
