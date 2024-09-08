package com.indrasom.ServiceA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indrasom.ServiceA.entities.Employee;
import com.indrasom.ServiceA.service.EmployeeService;

@RestController
@RequestMapping("/api/service1")
public class ServiceAController {

	private EmployeeService employeeService;
	
	@Autowired
	public ServiceAController(EmployeeService theEmpService)
	{
		employeeService = theEmpService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable("employeeId") int id)
	{
		Employee retrievedEmployee = employeeService.findById(id);
		if(retrievedEmployee == null)
		{
			throw new RuntimeException("Employee not found");
		}
		return retrievedEmployee;
	}
	
	@PostMapping("/employees")
	public void saveEmployee(@RequestBody Employee emp)
	{
		emp.setId(0);
		employeeService.saveEmployee(emp);
	}
	
}
