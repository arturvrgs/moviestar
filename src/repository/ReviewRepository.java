package repository;

import model.entity.Review;
import model.factory.ReviewFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewRepository {

    private final File reviewsFile;

    public ReviewRepository(File reviewsFile) {
        this.reviewsFile = reviewsFile;
    }

    public List<Review> getData() {

        List<Review> reviews = new ArrayList<>();

        try (Scanner scanner = new Scanner(reviewsFile)) {

            //pula a primeira linha
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
                String[] colunas = linha.split(";");

                Review review = ReviewFactory.createReview(
                        Integer.parseInt(colunas[0]), // id
                        Integer.parseInt(colunas[1]), // user
                        Integer.parseInt(colunas[2]), // movie
                        Integer.parseInt(colunas[3]), // stars
                        colunas[4],                   // comment
                        colunas[5]                    // publishDate
                );

                reviews.add(review);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return reviews;
    }
}
