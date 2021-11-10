package com.employeeapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exception.DuplicateEmployeeException;
import com.employeeapp.model.Employee;
import com.employeeapp.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee employee) {
		if(repo.existsByEmail(employee.getEmail())) {
			throw new DuplicateEmployeeException("Duplicate Email - ["+employee.getEmail()+"]");
		}
		return repo.save(employee);
	}

	@Override
	public Employee searchEmployeeById(int employeeId) {
		return repo.findById(employeeId).get();
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		 repo.deleteById(employeeId);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}
	
	@Override
	public Employee findEmployeeByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	@Override
	public List<Employee> getEmployeesByBirthDate(LocalDate date) {
		return repo.findEmployeesBornedBefore(date);
	}
	

}
