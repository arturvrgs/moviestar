package repository;

import model.entity.Review;
import model.factory.ReviewFactory;
import service.MovieService;
import service.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//CLASSE PARA TRAZER E SALVAR REVIEWS DA BASE DE DADOS
public class ReviewRepository {

    private final File reviewsFile;
    private final UserService userService;
    private final MovieService movieService;

    private final List<Review> reviews = new ArrayList<>();

    public ReviewRepository(File reviewsFile, UserService userService, MovieService movieService) {
        this.reviewsFile = reviewsFile;
        this.userService = userService;
        this.movieService = movieService;
        getData();
    }

    //CRIA UM OBJETO PARA CADA LINHA DO ARQUIVO TXT E SALVA NUMA LISTA
    public List<Review> getData() {

        try (Scanner scanner = new Scanner(reviewsFile)) {

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                Review review = ReviewFactory.createReview(
                        Integer.parseInt(colunas[0]), // ID
                        userService.getUserById(Integer.parseInt(colunas[1])), // USER
                        movieService.getMovieById(Integer.parseInt(colunas[2])).getTitle(), // MOVIE
                        Integer.parseInt(colunas[3]), // STARS
                        colunas[4],                   // COMMENT
                        colunas[5]                    // PUBLISHSDATE
                );

                reviews.add(review);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return reviews;
    }

    // SALVA NOVA REVIEW
    public void save(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
