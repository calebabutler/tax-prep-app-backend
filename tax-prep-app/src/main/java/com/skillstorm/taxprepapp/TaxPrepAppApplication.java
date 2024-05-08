package com.skillstorm.taxprepapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxPrepAppApplication {

	public static String getFrontendUrl() {
		return "http://andrea-caleb-expresstax.s3-website-us-east-1.amazonaws.com";
	}

	public static void main(String[] args) {
		SpringApplication.run(TaxPrepAppApplication.class, args);
	}

}
