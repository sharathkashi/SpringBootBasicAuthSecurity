package com.swag.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swag.entities.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

}
