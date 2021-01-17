package com.rahul.practice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer empId;

	private String empName;

	public Employee() {

	}

	public Employee(Integer empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
