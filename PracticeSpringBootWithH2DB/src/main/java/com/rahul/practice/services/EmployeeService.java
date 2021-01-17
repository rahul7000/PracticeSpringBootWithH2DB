package com.rahul.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.practice.entities.Employee;
import com.rahul.practice.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Integer empId) {
		return empRepository.findById(empId);
	}

	public Employee createEmployee(Employee employee) {
		return empRepository.save(employee);
		
	}

	public Employee updateEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	public void deleteEmployee(Integer empId) {
		empRepository.deleteById(empId);
	}

}
