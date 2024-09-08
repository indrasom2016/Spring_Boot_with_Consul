package com.indrasom.ServiceA.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_detail_id")
	EmployeeDetail emp_detail_id;
	
	public Employee()
	{
		
	}
	
	public Employee(String first, String last)
	{
		firstName = first;
		lastName = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeDetail getEmpDetail() {
		return emp_detail_id;
	}

	public void setEmpDetail(EmployeeDetail empDetail) {
		this.emp_detail_id = empDetail;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", empDetail=" + emp_detail_id
				+ "]";
	}
	
	
}
