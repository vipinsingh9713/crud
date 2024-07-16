package com.emp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Employe_Details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Employee_id")
	private int id;
	@Column(name="Employee_name")
	@NotBlank(message="Name is mendatory")
	@Size(min=3, max=50 , message="Name should be 3 to 50 characters")
	private String name;
	@Column(name="Employee_department")
	@NotBlank(message="Department is mendatory")
	private String department;
	@Column(name="Employee_salary")
	@Positive(message="Salary should be positive number")
	@NotNull(message="salary is mendatory")
	private double salary;
	@Column(name="Employee_email")
	@NotBlank(message="Email is mendatory")
	@Email(message="Email should be valid")
	private String email;
	@Column(name="Employee_mobile_number")
	@NotBlank(message="Mobile number is mendatory")
	@Size(min=10, max=10 , message="Mobile number should be 10 digit")
	private String mobile_no;
	
	public Employee(int id, String name, String department, double salary, String email, String mobile_no) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.email = email;
		this.mobile_no = mobile_no;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile_no() {
		return mobile_no;
	}
	
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", email=" + email + ", mobile_no=" + mobile_no + "]";
	}
	
	
	
}
