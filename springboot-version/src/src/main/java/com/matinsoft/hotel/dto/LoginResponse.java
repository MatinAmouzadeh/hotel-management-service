package com.matinsoft.hotel.dto;

public class LoginResponse {

	private String message;
	private Integer employeeId;
	private String role;
	private String username;

	public LoginResponse(String message, Integer employeeId, String role, String username) {
		this.message = message;
		this.employeeId = employeeId;
		this.role = role;
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
