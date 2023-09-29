
	package com.ems.model;

	import javax.persistence.*;
	import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

	@Entity
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class Department {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int deptId;

	    @NotBlank(message = "Department Name is required")
	    @Column(length=25, nullable=false, unique = true)
	    private String deptName;

	    @Column
	    private int totalNoOfEmployees;

	    @OneToMany
	    private List<Employee> employees;

	  
	}



