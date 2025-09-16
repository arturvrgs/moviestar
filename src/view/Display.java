package view;

import model.entity.Movie;
import model.entity.MovieUserCollection;
import model.entity.Review;
import model.entity.User;
import service.UserService;

import java.util.Arrays;
import java.util.List;

public class Display {

    public static void showMovieById(Movie movie) {
        System.out.println("FILME: " + movie.getTitle());
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + movie.getId());
        System.out.println("LINGUAGEM: " + movie.getLanguage());
        System.out.println("DIRETOR: " + movie.getDirector());
        System.out.println("GÊNEROS: " + Arrays.toString(movie.getGenres()));
        System.out.println("QUANTIDADE DE REVIEWS: " + movie.getTotalReviews());
        System.out.println("MÉDIA DE ESTRELAS: " + movie.getStars());
        System.out.println("ANO DE LANÇAMENTO: " + movie.getReleaseYear());
        System.out.println("TEMPO DE DURAÇÃO " + movie.getRuntime() + "m");
        System.out.println("--------------------------------------------------");
    }

    public static void showCollectionById(MovieUserCollection collection) {
        System.out.println("COLEÇÃO: " + collection.getDescription());
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + collection.getId());
        System.out.println("USUÁRIO: " + collection.getUser());
        System.out.println("FILMES: " + Arrays.toString(collection.getMovies()));
        System.out.println("--------------------------------------------------");
    }

    public static void showReviewById(Review review) {
        System.out.println("REVIEW: " + review.getId());
        System.out.println("--------------------------------------------------");
        System.out.println("USUÁRIO: " + review.getUser().getUsername());
        System.out.println("FILME: " + review.getMovie().getTitle());
        System.out.println("COMENTÁRIO: " + review.getComment());
        System.out.println("DATA DE PUBLICAÇÃO: " + review.getPublishDate());
        System.out.println("--------------------------------------------------");
    }

    public static void showUserById(User user) {
        System.out.println("USUÁRIO: " + user.getUsername());
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + user.getId());
        System.out.println("REVIEWS: ");
        for (Review review : user.getReviews()) {
            System.out.println(review.getMovie());
        }
        System.out.println("--------------------------------------------------");
    }

    public static void showAllMovies(List<Movie> movies) {
        for(Movie movie : movies) {
            System.out.println("FILME: " + movie.getTitle());
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + movie.getId());
            System.out.println("LINGUAGEM: " + movie.getLanguage());
            System.out.println("DIRETOR: " + movie.getDirector());
            System.out.println("GÊNEROS: " + Arrays.toString(movie.getGenres()));
            System.out.println("QUANTIDADE DE REVIEWS: " + movie.getTotalReviews());
            System.out.println("MÉDIA DE ESTRELAS: " + movie.getStars());
            System.out.println("ANO DE LANÇAMENTO: " + movie.getReleaseYear());
            System.out.println("TEMPO DE DURAÇÃO " + movie.getRuntime() + "m");
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showAllReviews(List<Review> reviews) {
        for(Review review : reviews) {
            System.out.println("REVIEW: " + review.getId());
            System.out.println("--------------------------------------------------");
            System.out.println("USUÁRIO: " + review.getUser().getUsername());
            System.out.println("FILME: " + review.getMovie().getTitle());
            System.out.println("COMENTÁRIO: " + review.getComment());
            System.out.println("DATA DE PUBLICAÇÃO: " + review.getPublishDate());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showAllUsers(List<User> users) {
        for(User user : users) {
            System.out.println("USUÁRIO: " + user.getUsername());
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + user.getId());
            System.out.println("REVIEWS: ");
            for (Review review : user.getReviews()) {
                System.out.println(review.getMovie());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showAllCollections(List<MovieUserCollection> collections) {
        for(MovieUserCollection collection : collections) {
            System.out.println("COLEÇÃO: " + collection.getDescription());
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + collection.getId());
            System.out.println("USUÁRIO: ");
            System.out.println("FILMES: " + Arrays.toString(collection.getMovies()));
            System.out.println("--------------------------------------------------");
        }
    }
}
