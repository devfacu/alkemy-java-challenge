package com.alkemy.challenge.auth.dto;

public class UserDTO {
	
	//@Email(message = "Username must be an email")
	private String username;
	//@Size(min = 8)
	private String password;
	
	
	public UserDTO() {
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
