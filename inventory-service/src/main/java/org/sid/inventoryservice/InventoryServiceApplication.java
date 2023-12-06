package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repo.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient //Pour s'enregistrer

public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(IProductRepository pr){
		return args -> {
			pr.saveAll(List.of(
					Product.builder().name("PC").price(10000).quatity(70).build(),
					Product.builder().name("PC1").price(18000).quatity(70).build(),
					Product.builder().name("PC2").price(10070).quatity(70).build(),
					Product.builder().name("Souris").price(100).quatity(70).build(),
					Product.builder().name("Clavier").price(1000).quatity(70).build()
			));
		};
	}
}
