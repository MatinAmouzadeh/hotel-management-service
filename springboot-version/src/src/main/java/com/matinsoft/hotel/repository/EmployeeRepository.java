package com.matinsoft.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	 boolean existsByRole(String role);

	 Employee findByUsername(String username);

	 boolean existsByUsername(String username);
}
