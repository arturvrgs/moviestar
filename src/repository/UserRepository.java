package repository;

import model.entity.Review;
import model.entity.User;
import model.factory.UserFactory;
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

        ReviewRepository reviewRepository = new ReviewRepository(new File("data/reviews.txt"));
        ReviewService reviewService = new ReviewService(reviewRepository);

        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(usersFile)) {

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");


                String[] reviewsIDs = colunas[2].split(",");

                List<Review> reviews = new ArrayList<>();

                for(String review : reviewsIDs) {
                    reviews.add(reviewService.getReviewById(Integer.parseInt(review)));
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
