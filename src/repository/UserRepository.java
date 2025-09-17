package repository;

import model.entity.Review;
import model.entity.User;
import model.factory.UserFactory;
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


    public UserRepository(File usersFile) {
        this.usersFile = usersFile;
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

                User user = UserFactory.createUser(
                    Integer.parseInt(colunas[0]),  // id
                    colunas[1], //username
                        new ArrayList<>(List.of(reviewsIDs))   //reviews
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

    public List<User> getUsers() {
        return users;
    }
}
