package com.training.boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.training.boot.services.MyUserDetailsService;

// Whenever you want to customize the security
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public MyUserDetailsService myUserDetailsService() {
		return new MyUserDetailsService();
	}
	// Override the security for rest endpoints
	// all request to http://localhost:8080/employees/{id} will be authenticated
	// httpBasic will authenticate details from POSTMAN & client app like Angular
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/hello").authenticated()
		.antMatchers("/status").permitAll().and().httpBasic();
	}

	// Override to create the user credentials programmatically
	// User Management using InMemoryUserDetailsManager
	// User -> username, password, ROLE -> ADMIN or ROLE -> USER
	// ROLE defines authority granted to that user

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
		  
		  DaoAuthenticationProvider myProvider = new DaoAuthenticationProvider();
		  myProvider.setUserDetailsService(myUserDetailsService());
		  myProvider.setPasswordEncoder(passwordEncoder());
		  return myProvider;
	  }
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	
	
	
}
