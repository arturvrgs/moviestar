package model.factory;

import model.entity.User;

import java.util.Scanner;

public class UserFactory {
    public static User createUser() {

        Scanner scan = new Scanner(System.in);

        //validar
        System.out.println("Digite o seu nome de usuário: ");
        System.out.println("------------------------------");
        String username = scan.nextLine();

        return new User(username);
    }
}
