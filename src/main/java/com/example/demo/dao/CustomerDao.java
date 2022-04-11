package com.example.demo.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Customer;

public interface CustomerDao  {
	
	

	int insertCustomer(Customer customer);
	List<Customer> selectAllCustomer();
	Optional<Customer> selectCustomerById(int customerID);
	int deleteCustomerById(int customerID);
	int updataPersonByIdCustomer(int customerID, Customer customer);

}
