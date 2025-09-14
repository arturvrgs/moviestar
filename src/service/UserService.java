package service;

import model.entity.Review;
import model.entity.User;
import repository.ReviewRepository;
import repository.UserRepository;

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
}
