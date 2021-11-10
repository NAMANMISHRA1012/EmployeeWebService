package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
