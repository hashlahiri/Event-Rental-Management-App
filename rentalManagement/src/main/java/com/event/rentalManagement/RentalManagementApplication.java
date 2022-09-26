package com.event.rentalManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RentalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementApplication.class, args);
	}

}
