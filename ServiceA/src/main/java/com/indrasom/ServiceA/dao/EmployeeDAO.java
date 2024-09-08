package com.indrasom.ServiceA.dao;

import java.util.List;

import com.indrasom.ServiceA.entities.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAllEmps();
	Employee findEmpById(int id);
	void saveEmp(Employee emp);
}
