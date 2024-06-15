package com.milestone.cst339milestone.repository;

import com.milestone.cst339milestone.model.User;

/**
 * Repository interface for managing User entities.
 */
public interface UserRepository {

    /**
     * Saves a user entity.
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    User save(User user);

    /**
     * Finds a user by username.
     * @param username The username of the user to find.
     * @return The user object if found, otherwise null.
     */
    User findByUsername(String username);
}
