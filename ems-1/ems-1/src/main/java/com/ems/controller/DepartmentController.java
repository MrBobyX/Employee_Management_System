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

import com.ems.model.Department;
import com.ems.model.Employee;
import com.ems.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@PostMapping("/addDept")
	public ResponseEntity<Department> addDept(@Valid @RequestBody Department department){
		Department dept = deptService.createDepartment(department);
		return new ResponseEntity<Department>(dept, HttpStatus.CREATED);
		
	}
	//Method to delete departments 
	@DeleteMapping("/removeDept/{id}")
	public ResponseEntity<String> removeDepartment(@PathVariable("id") int id ){
		deptService.deleteDepartment(id);
		
		return new ResponseEntity<String> ("Removed Succesfully", HttpStatus.OK);
	}
	//Method to find department by id 
	@GetMapping("/findDept/{id}")
	public ResponseEntity<Department> findEmployeeById(@PathVariable("id") int id){
		Department dept = deptService.getDepartmentById(id);
		
		
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
		
	}
	//Method to get all department list
	@GetMapping("/allDepts")
	public ResponseEntity<List<Department>> listOfEmployee(){
		
		List<Department> depts = deptService.getAllDepartments();
		
		return new ResponseEntity<List<Department>>(depts, HttpStatus.OK);
		
	}
	
	//MEthod to Update employee in existing department list 
	@PutMapping("updateDept/{id}")
	public Department updateDept(@PathVariable("id") int id,
			@Valid @RequestBody Department dept)
	{
		return deptService.updateDepartment(id, dept);
	}
	
}
