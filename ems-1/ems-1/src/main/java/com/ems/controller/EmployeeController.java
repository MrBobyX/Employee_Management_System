package com.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	
	@GetMapping("/home")
	public String homePage() {
		
		return "Welcome To Employee Management :";
		
	}
	//Method to add Employee 
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee emp = empservice.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	//Method to delete employee 
	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") int id ){
		empservice.removeEmployee(id);
		
		return new ResponseEntity<String> ("Removed Succesfully", HttpStatus.OK);
	}
	//Method to find employee by id 
	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") int id){
		Employee emps = empservice.findEmpById(id);
		
		
		return new ResponseEntity<Employee>(emps, HttpStatus.OK);
		
	}
	//Method to get all employee list
	@GetMapping("/allEmps")
	public ResponseEntity<List<Employee>> listOfEmployee(){
		
		List<Employee> lEmp = empservice.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(lEmp, HttpStatus.OK);
		
	}
	//Method to find employee by its first name 
	@GetMapping("/findEmpByFirstName/{name}")
	public ResponseEntity<List<Employee>> findEmployeeByFirstName(@PathVariable("name") String name){
		List<Employee> emps = empservice.getEmployeeByFirstName(name);
		
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		
	}
	//Method to Find employee by Designation 
	@GetMapping("/findEmpByDesignation/{des}")
	public ResponseEntity<List<Employee>> findEmployeeByDesignation(@PathVariable("des") String des){
		List<Employee> emps = empservice.getEmployeeByDesignation(des);
		
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		
	}
	//Method to Find employee by email id 
	@GetMapping("/findEmpByEmail/{email}")
	public ResponseEntity<Employee> findEmployeeByEmail(@PathVariable("email") String email){
		Employee emps = empservice.getEmployeeByEmail(email);
		
		
		return new ResponseEntity<Employee>(emps, HttpStatus.OK);
		
	}
	//MEthod to Find employee by epartment 
	@GetMapping("/findEmpByDepartment/{department}")
	public List<Employee> findEmployeeByDepartment(@PathVariable("department") String department){
		List<Employee> emps = empservice.getEmployeeByDepartment(department);
		
		
		return emps;
		
	}
	//MEthod to Update employee in exesting employee list 
	@PutMapping("updateEmp/{id}")
	public Employee updateEmployee(@PathVariable("id") int id,
			@Valid @RequestBody Employee emp)
	{
		return empservice.updateEmployee(id, emp);
	}
	
	@PostMapping("/assignEmp/{empId}/toDept/{deptId}")
	public Employee assignEmpToDept(@PathVariable("empId") int empId, 
			@PathVariable("deptId") int deptId)
	{
		return empservice.assignEmpToDept(empId, deptId);
	}
	
}
