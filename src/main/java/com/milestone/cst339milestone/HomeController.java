package com.milestone.cst339milestone;

import com.milestone.cst339milestone.model.Carmodel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    // List to temporarily store car listings
    private List<Carmodel> carList = new ArrayList<>();

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/CarListing")
    public String carListing(Model model) {
        model.addAttribute("carList", carList);
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
    public String listCar(Model model) {
        model.addAttribute("carmodel", new Carmodel());
        return "ListCar";
    }
    
    @PostMapping("/ListCar")
    public String submitCar(@ModelAttribute Carmodel carmodel) {
        System.out.println("Submitting car: " + carmodel.getMake() + " " + carmodel.getModel() + " " + carmodel.getYear() + " " + carmodel.getColor());
        carList.add(carmodel);
        System.out.println("Car list size: " + carList.size());
        return "redirect:/CarListing"; // Redirect to the car-listing page to show all added cars
    }
    
    @GetMapping("/RemoveCar")
    public String removeCar() {
        return "RemoveCar";
    }
}
