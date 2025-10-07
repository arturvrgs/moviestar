package model.factory;

import model.entity.User;
import java.util.List;

//CLASSE CRIADORA DE OBJETO USUÁRIO
public class UserFactory {
    public static User createUser(int id, String username, List<String> reviews) {
        return new User(id, username, reviews);
    }
}
