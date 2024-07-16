package com.emp.service;

import java.util.List;

import com.emp.model.Employee;


public interface EmployeeService {

	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int id);
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee employee);
	public boolean isEmailUnique(String email);
	
}
