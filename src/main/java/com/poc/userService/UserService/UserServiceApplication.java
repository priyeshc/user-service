package com.poc.userService.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.poc.userService.UserService.model")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	/*
	 * @Bean CommandLineRunner commandLineRunner(UserRepository repository) { return
	 * args -> { User user = new User((long) 1, "Priyesh",
	 * "priyesh.chandra@hcl.com");
	 * 
	 * repository.save(user); }; }
	 */

}
