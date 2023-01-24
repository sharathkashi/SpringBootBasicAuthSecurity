package com.swag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swag.entities.Employee;
import com.swag.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String welcome() {
		return "employee API called";
	}
	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		return employeeService.getAll();
	}
	@GetMapping("/{id}")
	public Optional<Employee> welcome(@PathVariable int id) {
		return employeeService.getEmpById(id);
		 
	}
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmp(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmpById(id);
	}
	@PutMapping("/{id}")
	public String updateEmployee(@RequestBody Employee e,@PathVariable int id) {
		return employeeService.updateEmp(e,id);
	}
}
