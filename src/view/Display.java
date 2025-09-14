package view;

import model.entity.Movie;
import model.entity.Review;

import java.util.Arrays;
import java.util.List;

public class Display {

    public static void showAllMovies(List<Movie> movies) {
       for(Movie movie : movies) {
           System.out.println("Título: " + movie.getTitle());
           System.out.println("Gêneros: " + Arrays.toString(movie.getGenres()));
       }
    }

    public static void showAllReviews(List<Review> reviews) {
        for(Review review : reviews) {
            System.out.println("Usuário: " + review.getUser());
            System.out.println("Filme: " + review.getMovie());
            System.out.println("Comentário: " + review.getComment());
            System.out.println("Data de publicação: " + review.getPublishDate());
        }
    }
}
