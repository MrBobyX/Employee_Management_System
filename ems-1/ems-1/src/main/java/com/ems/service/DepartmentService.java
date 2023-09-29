package com.ems.service;

import com.ems.model.Department;

import java.util.List;


public interface DepartmentService {

	List<Department> getAllDepartments();
	
	Department getDepartmentById(int deptId) ;
	
	Department createDepartment(Department department);
	
	Department updateDepartment(int deptId, Department updatedDepartment);
	
	void deleteDepartment(int deptId);
	
}
