package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {

	//method is used to add employee details
	public Employee addEmployee(Employee employee);
	
	//method is used to remove employee details 
	public String removeEmployee(int id);
	
	//method is used to find employee by id  
	public Employee findEmpById(int id);
	
	//method is used to get all employee list 
	public List<Employee> getAllEmployee();
	
	//method is used to update employee details by id 
	public Employee updateEmployee(int id, Employee emp);
	
	//method is used to get employee details by first name 
	List<Employee> getEmployeeByFirstName(String firstName);
	
	//method is used to get employee details by his designation 
	List<Employee> getEmployeeByDesignation(String designation);
	
	//method is used to get  employee details by his email id 
	Employee getEmployeeByEmail(String email);

	List<Employee> getEmployeeByDepartment(String department);
	
	Employee assignEmpToDept(int empId, int deptId);
	
	
}
