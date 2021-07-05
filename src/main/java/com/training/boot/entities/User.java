package com.training.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto generated
	private Long id;

	private String email;

	private String passsword;

	private boolean enabled;

	public Long getId() {
		return id;
	}

	public User() {
		System.out.println("User Object Instantiated...");
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(String email, String passsword, boolean enabled) {
		super();
			this.email = email;
		this.passsword = passsword;
		this.enabled = enabled;
	}

}
