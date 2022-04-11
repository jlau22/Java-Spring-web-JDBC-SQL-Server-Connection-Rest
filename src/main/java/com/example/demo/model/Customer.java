package com.example.demo.model;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Customer {
	
	@Id
	private final int customerID;
	private final String lastName;
	private final String firstName;
	private final int phone;
	private final String email;
	private final String password;
	
	public Customer(@JsonProperty("CustomerID") int customerID, 
			@JsonProperty("LastName") String lastName,
			@JsonProperty("FirstName") String firstName,
			@JsonProperty("Phone") int phone,
			@JsonProperty("Email") String email,
			@JsonProperty("Password") String password) {
		this.customerID = customerID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		
		
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
	

}
