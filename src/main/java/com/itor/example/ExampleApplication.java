package com.itor.example;

import com.github.javafaker.Faker;
import com.itor.example.models.Author;
import com.itor.example.models.Video;
import com.itor.example.repositories.AuthorRepository;
import com.itor.example.repositories.VideoRepository;
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

			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {

			for (int i = 0; i < 50; i++) {

				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username() + "@gmail.com")
						.build();
				repository.save(author);
			}

			var author = Author.builder()
					.id(1)
					.firstName("Shelton")
					.lastName("Itor")
					.age(25)
					.email("sheltoniyassa@gmail.com")
					.build();
//			repository.save(author);
//			repository.updateAuthor(22,1);
			repository.updateAllAuthorsAges(99);
			//update Author a set a.age = 22 where a.id = 1
		};
	}

}
