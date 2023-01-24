package com.swag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swag.daos.EmployeeRepo;
import com.swag.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public List<Employee> getAll() {
		return (List<Employee>) employeeRepo.findAll();
	}

	public Optional<Employee> getEmpById(int id) {
		return employeeRepo.findById(id);
	}

	public String deleteEmpById(int id) {
		try {
			employeeRepo.deleteById(id);
			return "Deleted Successfully";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Deleted unsuccessful";
		}
	}

	public Employee addEmp(Employee e) {
		return employeeRepo.save(e);
	}

	public String updateEmp(Employee e, int id) {
		if (this.getEmpById(id).isPresent()) {
			e.setEmpId(id);
			employeeRepo.save(e);
			return "updated";
		}
		return "Not Updated";
	}

}
