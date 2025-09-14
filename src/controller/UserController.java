package controller;

import model.entity.Review;
import model.entity.User;
import service.ReviewService;
import service.UserService;
import view.Display;

import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void showAllUsers() {
        List<User> users = userService.getAllUsers();
        Display.showAllUsers(users);
    }

    public void showUserById(int id) {
        User user = userService.getUserById(id);
        Display.showUserById(user);
    }
}
