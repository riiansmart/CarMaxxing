package com.milestone.cst339milestone;

import jakarta.validation.Valid;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.milestone.cst339milestone.model.LoginModel;
import com.milestone.cst339milestone.model.User;
import com.milestone.cst339milestone.service.UserService;

/**
 * Controller class for handling basic navigation.
 */
@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/CarListing")
    public String carListing() {
        return "CarListing";
    }

    @GetMapping("/EditCar")
    public String editCar() {
        return "EditCar";
    }
    
    @GetMapping("/CarDetails")
    public String carDetails() {
        return "CarDetails";
    }
    
    @GetMapping("/ListCar")
    public String listCar() {
        return "ListCar";
    }
    
    @GetMapping("/RemoveCar")
    public String removeCar() {
        return "RemoveCar";
    }

    /**
      * Displays the login page.
      * @return The name of the Thymeleaf template for the login page.
      */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
    //if the user is logged in display true, if not display false
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        boolean loggedIn = principal != null;
        model.addAttribute("loggedIn", loggedIn);
        return "home";
    }
    //will be used along with "/" in order to make sure the profile is logged in
    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        boolean loggedIn = principal != null;
        model.addAttribute("loggedIn", loggedIn);
        UserService service = new UserService();
        // Check if user is logged in and if the user is valid
        if (loggedIn) {
            String username = principal.getName();
            User user = service.findByUsername(username);
            if (user != null) {
                // User is valid, add user details to model
                model.addAttribute("user", user);
                return "profile";
            }
        }
        // User is not logged in or not valid, redirect to login page
        return "redirect:/login";
    }
    /**
      * Processes the login form submission.
      * @param loginModel The login model containing user input.
      * @param bindingResult The result of binding the form inputs.
      * @param model The model to pass attributes to the view.
      * @return The name of the Thymeleaf template to render.
      */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        // Print username and password to console
        System.out.println("Username: " + loginModel.getUsername());
        System.out.println("Password: " + loginModel.getPassword());

        // Redirect to the product page
        model.addAttribute("title", "Product Page");
        return "product";
    }
}
