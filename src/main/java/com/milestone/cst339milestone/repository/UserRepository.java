package com.milestone.cst339milestone.repository;

import org.springframework.data.repository.CrudRepository;
import com.milestone.cst339milestone.model.User;

/**
 * Repository interface for managing User entities.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Finds a user by username.
     * @param username The username of the user to find.
     * @return The user object if found, otherwise null.
     */
    User findByUsername(String username);
}
