package com.indrasom.ServiceA.service;

import java.util.List;

import com.indrasom.ServiceA.entities.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(int id);
	void saveEmployee(Employee emp);
}
