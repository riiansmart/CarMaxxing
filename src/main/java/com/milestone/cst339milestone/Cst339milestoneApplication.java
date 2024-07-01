package com.milestone.cst339milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


// REMOVE (exclude = ...) WHEN DATABASE IS CREATED
@SpringBootApplication
@ComponentScan(basePackages = "com.milestone.cst339milestone") // Adjust package as per your project structure
public class Cst339milestoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cst339milestoneApplication.class, args);
    }

}
