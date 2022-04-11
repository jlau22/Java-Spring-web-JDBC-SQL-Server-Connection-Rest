package com.example.demo.dao;

import java.util.List;



import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerRowMapper;

@Repository("SQLServer")
public class CustomerAccessService implements CustomerDao {
	
	
	private final JdbcTemplate jdbcTemp;
	
	
	public CustomerAccessService(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	
	@Override
	public int insertCustomer(Customer customer) {
		String sql = "INSERT INTO Customers (LastName,FirstName,Phone,Email,Password) VALUES (?,?,?,?,?)";
		return jdbcTemp.update(
				sql,
				customer.getLastName(),customer.getFirstName(),customer.getPhone(),customer.getEmail(),customer.getPassword());
	}
	
	@Override
	public List<Customer> selectAllCustomer() {
		String sql = "SELECT CustomerID,LastName,FirstName,Phone,Email,Password FROM Customers";
		List<Customer> customers = jdbcTemp.query(sql, new CustomerRowMapper());
		return customers;
	}
	
	@Override
	public Optional<Customer> selectCustomerById(int customerID) {
		String sql = "SELECT CustomerID,LastName,FirstName,Phone,Email,Password FROM Customers Where CustomerID=?";
		return jdbcTemp.query(sql, new CustomerRowMapper(),customerID)
				.stream()
				.findFirst();
	}
	@Override
	public int deleteCustomerById(int customerID) {
		String sql = "DELETE FROM Customers  Where CustomerID = ?";
		return jdbcTemp.update(sql,customerID);

	}
	@Override
	public int updataPersonByIdCustomer(int customerID, Customer customer) {
		String sql = "UPDATE Customers SET LastName=?,FirstName=?,Phone=?,Email=?,Password=? Where CustomerID = ?";
		return jdbcTemp.update(
				sql,
				customer.getLastName(),customer.getFirstName(),customer.getPhone(),customer.getEmail(),customer.getPassword(),customerID);
	}
	
	
	
	
	
	
	

}
