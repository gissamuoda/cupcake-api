package com.gissamusworkspace.cupcakeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile({"local", "heroku"})
public class CupcakeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CupcakeApiApplication.class, args);
	}

}
