package com.employeeapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.employeeapp.exception.DuplicateEmployeeException;
import com.employeeapp.model.Employee;
import com.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int employeeId) {
		
		return service.searchEmployeeById(employeeId);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return service.addEmployee(employee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable("id") int employeeId) {
		
		service.deleteEmployeeById(employeeId);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		
		Employee updatedEmp = service.updateEmployee(employee);
		
		return new ResponseEntity<>(updatedEmp,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employees/email/{email}")
	public Employee getEmployeeByEmail(@PathVariable String email) {
		return service.findEmployeeByEmail(email);
	}
	
	
	@GetMapping("/employees/dob/{date}")
	public List<Employee> getEmployeesByDob(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		return service.getEmployeesByBirthDate(date);
	}
	
}
