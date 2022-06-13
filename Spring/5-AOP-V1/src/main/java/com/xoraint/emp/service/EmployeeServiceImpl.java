package com.xoraint.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xoraint.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> emps = new ArrayList<Employee>();

	public EmployeeServiceImpl() {
		emps.add(new Employee(10, "Praveen"));
		emps.add(new Employee(11, "James"));
		emps.add(new Employee(12, "Bucky"));
		emps.add(new Employee(13, "Pavan"));
	}

	@Override
	public void welcome() {
		System.out.println(">>>> welcome method");
	}

	@Override
	public List<?> findAll() {
		System.out.println(">>>> finding all employee");
		return null;
	}
	
	
	public void getEmployeeByName(String empname) {
		//System.out.println(emps);
		System.out.println(">>>> Method getEmployeeById() called");
		Employee e1=emps.stream().filter(emp->emp.getEmpName().equals(empname)).findAny().orElse(null);
		//System.out.println(e1);
		//return e1;

	}

	@Override
	public void deleteEmployee(int empId) {
		System.out.println(">>>> deleteEmployee method called");
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		//System.out.println(emps);
		System.out.println(">>> <<<<<< Method getEmployeeById() called");
		Employee e1=emps.stream().filter(emp->emp.getEmpId()==employeeId).findAny().orElse(null);
		//System.out.println(e1);
		return e1;

	}

}
