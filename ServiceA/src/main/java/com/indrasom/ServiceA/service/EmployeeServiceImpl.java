package com.indrasom.ServiceA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indrasom.ServiceA.dao.EmployeeDAO;
import com.indrasom.ServiceA.entities.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO empDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO edao)
	{
		empDAO = edao;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return empDAO.findAllEmps();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return empDAO.findEmpById(id);
	}

	@Transactional
	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.saveEmp(emp);
		
	}

}
