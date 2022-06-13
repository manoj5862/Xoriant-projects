package com.xoraint.emp.service;

import java.util.List;

import com.xoraint.emp.model.Employee;

public interface EmployeeService {

	void welcome();

	List<?> findAll();

	void deleteEmployee(int empId);

	Employee getEmployeeById(int employeeId);
	public void getEmployeeByName(String empname);

}