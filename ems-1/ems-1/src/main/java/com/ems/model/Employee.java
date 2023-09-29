package com.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
 
	
	// This method is used to provide a unique id which is auto generted 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// This method is used to provide first name and it should  be required and minimum length is >= 2 characters and maximum characters is less then 25  
	@NotNull(message="First Name is required")
	@Size(max=25, message="Max. 25 characters allowed")
	@Size(min=2, message="Min. 2 characters required")
	@NotBlank(message="Enter valid first name")
	@Column(length = 25, nullable = false)
	private String firstName;
	
	// This method is used to provide last name and it should be required and minimum length is >= 2 characters and maximum characters is less then 25 
	@NotNull(message="Last Name is required")
	@Size(max=25, message="Max. 25 characters allowed")
	@Size(min=2, message="Min. 2 characters required")
	@NotBlank(message="Enter valid last name")
	@Column(length = 25)
	private String lastName;
	
	//  This method is used to fetch email address which is required  and maximum length is 50 characters and it should be unique
	@NotNull(message="Email is required")
	@Size(max=50, message="Max. 50 characters allowed")
	@Email(message="Invalid email")
	@Column(nullable = false, unique = true, length=50)
	private String email;
	
	// This method is used to fetch contact number of employee which is require and it should be follow some validation like first number should starts from 6789 and number should be 0-9 and maximum length of it should be 10 numbers  
	@NotNull(message="Contact is required")
	@Size(min=10, max=10, message="10 characters required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message="Invalid contact details")
	@Column(nullable = false, unique = true, length=10)
	private String contact;
	
	//  This method is used to get age 
	@Column(nullable = false)
	private int age;
	
	// This method  is used to get salary information of  employee
	private double salary;
	
	// This method  is used to get state information of employee
	@NotNull(message="State is required")
	@Size(max=25, message="Max. 25 characters allowed")
	@Size(min=2, message="Min. 2 characters required")
	@NotBlank(message="Enter valid state")
	@Column(length = 25, nullable = false)
	private String state;
	
	// This method is used to get  designation of employee
	@NotNull(message="Designation is required")
	@Size(max=25, message="Max. 25 characters allowed")
	@Size(min=2, message="Min. 2 characters required")
	@NotBlank(message="Enter valid designation")
	@Column(length = 25, nullable = false)
	private String designation;
	
	
	@ManyToOne
	private Department dept;
	
	
}
