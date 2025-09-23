package repository;

import model.entity.Review;
import model.entity.User;
import model.factory.UserFactory;
import service.MovieService;
import service.ReviewService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    private final File usersFile;
    private final List<User> users = new ArrayList<>();
    private final MovieService movieService;

    public UserRepository(File usersFile, MovieService movieService) {
        this.usersFile = usersFile;
        this.movieService = movieService;
        getData();
    }

    public List<User> getData() {

        try (Scanner scanner = new Scanner(usersFile)) {

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");


                String[] reviewsIDs = colunas[2].split(",");

                List<String> movieTitles = new ArrayList<>();
                movieTitles.add(movieService.getMovieById(Integer.parseInt(reviewsIDs[0])).getTitle());
                movieTitles.add(movieService.getMovieById(Integer.parseInt(reviewsIDs[1])).getTitle());

                User user = UserFactory.createUser(
                    Integer.parseInt(colunas[0]),  // id
                    colunas[1], //username
                        movieTitles  //reviews
                );

                users.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public void saveUserReview(Review review) {
        User user = users.getLast();
        List<String> reviews = user.getReviews();
        reviews.add(String.valueOf(review.getId()));
        user.setReviews(reviews);
    }

    public List<User> getUsers() {
        return users;
    }
}
