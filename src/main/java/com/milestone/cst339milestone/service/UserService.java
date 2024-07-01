package com.milestone.cst339milestone.service;

import com.milestone.cst339milestone.model.User;
import com.milestone.cst339milestone.repository.UserRepository;
import org.springframework.stereotype.Service;


/**
 * Service class for handling business logic related to User entities.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a user entity.
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    public User saveUser(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User or username/password cannot be null");
        }
        // Validate user data before saving (if needed)

        return userRepository.save(user);
    }

    /**
     * Finds a user by username.
     * @param username The username of the user to find.
     * @return The user object if found, otherwise null.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
