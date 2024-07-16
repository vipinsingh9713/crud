package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return this.employeeDao.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeDao.save(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		
		this.employeeDao.deleteById(id);;
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeDao.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		
		return this.employeeDao.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
	}

	@Override
	public boolean isEmailUnique(String email) {
		
		return this.employeeDao.findByEmail(email)==null;
	}

	
}
