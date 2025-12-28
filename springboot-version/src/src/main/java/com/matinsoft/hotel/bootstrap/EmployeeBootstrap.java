package com.matinsoft.hotel.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matinsoft.hotel.entity.Employee;
import com.matinsoft.hotel.repository.EmployeeRepository;

@Component
public class EmployeeBootstrap implements CommandLineRunner{

	private EmployeeRepository employeeRepository;

	public EmployeeBootstrap(EmployeeRepository theEmployeeRepository) {

		employeeRepository=theEmployeeRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		if(!employeeRepository.existsByRole("SuperAdmin")) {
			Employee superAdmin= new Employee();
			superAdmin.setFirstName("System");
			superAdmin.setLastName("Admin");
			superAdmin.setUsername("Admin");
			superAdmin.setPassword("rLKivOJKjL$1520OF");
			superAdmin.setRole("SuperAdmin");

			employeeRepository.save(superAdmin);
		}

	}



}
