package com.indrasom.ServiceA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indrasom.ServiceA.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	EntityManager entityManager;
	
	@Autowired
	EmployeeDAOImpl(EntityManager e)
	{
		entityManager = e;
	}
	
	@Override
	public List<Employee> findAllEmps() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
		List<Employee> resList = query.getResultList();
		return resList;
	}

	@Override
	public Employee findEmpById(int id) {
		// TODO Auto-generated method stub
		Employee resEmp = entityManager.find(Employee.class, id);
		return resEmp;
	}

	@Override
	public void saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		entityManager.persist(emp);

	}

}
