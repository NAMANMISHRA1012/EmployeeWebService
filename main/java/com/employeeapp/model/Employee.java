package com.employeeapp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.aspectj.weaver.tools.Trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_info")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(length = 50)
	private String employeeName;
	
	private LocalDate dob;
	
	@Column(unique = true)
	private String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, LocalDate dob, String email) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dob = dob;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dob=" + dob + ", email="
				+ email + "]";
	}
	
	
	
	
	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	private Department department;
	
}
