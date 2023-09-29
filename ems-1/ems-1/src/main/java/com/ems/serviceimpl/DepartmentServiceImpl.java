package com.ems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exceptions.ResourceNotFoundException;
import com.ems.model.Department;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
    private DepartmentRepository departmentRepository;

	@Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

	@Override
    public Department getDepartmentById(int deptId) {
        return departmentRepository.findById(deptId).orElseThrow(()->
        new ResourceNotFoundException("Department", "id", deptId));
    }

	@Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

	@Override
    public Department updateDepartment(int deptId, Department updatedDepartment) {
    	Department existingDepartment = departmentRepository.findById(deptId).orElseThrow(()->
        new ResourceNotFoundException("Department", "id", deptId));
       
    	existingDepartment.setDeptName(updatedDepartment.getDeptName());
    	existingDepartment.setTotalNoOfEmployees(updatedDepartment.getTotalNoOfEmployees());
    	
    	departmentRepository.save(existingDepartment);
    	
    	return existingDepartment;
    }

	@Override
    public void deleteDepartment(int deptId) {
		
		departmentRepository.findById(deptId).orElseThrow(()->
        new ResourceNotFoundException("Department", "id", deptId));
		
        departmentRepository.deleteById(deptId);
    }
}
