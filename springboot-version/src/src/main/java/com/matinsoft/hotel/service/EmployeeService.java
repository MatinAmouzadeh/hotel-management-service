package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.Employee;

public interface EmployeeService {

	Employee save(Employee employee, Integer employeeId);

	Employee update(Employee employee, Integer employeeId);

	void deleteById(Integer Id, Integer employeeId);

	void deleteAll(List<Integer> Ids, Integer employeeId);

	Employee findById(Integer Id);

	List<Employee> findAll();

}
