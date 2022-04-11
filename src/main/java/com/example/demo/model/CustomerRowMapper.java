package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(rs.getInt("CustomerID"), rs.getString("LastName"), rs.getString("FirstName"), rs.getInt("Phone"), rs.getString("Email"),rs.getString("Password"));
	}
	
	
	

}
