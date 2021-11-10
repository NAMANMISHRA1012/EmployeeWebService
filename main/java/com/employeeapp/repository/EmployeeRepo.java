package com.employeeapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeeapp.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
	public Employee findByEmail(String email);
	
//	@Query(value = "from Employee where dob<:someDate")
//	public List<Employee> findEmployeesBornedBefore(LocalDate someDate);
	
	@Query(value = "select * from employee_info where dob<:someDate", nativeQuery = true)
	public List<Employee> findEmployeesBornedBefore(LocalDate someDate);
	
	public boolean existsByEmail(String email);
	
}
