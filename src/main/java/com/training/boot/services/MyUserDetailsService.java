package com.training.boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.training.boot.entities.User;
import com.training.boot.repository.UserRepository;

// http://localhost:8080/hello   username - john@abc.com
public class MyUserDetailsService implements UserDetailsService {

	  @Autowired
	  private UserRepository repository;
	  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Query will be fired
		Optional<User> optional = repository.getUserByEmail(username);
		
		User user=null;
		MyUserDetails userFound = null;
		if(optional.isPresent()) {
			user = optional.get();
		    userFound = new MyUserDetails(user);
		}
		
		
		
		return userFound;
	}

}
