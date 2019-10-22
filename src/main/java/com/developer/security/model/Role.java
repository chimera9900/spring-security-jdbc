package com.developer.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
	private int id;
	private String role;
	private String email;
	public Role(String role) {
		this.role = role;
	}
	public Role(String role, String email) {
		this.role = role;
		this.email = email;
	}
	
	

}
