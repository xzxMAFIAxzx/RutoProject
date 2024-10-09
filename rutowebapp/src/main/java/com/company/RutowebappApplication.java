package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.company","com.company"})
public class RutowebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RutowebappApplication.class, args);
	}

}
