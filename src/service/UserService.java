package service;

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

    public List<User> getAllUsers() {
        return userRepository.getData();
    }

    public User getUserById(int id) {
        for(User user : getAllUsers()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(String username) {

            int id = getAllUsers().getLast().getId() + 1;
            List<String> reviews = new ArrayList<>();

            User user = UserFactory.createUser(id, username, reviews);

            userRepository.save(user);
    }
}
