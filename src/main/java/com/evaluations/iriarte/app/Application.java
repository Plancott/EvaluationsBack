package com.evaluations.iriarte.app;


import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
	private final CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (categoryRepository.count() == 0) {
			// Save categories
			List<CategoryEntity> categoriesentities = Arrays.asList(
				new CategoryEntity(null, "Verduras"),
				new CategoryEntity(null, "Electrodomesticos"),
				new CategoryEntity(null, "Cereales"),
				new CategoryEntity(null, "Productos de limpieza"),
				new CategoryEntity(null, "Carnes")
			);
			categoryRepository.saveAll(categoriesentities);}
	
	
		
	// 	if (productsRepository.count() == 0) {
	// 	List<ProductsEntity> productsentities = Arrays.asList(
	// 		new ProductsEntity(null, "Product 1", 100, 10, 1L),
	// 		new ProductsEntity(null, "Product 2", 200, 20, 2L),),
	// 		new ProductsEntity(null, "Product 3", 300, 30, 3L),
	// 		new ProductsEntity(null, "Product 4", 400, 40, 4L),
	// 		new ProductsEntity(null, "Product 5", 500, 50, 5L)
	// 	productsRepository.saveAll(productsentities);
	// }
}

}
