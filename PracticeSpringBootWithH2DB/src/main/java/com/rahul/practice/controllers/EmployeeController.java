package com.rahul.practice.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rahul.practice.entities.Employee;
import com.rahul.practice.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> empList = empService.getAllEmployee();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "EmployeeController");
		return ResponseEntity.accepted().headers(headers).body(empList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") Integer empId) {

		Optional<Employee> tempEmployee = empService.getEmployeeById(empId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "EmployeeController");
		return ResponseEntity.accepted().headers(headers).body(tempEmployee);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = empService.createEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "EmployeeController");

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getEmpId()).toUri();

		return ResponseEntity.created(location).headers(headers).body(savedEmployee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer empId) {
		Employee updatedEmployee = empService.updateEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "EmployeeController");

		return ResponseEntity.ok().headers(headers).body(updatedEmployee);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer empId) {
		empService.deleteEmployee(empId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "EmployeeController");

		return ResponseEntity.ok().headers(headers).build();

	}

}
