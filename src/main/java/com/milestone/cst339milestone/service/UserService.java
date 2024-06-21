package com.milestone.cst339milestone.service;

import com.milestone.cst339milestone.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling business logic related to User entities.
 */
@Service
public class UserService {

    // Temporary storage using in-memory list
    private List<User> userList = new ArrayList<>();

    /**
     * Saves a user entity temporarily.
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    public User saveUser(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User or username/password cannot be null");
        }
        // Validate user data before saving
        if (!isValidUser(user)) {
            throw new IllegalArgumentException("Invalid user data");
        }
        // Simulate database save by adding to list
        userList.add(user);
        return user;
    }
    /**
     * Finds a user by username.
     * @param username The username of the user to find.
     * @return The user object if found, otherwise null.
     */
    public User findByUsername(String username) {
        // Simulate database find by iterating through list
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    private boolean isValidUser(User user) {
        // Perform validation logic here
        return true;
    }
}
