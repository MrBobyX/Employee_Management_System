package com.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// custom method to fetch employee details using employee email
	Optional<Employee> findByEmail(String email);
	
	//  custom method to fetch employee details  using employee first name  
	List<Employee> findByFirstName(String firstName);
	
	// custom method to fetch employee details  using employee designation
	List<Employee> findByDesignation(String designation);
	
	// custom method to fetch employee details using employee department
	@Query("from Employee where dept=(from Department where deptName=:e)")
	List<Employee> findByDepartmentName(@Param("e") String deptName);
}
