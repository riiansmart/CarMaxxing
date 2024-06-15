package com.milestone.cst339milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


// REMOVE (exclude = ...) WHEN DATABASE IS CREATED
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Cst339milestoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cst339milestoneApplication.class, args);
	}

}
