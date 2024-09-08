package com.indrasom.ServiceA.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeDetail {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="email")
	String email;
	
	@Column(name="linkedin")
	String linkedIn;
	
	@OneToOne(mappedBy="emp_detail_id", cascade=CascadeType.ALL)
	Employee emp;
	
	public EmployeeDetail()
	{
		
	}
	
	public EmployeeDetail(String e, String web)
	{
		email = e;
		linkedIn = web;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "EmployeeDetail [id=" + id + ", email=" + email + ", linkedIn=" + linkedIn + ", emp=" + emp + "]";
	}
	
	
}
