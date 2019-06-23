package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bank.model.beans.Account;
import com.bank.model.beans.Address;
import com.bank.model.beans.PersonalInfo;
import com.bank.model.enums.AccountType;

@Repository
public class DbTemplate 
{
	@Autowired
	MySqlProperties props;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Insert customer information into the database
	 * 
	 * @param info customer's information
	 * @return last inserted id
	 */
	public int addCustomer(final PersonalInfo info)
	{
		final String sql = "insert into users(firstname, lastname, birthdate, email, password) values(?,?,?,?,?)";
		
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() 
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pStmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, info.getFirstName());
				pStmt.setString(2, info.getLastName());
				pStmt.setDate(3, info.getBirthDate());
				pStmt.setString(4, info.getEmail());
				pStmt.setString(5, info.getPassword());
				
				return pStmt;
			}
		}, holder);
		
		return holder.getKey().intValue();
	}
	
	/**
	 * Function for inserting customer address
	 * 
	 * @param customerId
	 * @param address
	 */
	public void insertAddress(int customerId, Address address) 
	{
		String sql = "insert into address(customer_id, street, city, state, zip) values(?,?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[] {customerId, address.getStreet(), 
				address.getCity(), address.getState(), address.getZip()});
	}
	
	/**
	 * Function for inserting customer account details: account number, pin, etc.
	 * 
	 * @param customerId
	 */
	public void insertAccountNum(int customerId, Account account)
	{
		String sql = "insert into accounts(customer_id, accountnumber) values(?,?)";
		jdbcTemplate.update(sql, new Object[] {customerId, account.getAccountNo()});
	}
	
	/**
	 * This function checks if user exist in the database or not
	 * 
	 * @param email
	 * @param password
	 * @return 0 if not exist otherwise value greater than 0
	 */
	public int getUser(String email, String password)
	{
		String sql = "select count(firstname) from users where email = ? AND password = ?";
		int userExist = jdbcTemplate.queryForObject(sql, new Object[] {email, password}, Integer.class);
		
		return userExist;
	}
	
	/**
	 * This function returns the user type CUSOMER, EMPLOYEE
	 *  
	 * @param email
	 * @return user type
	 */
	public AccountType getUserType(String email)
	{
		String sql = "select usertype from users where email = ?";
		String userType = jdbcTemplate.queryForObject(sql, new Object[] {email}, String.class);
		
		return AccountType.valueOf(userType);
	}
	
	/**
	 * This method checks if user email already exist
	 * 
	 * @param email
	 * @return 0 if not exist otherwise value greater than 0
	 */
	public int emailAlreadyExist(String email)
	{
		String sql = "select count(email) from users where email = ?";
		int userExist = jdbcTemplate.queryForObject(sql, new Object[] {email}, Integer.class);
		
		return userExist;
	}
	
	/**
	 * This method checks if user account number already exist
	 * 
	 * @param email
	 * @return 0 if not exist otherwise value greater than 0
	 */
	public int accountNumExist(int accNum)
	{
		String sql = "select count(accountnumber) from accounts where accountnumber = ?";
		int accExist = jdbcTemplate.queryForObject(sql, new Object[] {accNum}, Integer.class);
		
		return accExist;
	}
}
