package com.alkemy.challenge.auth.dto;

public class AuthenticationRequest {
	private String username;
	private String password;
	
	public AuthenticationRequest() {
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
