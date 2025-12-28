package com.matinsoft.hotel.service.impl;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.dto.LoginRequest;
import com.matinsoft.hotel.dto.LoginResponse;
import com.matinsoft.hotel.entity.Employee;
import com.matinsoft.hotel.repository.EmployeeRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	private EmployeeRepository employeeRepository;

	private ActivityHistoryService activityHistoryService;

	public LoginServiceImpl(EmployeeRepository theEmployeeRepository,
			ActivityHistoryService theActivityHistoryService) {
		employeeRepository=theEmployeeRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Override
	public LoginResponse login(LoginRequest request) {

		//Test
		if (request.getUsername() == null || request.getUsername().isBlank()
				|| request.getPassword() == null || request.getPassword().isBlank()) {
			throw new IllegalArgumentException("Username and password are required");
		}

		//Role
		if (request.getRole() == null || request.getRole().isBlank()) {
			throw new IllegalArgumentException("Role is required");
		}

		//Search
		Employee employee=employeeRepository.findByUsername(request.getUsername());

		if (employee == null) {
			 activityHistoryService.log("LOGIN_FAILED", "Login failed: user not found (" + request.getUsername() + ")",
	                    "EMPLOYEE", null, null);
			 throw new IllegalArgumentException("User not found");
		}

		if (!employee.getRole().equals(request.getRole())) {
			 activityHistoryService.log("LOGIN_FAILED", "Login failed: invalid role",
	                    "EMPLOYEE", Long.valueOf(employee.getEmployeeID()),
	                    employee.getEmployeeID());
			 throw new IllegalArgumentException("Invalid role");
		}

		//Check Password
		if (!employee.getPassword().equals(request.getPassword())) {
			 activityHistoryService.log("LOGIN_FAILED", "Login failed: invalid password",
	                    "EMPLOYEE", Long.valueOf(employee.getEmployeeID()),
	                    employee.getEmployeeID());
			 throw new IllegalArgumentException("Invalid password");
		}

		 activityHistoryService.log("LOGIN_SUCCESS", "Employee logged in successfully",
	                "EMPLOYEE", Long.valueOf(employee.getEmployeeID()),
	                employee.getEmployeeID());

		//return DTO
		return new LoginResponse("Login successful", employee.getEmployeeID(),
				employee.getRole(), employee.getUsername());
	}

}
