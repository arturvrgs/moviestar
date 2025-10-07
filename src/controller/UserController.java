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

    // MOSTRA TODOS USUARIOS E CONTROLA AÇÕES DO USUARIO
    public void showAllUsers() {
        List<User> users = userService.getAllUsers();
        int option = Display.showAllUsers(scan, users);

        if(option == 0) {
            return;
        }
    }

    // MOSTRA USUARIO POR ID E CONTROLA AÇÕES DO USUARIO
    public void showUserById(int id) {
        User user = userService.getUserById(id);
        Display.showUserById(user);
    }

    // MOSTRA FORMULARIO DE REGISTRO DE USUARIO E CONTROLA ACOES DO USUARIO;
    public void registerUser() {

        String username;

        while(true) {
            username = Display.showUserRegisterForm(scan);

            if(username == null || username.isBlank()) {
                System.out.println("O username não pode estar vazio. Tente novamente");
                continue;
            }

            userService.registerUser(username);
            break;
        }
    }

    // MOSTRA MENU PRINCIPAL E CONTROLA ACOES DO USUARIO
    public void menuOption(
            MovieController movieController, ReviewController reviewController,
            UserController userController, MovieUserCollectionController movieUserCollectionController, DashboardController dashboardController
    ) {

        String username = userService.getAllUsers().getLast().getUsername();

        int option;
        while(true) {
            option = Display.showMainMenu(scan, username);

            if(option < 1 || option > 5) {
                System.out.println("Opção Inválida.");
                continue;
            }

            userService.menuOption(option, movieController, reviewController, userController, movieUserCollectionController, dashboardController);
            break;
        }
    }
}
