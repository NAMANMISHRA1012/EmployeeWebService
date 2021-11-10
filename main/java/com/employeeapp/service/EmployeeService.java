package com.employeeapp.service;

import java.time.LocalDate;
import java.util.List;

import com.employeeapp.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public Employee searchEmployeeById(int employeeId);
	
	public void deleteEmployeeById(int employeeId);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee findEmployeeByEmail(String email);
	
	public List<Employee> getEmployeesByBirthDate(LocalDate date);

}
