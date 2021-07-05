package com.training.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.boot.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	// Query
	@Query("SELECT u from User u WHERE u.email = :email")
	public Optional<User> getUserByEmail(@Param("email") String email);
	
}
