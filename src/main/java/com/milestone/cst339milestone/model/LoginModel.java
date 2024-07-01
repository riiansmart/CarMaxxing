package com.milestone.cst339milestone.model;

/**
 * Model class for user login.
 * This class represents the login model with username and password fields.
 */
public class LoginModel {

    // Field for storing the username, it cannot be null and must have at least one character.
    @jakarta.validation.constraints.NotNull(message = "Username is required")
    @jakarta.validation.constraints.Size(min = 1, message = "Username is required")
    private String username;

    // Field for storing the password, it cannot be null and must have at least one character.
    @jakarta.validation.constraints.NotNull(message = "Password is required")
    @jakarta.validation.constraints.Size(min = 1, message = "Password is required")
    private String password;

    // Getter method for the username field.
    public String getUsername() {
        return username;
    }

    // Setter method for the username field.
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for the password field.
    public String getPassword() {
        return password;
    }

    // Setter method for the password field.
    public void setPassword(String password) {
        this.password = password;
    }
}
