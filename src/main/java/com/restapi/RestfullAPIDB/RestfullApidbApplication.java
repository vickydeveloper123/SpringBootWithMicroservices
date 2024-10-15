package com.restapi.RestfullAPIDB;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(

				title = "Spring Boot REST API Documentation",
				description = "Spring boot REST API Documentation",
				version = "10.0.0",
				contact = @Contact(
						name = "Dora Sri Vignesh",
						email = "dorasrivignesh@gmail.com",
						url = "https://github.com/vickydeveloper123/SpringFrameworkDora/tree/framwework"
				),
				license = @License(
						name = "Apache2.0.9",
						url = "https://github.com/vickydeveloper123/SpringFrameworkDora/tree/framwework"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot Management Documentation",
				url = "https://www.youtube.com/watch?v=6KiSMLWdxCk"
		)





)


public class RestfullApidbApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestfullApidbApplication.class, args);
		System.out.println("  Spring boot rest API application started sucessfully.....");
	}

}
