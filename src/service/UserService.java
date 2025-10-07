package service;

import controller.*;
import model.entity.Review;
import model.entity.User;
import model.factory.UserFactory;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // RETORNA TODOS USUARIOS
    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }

    // RETORNA USUARIO PELO ID
    public User getUserById(int id) {
        for(User user : getAllUsers()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // REGISTRA USUARIO
    public void registerUser(String username) {

            int id = userRepository.getUsers().getLast().getId() + 1;
            List<String> reviews = new ArrayList<>();

            User user = UserFactory.createUser(id, username, reviews);

            userRepository.save(user);
    }

    // LÊ AÇÕES DO USUARIO NO MENU PRINCIPAL
    public void menuOption(
            int option, MovieController movieController, ReviewController reviewController,
            UserController userController, MovieUserCollectionController movieUserCollectionController, DashboardController dashboardController
    ) {

            if(option == 1) {
                movieController.showAllMovies();
        }

        if(option == 2) {
            reviewController.showAllReviews();
        }

        if(option == 3) {
            userController.showAllUsers();
        }

        if(option == 4) {
            movieUserCollectionController.showAllCollections();
        }

        if(option == 5) {
            dashboardController.showDashboard();
        }
    }
}
