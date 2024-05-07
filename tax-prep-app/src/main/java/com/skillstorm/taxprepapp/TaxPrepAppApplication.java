package com.skillstorm.taxprepapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxPrepAppApplication {

	public static String getFrontendUrl() {
		return "http://localhost:5173";
	}

	public static void main(String[] args) {
		SpringApplication.run(TaxPrepAppApplication.class, args);
	}

}
