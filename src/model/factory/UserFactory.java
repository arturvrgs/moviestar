package model.factory;

import model.entity.User;


public class UserFactory {
    public static User createUser(int id, String username, String[] reviews) {
        return new User(id, username, reviews);
    }
}
