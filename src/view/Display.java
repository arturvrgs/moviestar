package view;

import model.entity.Movie;
import model.entity.MovieUserCollection;
import model.entity.Review;
import model.entity.User;
import service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display {

    public static void showMovieById(Movie movie) {
        flushDisplay();
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
        flushDisplay();
        System.out.println("COLEÇÃO: " + collection.getDescription());
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + collection.getId());
        System.out.println("USUÁRIO: " + collection.getUser());
        System.out.println("FILMES: ");
        for(Movie movie : collection.getMovies()) {
            System.out.println(movie.getTitle());
        }
        System.out.println("--------------------------------------------------");
    }

    public static void showReviewById(Review review) {
        flushDisplay();
        System.out.println("REVIEW: " + review.getId());
        System.out.println("--------------------------------------------------");
        System.out.println("USUÁRIO: " + review.getUser().getUsername());
        System.out.println("FILME: " + review.getMovie().getTitle());
        System.out.println("COMENTÁRIO: " + review.getComment());
        System.out.println("DATA DE PUBLICAÇÃO: " + review.getPublishDate());
        System.out.println("--------------------------------------------------");
    }

    public static void showUserById(User user) {
        flushDisplay();
        System.out.println("USUÁRIO: " + user.getUsername());
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + user.getId());
        System.out.println("REVIEWS: " + user.getReviews());
        System.out.println("--------------------------------------------------");
    }

    public static int showAllMovies(Scanner scan, List<Movie> movies) {
        flushDisplay();
        for(Movie movie : movies) {
            System.out.println("FILME: [" + movie.getTitle() + "]");
            System.out.println("DIGITE [" + movie.getId() + "] PARA [VER MAIS ->]");
            System.out.println("--------------------------------------------------");
//            System.out.println("ID: " + movie.getId());
//            System.out.println("LINGUAGEM: " + movie.getLanguage());
//            System.out.println("DIRETOR: " + movie.getDirector());
//            System.out.println("GÊNEROS: " + Arrays.toString(movie.getGenres()));
//            System.out.println("QUANTIDADE DE REVIEWS: " + movie.getTotalReviews());
//            System.out.println("MÉDIA DE ESTRELAS: " + movie.getStars());
//            System.out.println("ANO DE LANÇAMENTO: " + movie.getReleaseYear());
//            System.out.println("TEMPO DE DURAÇÃO " + movie.getRuntime() + "m");
//            System.out.println("--------------------------------------------------");
        }

        return Integer.parseInt(scan.nextLine());
    }

    public static void showAllReviews(List<Review> reviews) {
        flushDisplay();
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
        flushDisplay();
        for(User user : users) {
            System.out.println("USUÁRIO: " + user.getUsername());
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + user.getId());
            System.out.println("REVIEWS: " + user.getReviews());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void showAllCollections(List<MovieUserCollection> collections) {
        flushDisplay();
        for(MovieUserCollection collection : collections) {
            System.out.println("COLEÇÃO: " + collection.getDescription());
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + collection.getId());
            System.out.println("USUÁRIO: " + collection.getUser().getUsername());
            System.out.print("FILMES: ");
            for(Movie movie : collection.getMovies()) {
                System.out.print("[" + movie.getTitle() + "]");
            }
            System.out.println("\n--------------------------------------------------");
        }
    }

    public static String showUserRegisterForm(Scanner scan) {
        System.out.println("|----------------------------------------------------------------------|");
        System.out.println("|                                MOVIESTAR                             |");
        System.out.println("|----------------------------------------------------------------------|");
        System.out.println("|  DIGITE SEU USERNAME:                                                |");
        System.out.println("|----------------------------------------------------------------------|");

        return scan.nextLine();
    }

    public static int showMainMenu(Scanner scan, String username) {
        flushDisplay();
        System.out.println("|----------------------------------------------------------------------|");
        System.out.println("|                                MOVIESTAR                             |");
        System.out.println("|----------------------------------------------------------------------|");
         System.out.printf("   Bem-vindo, %s                                                      \n", username);
        System.out.println("|----------------------------------------------------------------------|");
        System.out.println("|   1-[LISTAR FILMES]               2-[LISTAR REVIEWS]                 |");
        System.out.println("|                                                                      |");
        System.out.println("|   3-[LISTAR USUÁRIOS]            4-[LISTAR COLEÇÕES]                 |");
        System.out.println("|----------------------------------------------------------------------|");
        System.out.print("ESCOLHA UMA OPÇÃO: ");

        return Integer.parseInt(scan.nextLine());
    }

    private static void flushDisplay() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
