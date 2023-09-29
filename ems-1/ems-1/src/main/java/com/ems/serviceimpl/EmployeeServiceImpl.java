package com.ems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exceptions.ResourceNotFoundException;
import com.ems.model.Department;
import com.ems.model.Employee;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	DepartmentRepository deptRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		empRepository.save(employee);
		return employee;
	}

	@Override
	public String removeEmployee(int id) {
		
		Employee emp = empRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "id", id));
		
		if(emp!=null)
		{
		 empRepository.deleteById(id);
		}
		return "Employee details deleted successfully!!";
	}

	@Override
	public Employee findEmpById(int id) {
		Employee emp = empRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "id", id));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {	
		return empRepository.findAll();
	}
	
	

	@Override
	public Employee updateEmployee(int id, Employee emp) {
		Employee exist = empRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "id", id));
		
		
		exist.setFirstName(emp.getFirstName());
		exist.setLastName(emp.getLastName());
		exist.setEmail(emp.getEmail());
		exist.setContact(emp.getContact());
		exist.setAge(emp.getAge());
		exist.setSalary(emp.getSalary());
		exist.setDesignation(emp.getDesignation());		
		empRepository.save(exist);
		
		return exist;
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		
		return empRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation) {
		return empRepository.findByDesignation(designation);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		Employee emp = empRepository.findByEmail(email).orElseThrow(()->
		new ResourceNotFoundException("Employee", "email", email));
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByDepartment(String department) {
		
		return empRepository.findByDepartmentName(department);
		
		
	}

	@Override
	public Employee assignEmpToDept(int empId, int deptId) {
		 Employee emp = empRepository.findById(empId).orElseThrow(()->
			new ResourceNotFoundException("Employee", "id", empId));
		 
		 Department dept =deptRepository.findById(deptId).orElseThrow(()->
			new ResourceNotFoundException("Department", "id", deptId));
		 
		 emp.setDept(dept);
		 dept.setTotalNoOfEmployees(dept.getTotalNoOfEmployees()+1);
		 
		 empRepository.save(emp);
		 
		 deptRepository.save(dept);
		 
		 
		return emp;
	}

	
	
	

}
