package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RequestMapping("api/v1/customer")

@RestController

public class CustomerController {
	private final CustomerService  customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public void addPerson(@Validated @NonNull @RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping(path = "{CustomerID}")
	public Customer getCustomer(@PathVariable("CustomerID") int CustomerID) {
		return customerService.selectCustomerById(CustomerID);
	}
	
	@DeleteMapping(path = "{CustomerID}")
	public void deleteCustomerById(@PathVariable("CustomerID") int CustomerID) {
		customerService.deleteCustomerById(CustomerID);
	}
	
	@PutMapping(path = "{CustomerID}")
	public void updateCustomer(@PathVariable("CustomerID") int CustomerID,@Validated @NonNull @RequestBody Customer customerToUpdate) {
		customerService.updataPersonByIdCustomer(CustomerID, customerToUpdate);
	}
	
	
	
	
	

}
