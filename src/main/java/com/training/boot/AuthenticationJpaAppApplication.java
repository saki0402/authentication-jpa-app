package com.training.boot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.boot.entities.User;
import com.training.boot.repository.UserRepository;

@SpringBootApplication
public class AuthenticationJpaAppApplication {

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationJpaAppApplication.class, args);
	}

	
	@PostConstruct
	public void addRecords() {
	 repository.save(new User("john@abc.com", "1234", true));	
	}
}
