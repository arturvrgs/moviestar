package view;

import model.entity.Movie;
import model.entity.MovieUserCollection;
import model.entity.Review;
import model.entity.User;
import service.DashboardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display {

    public static int showMovieById(Scanner scan, Movie movie) {
        flushDisplay();
        header();
        System.out.println("Filme: " + movie.getTitle());
        line();
        System.out.println("Linguagem: " + movie.getLanguage());
        System.out.println("Diretor: " + movie.getDirector());
        System.out.println("Gêneros: " + Arrays.toString(movie.getGenres()));
        System.out.println("Ano de lançamento: " + movie.getReleaseYear());
        System.out.println("Tempo de duração " + movie.getRuntime() + "m");
        line();
        System.out.println("Digite [1] para FAZER REVIEW");
        System.out.println("Digite [0] para voltar");

        return Integer.parseInt(scan.nextLine());
    }

    public static int showCollectionById(Scanner scan, MovieUserCollection collection) {
        flushDisplay();
        header();
        System.out.println("Coleção: " + collection.getDescription());
        System.out.println("Autor: " + collection.getUser().getUsername());
        System.out.println();
        System.out.println("Filmes: ");
            for(String movieTitle : collection.getMovies()) {
                System.out.println("[" + movieTitle + "]");
            }
        line();
        System.out.println("Digite [0] para voltar");

        return  Integer.parseInt(scan.nextLine());
    }

    public static int showReviewById(Scanner scan, Review review) {
        flushDisplay();
        header();
        System.out.println("Review");
        line();
        System.out.println("Usuário: " + review.getUser().getUsername());
        System.out.println("Filme: " + review.getMovie());
        System.out.println("Comentário: " + review.getComment());
        System.out.println("Data de publicação: " + review.getPublishDate());
        line();
        System.out.print("Digite [0] para voltar: ");

        return Integer.parseInt(scan.nextLine());
    }

    public static void showUserById(User user) {
        flushDisplay();
        header();
        System.out.println("Usuário: " + user.getUsername());
        System.out.println("Review: " + user.getReviews());
        line();
    }

    public static int showAllMovies(Scanner scan, List<Movie> movies) {
        flushDisplay();
        header();
        for(Movie movie : movies) {
            System.out.println("Filme: [" + movie.getTitle() + "]");
            System.out.println("Digite [" + movie.getId() + "] para [VER MAIS ->]");
            line();
        }
        System.out.println("Digite [0] para voltar ");

        return Integer.parseInt(scan.nextLine());
    }

    public static int showAllReviews(Scanner scan, List<Review> reviews) {
        flushDisplay();
        header();
        for(Review review : reviews) {
            System.out.println("Review: [Filme: " + review.getMovie() + "]");
            System.out.println("        [Autor(a): " + review.getUser().getUsername() + "]");
            System.out.println();
            System.out.println("Digite [" + review.getId() + "] para [VER MAIS ->]");
            line();
        }
        System.out.println("Digite [0] para voltar");
        return Integer.parseInt(scan.nextLine());
    }

    public static int showAllUsers(Scanner scan, List<User> users) {
        flushDisplay();
        header();
        for(User user : users) {
            line();
            System.out.println("Usuário: " + user.getUsername());
            System.out.println("Reviews: " + user.getReviews());
            line();
            System.out.println();
        }
        System.out.println("Digite [0] para voltar: ");

        return Integer.parseInt(scan.nextLine());
    }

    public static int showAllCollections(Scanner scan, List<MovieUserCollection> collections) {
        flushDisplay();
        header();
        for(MovieUserCollection collection : collections) {
            line();
            System.out.println("Coleção: " + collection.getDescription());
            System.out.println("Autor: " + collection.getUser().getUsername());
            System.out.println();
            System.out.println("Digite "+collection.getId()+" para [VER MAIS ->]");
            line();
            System.out.println();
        }
        System.out.println("Digite [0] para CRIAR COLEÇÃO: ");

        return Integer.parseInt(scan.nextLine());
    }

    public static String showUserRegisterForm(Scanner scan) {
        header();
        System.out.println("  Digite seu Username                              ");
        line();
        System.out.print("Username : ");
        return scan.nextLine();
    }

    public static int showMainMenu(Scanner scan, String username) {
        flushDisplay();
        header();
         System.out.printf("    Bem-vindo(a), %s                                 \n", username);
        line();
        System.out.println("    1-[Listar Filmes]     2-[Listar Reviews]       ");
        System.out.println("                                                   ");
        System.out.println("    3-[Listar Usuários]   4-[Listar Coleções]      ");
        System.out.println("                                                   ");
        System.out.println("    5-[Ver Relatórios]                             ");
        line();
        System.out.print("Escolha uma opção: ");

        return Integer.parseInt(scan.nextLine());
    }

    public static void showDashboard(DashboardService dashboardService) {
        System.out.println(dashboardService.getMostPopularMovie());
    }


    public static String[] showReviewForm(Scanner scan, String movieTitle) {
        flushDisplay();
        String[] reviewInfo = new String[3];
        reviewInfo[0] = movieTitle;

        header();
        System.out.println("   Filme: " + movieTitle);
        line();
        System.out.println("  Digite a quantidade de estrelas:                 ");
        String stars = scan.nextLine();
        reviewInfo[1] = stars;
        System.out.println("  Digite seu comentário:                           ");
        String comment = scan.nextLine();
        line();
        reviewInfo[2] = comment;
        return reviewInfo;
    }

    public static String[] showCollectionForm(Scanner scan, List<Movie> movies) {
        flushDisplay();
        String[] collectionInfo = new String[2];

        header();
        System.out.println("Digite o nome da coleção: ");
        String description = scan.nextLine();
        collectionInfo[0] = description;
        line();
        List<Integer> moviesID = new ArrayList<>();

        for(Movie movie : movies) {
            System.out.println("[" + movie.getId() + "] "+ movie.getTitle());
        }

        while (true) {
            System.out.println("Digite o número do filme que deseja adicionar a sua coleção");
            System.out.println("Digite [0] para FINALIZAR");

            int id = Integer.parseInt(scan.nextLine().trim());

            if(id == 0) {
                break;
            } else {
                moviesID.add(id);
            }
        }

        collectionInfo[1] = Arrays.toString(moviesID.toArray());

        return collectionInfo;
    }

    private static void flushDisplay() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    private static void header() {
        line();
        System.out.println("                     Moviestar                     ");
        line();
    }

    private static void line() {
        System.out.println("---------------------------------------------------");
    }
}
