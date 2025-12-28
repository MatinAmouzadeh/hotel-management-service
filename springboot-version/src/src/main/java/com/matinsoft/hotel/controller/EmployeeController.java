package com.matinsoft.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matinsoft.hotel.dto.EmployeeCreateRequest;
import com.matinsoft.hotel.entity.Employee;
import com.matinsoft.hotel.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}

	@PostMapping
	public Employee save(
			@RequestBody EmployeeCreateRequest request,
			@RequestHeader("Employee-Id") Integer employeeId) {

		Employee employee = new Employee();
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setUsername(request.getUsername());
		employee.setPassword(request.getPassword());
		employee.setRole(request.getRole());

		return employeeService.save(employee, employeeId);
	}


	// UPDATE
	@PutMapping
	public Employee update(@RequestBody Employee employee,
			@RequestHeader("Employee-Id") Integer employeeId) {

		return employeeService.update(employee, employeeId);
	}

	// DELETE SINGLE
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id,
			@RequestHeader("Employee-Id") Integer employeeId,
			@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
			throw new SecurityException("Access denied");
		}

		employeeService.deleteById(id, employeeId);
	}

	// DELETE MULTIPLE
	@DeleteMapping("/bulk")
	public void deleteAll(@RequestBody List<Integer> ids,
			@RequestHeader("Employee-Id") Integer employeeId,
			@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
			throw new SecurityException("Access denied");
		}
		employeeService.deleteAll(ids, employeeId);
	}

	// GET SINGLE
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Integer id) {
		return employeeService.findById(id);
	}

	// GET ALL
	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

}
