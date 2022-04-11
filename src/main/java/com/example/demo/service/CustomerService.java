package com.example.demo.service;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer; 
import com.example.demo.exception.*;


@Service
public class CustomerService {

	private final CustomerDao customerDao;

	@Autowired
	public CustomerService(@Qualifier("SQLServer")CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void addCustomer(Customer customer){
		int result =customerDao.insertCustomer(customer);
		if (result != 1) {
            throw new IllegalStateException("something get wrong");
        }
		
	}
	
	public List<Customer> getAllCustomer() {
		return customerDao.selectAllCustomer();
	}
	
	public Customer selectCustomerById(int customerID)  {
		return customerDao.selectCustomerById(customerID)
                .orElseThrow(() -> new CantFoundException("cant found the customer"));
	}
	
	public void deleteCustomerById(int customerID) {
		Optional<Customer> customers = customerDao.selectCustomerById(customerID);
		customers.ifPresentOrElse(customer -> {
            int result = customerDao.deleteCustomerById(customerID);
            if (result != 1) {
                throw new IllegalStateException("can not delete customer");
            }
        }, () -> {
            throw new CantFoundException("cant found the customer");
        });
    }
	
	public void updataPersonByIdCustomer(int customerID, Customer newcustomer) {
		Optional<Customer> customers = customerDao.selectCustomerById(customerID);
		customers.ifPresentOrElse(customer -> {
            int result = customerDao.updataPersonByIdCustomer(customerID, newcustomer);
            if (result != 1) {
                throw new IllegalStateException("can not updata customer");
            }
        }, () -> {
            throw new CantFoundException("cant found the customer");
        });
	}
	
	
	
	
	

}
