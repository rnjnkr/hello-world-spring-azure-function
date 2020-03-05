package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import org.junit.Test;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloSpringAzureFunctionApplicationTests {

	@Test
	public void test() {
		Greeting result = new HelloSpringAzureFunctionApplication().hello().apply(new User("foo"));
		System.out.println(result.getGreeting());
		assertThat(result.getGreeting()).isEqualTo("Welcome, foo");
	}

	@Test
	public void start() throws Exception {
		AzureSpringBootRequestHandler<User, Greeting> handler = new AzureSpringBootRequestHandler<>(
				HelloSpringAzureFunctionApplication.class);
		Greeting result = handler.handleRequest(new User("foo"), null);
		handler.close();
		System.out.println(result.getGreeting());
		assertThat(result.getGreeting()).isEqualTo("Welcome, foo");
	}
}