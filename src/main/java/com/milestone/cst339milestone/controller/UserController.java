package com.milestone.cst339milestone.controller;

import com.milestone.cst339milestone.model.User;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Controller class for handling user registration and related operations.
 */
@Controller
public class UserController {

    /**
     * Displays the registration form.
     * @param model Model object to add attributes for the view.
     * @return The name of the Thymeleaf template for the registration form.
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Register Page");
        return "register";
    }

    /**
     * Processes the registration form submission.
     * @param user The user object populated from the form.
     * @param result BindingResult object for validation results.
     * @param model Model object to add attributes for the view.
     * @return Redirects to the login page upon successful registration.
     */
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        // Mock the save operation or simply log the user details
        System.out.println("User Registered: " + user);

        // Uncomment the following line to actually save the user to the database later
        // userService.saveUser(user);

        // Redirect to login or another page after registration
        return "redirect:/";
    }
}
