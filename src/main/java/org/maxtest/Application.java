package org.maxtest;

import org.maxtest.model.Product;
import org.maxtest.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(ReactiveMongoOperations operations, ProductRepository repository) {
		return args -> {
			Flux<Product> productFlux = Flux.just(
					new Product("Test 1", 1.00),
					new Product("Test 2", 2.00),
					new Product("Test 3", 45.00)
			).flatMap(repository::save);
			
			productFlux
				.thenMany(repository.findAll())
				.subscribe(System.out::println);
			
			/* For real mongo db
			 * operations.collectionExists(Product.class)
				.flatMap(exists -> exists ? operations.dropCollection(Product.class) : Mono.just(exists))
				.thenMany(v -> operations.createCollection(Product.class))
				.thenMany(productFlux)
				.thenMany(repository.findAll())
				.subscribe(System.out::println);*/
		};
	}
}
