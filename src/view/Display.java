package view;

import model.entity.Movie;
import model.entity.Review;
import model.entity.User;

import java.util.Arrays;
import java.util.List;

public class Display {

    public static void showMovieById(Movie movie) {
        System.out.println("Filme: " + movie.getTitle());
    }

    public static void showReviewById(Review review) {
        System.out.println("Review: " + review.getId());
    }

    public static void showUserById(User user) {
        System.out.println("User: " + user.getUsername());
    }

    public static void showAllMovies(List<Movie> movies) {
        for(Movie movie : movies) {
            System.out.println("Título: " + movie.getTitle());
            System.out.println("Gêneros: " + Arrays.toString(movie.getGenres()));
        }
    }

    public static void showAllReviews(List<Review> reviews) {
        for(Review review : reviews) {
            showReviewById(review);
            System.out.println("--------------------------------------------------");
            System.out.println("Usuário: " + review.getUser());
            showMovieById(review.getMovie());
            System.out.println("Comentário: " + review.getComment());
            System.out.println("Data de publicação: " + review.getPublishDate());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showAllUsers(List<User> users) {
        for(User user : users) {
            System.out.println("Username: " + user.getUsername());

            for(Review review : user.getReviews()) {
                System.out.println(review.getComment());
            }
        }
    }
}
