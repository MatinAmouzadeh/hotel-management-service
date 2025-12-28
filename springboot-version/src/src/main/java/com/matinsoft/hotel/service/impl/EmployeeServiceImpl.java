package com.matinsoft.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.Employee;
import com.matinsoft.hotel.repository.EmployeeRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.EmployeeService;
import com.matinsoft.hotel.util.ValidationUtil;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	private ActivityHistoryService activityHistoryService;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository,
			ActivityHistoryService theActivityHistoryService) {
		employeeRepository = theEmployeeRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public Employee save(Employee employee, Integer employeeId) {
		if (employee.getFirstName()==null || employee.getFirstName().isBlank()
				|| employee.getLastName()==null || employee.getLastName().isBlank()
				|| employee.getUsername()==null || employee.getUsername().isBlank()
				|| employee.getPassword()==null || employee.getPassword().isBlank()
				|| employee.getRole()==null || employee.getRole().isBlank()) {

			throw new IllegalArgumentException("Required Employee fields are missing");
		}

		if (employeeRepository.existsByUsername(employee.getUsername())) {
			throw new IllegalArgumentException("Username already exists");
		}

		//First name & last name test
		ValidationUtil.validateName(employee.getFirstName(), "First name");

		ValidationUtil.validateName(employee.getLastName(), "Last name");

		Employee saved = employeeRepository.save(employee);
		activityHistoryService.log("EMPLOYEE_CREATED", "Employee created",
				"EMPLOYEE", Long.valueOf(saved.getEmployeeID()), employeeId);

		return saved;
	}

	@Transactional
	@Override
	public Employee update(Employee employee, Integer employeeId) {
		Employee existing = employeeRepository.findById(employee.getEmployeeID())
				.orElseThrow(() -> new IllegalArgumentException("Employee not found"));

		// First name
		if (employee.getFirstName()!=null && !employee.getFirstName().isBlank()) {
			ValidationUtil.validateName(employee.getFirstName(), "First name");
			existing.setFirstName(employee.getFirstName());
		}

		// Last name
		if (employee.getLastName()!=null && !employee.getLastName().isBlank()) {
			ValidationUtil.validateName(employee.getLastName(), "Last name");
			existing.setLastName(employee.getLastName());
		}

		if (employee.getPassword() != null && !employee.getPassword().isBlank()) {
			existing.setPassword(employee.getPassword());
		}

		if (employee.getRole() != null && !employee.getRole().isBlank()) {
			existing.setRole(employee.getRole());
		}

		Employee updated=employeeRepository.save(existing);

		activityHistoryService.log("EMPLOYEE_UPDATED", "Employee updated",
				"EMPLOYEE", Long.valueOf(updated.getEmployeeID()), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Integer id, Integer employeeId) {

		if (!employeeRepository.existsById(id)) {
			throw new IllegalArgumentException("Employee not found");
		}

		employeeRepository.deleteById(id);

		activityHistoryService.log("EMPLOYEE_DELETED", "Employee deleted",
				"EMPLOYEE", Long.valueOf(id), employeeId);
	}

	@Transactional
	@Override
	public void deleteAll(List<Integer> Ids, Integer employeeId) {
		for (Integer id : Ids) {
			if (!employeeRepository.existsById(id)) {
				throw new IllegalArgumentException("Employee not found: " + id);
			}
		}
		employeeRepository.deleteAllById(Ids);

		for (Integer id : Ids) {
			activityHistoryService.log("EMPLOYEE_DELETED", "Employee deleted",
					"EMPLOYEE", Long.valueOf(id), employeeId);
		}
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Employee not found"));
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
