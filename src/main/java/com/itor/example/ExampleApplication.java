package com.itor.example;

import com.itor.example.models.Author;
import com.itor.example.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(

			AuthorRepository repository
	) {
		return args -> {

			var author = Author.builder()
					.firstName("John")
					.lastName("Doe")
					.age(27)
					.email("shelt@gmail.com")
					.build();
			repository.save(author);
		};
	}

}
