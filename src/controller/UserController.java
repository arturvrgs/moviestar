package controller;

import model.entity.User;
import service.UserService;
import view.Display;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private final UserService userService;

    Scanner scan = new Scanner(System.in);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void showAllUsers() {
        List<User> users = userService.getAllUsers();
        int option = Display.showAllUsers(scan, users);

        if(option == 0) {
            return;
        }
    }

    public void showUserById(int id) {
        User user = userService.getUserById(id);
        Display.showUserById(user);
    }

    public void registerUser() {
        String username = Display.showUserRegisterForm(scan);
        userService.registerUser(username);
    }

    public void menuOption(
            MovieController movieController, ReviewController reviewController,
            UserController userController, MovieUserCollectionController movieUserCollectionController, DashboardController dashboardController
    ) {

        String username = userService.getAllUsers().getLast().getUsername();

        int option = Display.showMainMenu(scan, username);
        userService.menuOption(option, movieController, reviewController, userController, movieUserCollectionController, dashboardController);
    }
}
