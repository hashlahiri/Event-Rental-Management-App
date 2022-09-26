package com.event.rentalManagement.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	// the main swagger configuration
		@Bean
		public Docket swaggerConfiguration() {
			// return a prepared Docket instance
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.event.rentalManagement.controller")).build()
					.apiInfo(apiDetails());
		}

		// main swagger configuration with api details
		private ApiInfo apiDetails() {
			return new ApiInfo("Event Rental Management App Api", "Chanakya Lahiri Project Initiation", "1.0",
					"Free to use", new springfox.documentation.service.Contact("Chanakya Lahiri", "http://localhost:9090",
							"dmc1922020@zealeducation.com"),
					"API License", "dmc1922020@zealeducation.com", Collections.emptyList());
		}

}
