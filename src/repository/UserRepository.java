package repository;

import model.entity.Movie;
import model.entity.Review;
import model.entity.User;
import model.factory.ReviewFactory;
import model.factory.UserFactory;
import service.MovieService;
import service.ReviewService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    private final File usersFile;

    public UserRepository(File usersFile) {
        this.usersFile = usersFile;
    }

    public List<User> getData() {

        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(usersFile)) {

            ReviewRepository reviewRepository = new ReviewRepository(new File("data/reviews.txt"));
            ReviewService reviewService = new ReviewService(reviewRepository);

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                //Tranformando os IDS de reviews em objetos dentro do array de reviews do "User"
                String[] reviewsIDs = colunas[2].split(",");
                Review[] reviews = new Review[reviewsIDs.length];

                for(int i = 0; i < reviewsIDs.length; i++) {
                    int id = Integer.parseInt(reviewsIDs[i]);

                    Review review = reviewService.getReviewById(id);
                    reviews[i] = review;
                }

                User user = UserFactory.createUser(
                    Integer.parseInt(colunas[0]),  // id
                    colunas[1],                    //username
                    reviews                    //reviews
                );

                users.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
