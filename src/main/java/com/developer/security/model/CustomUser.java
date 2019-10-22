package com.developer.security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data@NoArgsConstructor
public class CustomUser {
	
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	@JsonCreator
	public CustomUser(@JsonProperty("id") int id, 
			@JsonProperty("email") String email, 
			@JsonProperty("password") String password, 
			@JsonProperty("fristName") String firstName, 
			@JsonProperty("lastName") String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public CustomUser(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	

}
