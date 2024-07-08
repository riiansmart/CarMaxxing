package com.milestone.cst339milestone;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.model.LoginModel;

@Controller
public class HomeController {

    private List<Car> carList = new ArrayList<>();
    //will map to the index
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Car Maxxing Home Page");
        return "index";
    }
    //will map to the car listing page
    @GetMapping("/CarListing")
    public String carListing(Model model) {
        model.addAttribute("title", "CarMaxx Listings");
        //carList = carService.getAllCars(); // Replace with your service method to fetch cars
        model.addAttribute("carList", carList);
        return "CarListing";
    }
    //will map to the edit car page
    @GetMapping("/EditCar")
    public String editCar(Model model) {
        model.addAttribute("title", "Edit a Car");
        return "EditCar";
    }
    
    @GetMapping("/ListCar")
    public String listCar(Model model) {
        model.addAttribute("title", "List a Car");
        return "ListCar";
    }
    @PostMapping("/ListCar")
    public String submitCar(@ModelAttribute Car carModel) {
        System.out.println("Submitting car: " + carModel.getMake() + " " + carModel.getModel() + " " + carModel.getYear() + " " + carModel.getColor());
        carList.add(carModel);
        System.out.println("Car list size: " + carList.size());
        return "redirect:/CarListing"; // Redirect to the car-listing page to show all added cars
    }
    @GetMapping("/RemoveCar")
    public String removeCar(Model model) {
        model.addAttribute("title", "Remove a Car");
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
    /**
      * Processes the login form submission.
      * @param loginModel The login model containing user input.
      * @param bindingResult The result of binding the form inputs.
      * @param model The model to pass attributes to the view.
      * @return The name of the Thymeleaf template to render.
      */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        model.addAttribute("title", "Login Form");
        if (bindingResult.hasErrors()) {
            return "login";
        }

        // Print username and password to console
        System.out.println("Username: " + loginModel.getUsername());
        System.out.println("Password: " + loginModel.getPassword());

        // Redirect to the product page
        model.addAttribute("title", "CarMaxx Listings");
        return "CarListing";
    }
}
