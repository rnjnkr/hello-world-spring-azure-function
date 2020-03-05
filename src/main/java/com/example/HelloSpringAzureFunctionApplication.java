package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class HelloSpringAzureFunctionApplication {

	@Bean
	public Function<User, Greeting> hello() {
		return user -> new Greeting("Welcome, " + user.getUsername());
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringAzureFunctionApplication.class, args);
	}

}
