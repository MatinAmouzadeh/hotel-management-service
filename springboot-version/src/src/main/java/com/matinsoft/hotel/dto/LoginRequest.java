package com.matinsoft.hotel.dto;

public class LoginRequest {

	private String username;

	private String password;

	private String role;

	public LoginRequest(String theUsername, String thePassword, String theRole) {
		username=theUsername;
		password = thePassword;
		role = theRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
