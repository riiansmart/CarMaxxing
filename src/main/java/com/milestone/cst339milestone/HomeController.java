package com.milestone.cst339milestone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

