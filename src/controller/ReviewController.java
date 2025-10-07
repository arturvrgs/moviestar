package controller;

import model.entity.Movie;
import model.entity.Review;
import service.MovieService;
import service.ReviewService;
import service.UserService;
import view.Display;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Scanner;

public class ReviewController {
    private final ReviewService reviewService;
    Scanner scan = new Scanner(System.in);

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    // MOSTRA TODAS REVIEWS E CONTROLA AÇÕES DO USUÁRIO
    public void showAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        int id =  Display.showAllReviews(scan, reviews);

        if(id == 0) {
            return;
        } else {
            showReviewById(id);
        }
    }

    // MOSTRA REVIEW PELO ID E CONTROLA AÇÕES DO USUÁRIO
    public void showReviewById(int id) {
        Review review = reviewService.getReviewById(id);

        int option = Display.showReviewById(scan, review);

        if(option == 0) {
            return;
        }
    }

    // MOSTRA FORMULARIO DE CRIAÇÃO DE REVIEW
    public void showReviewForm(String movieTitle) {
        while(true) {
            String[] reviewInfo = Display.showReviewForm(scan, movieTitle);

            int stars = Integer.parseInt(reviewInfo[1]);

            if(stars < 1 || stars > 5) {
                System.out.println("Quantidade de estrelas permitidas somente de 1 a 5.");
                continue;
            }

            reviewService.createReview(reviewInfo);
            System.out.println("Review criada com sucesso!");
            break;
        }
    }
}
