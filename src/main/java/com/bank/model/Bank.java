package com.bank.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.dao.DbTemplate;
import com.bank.model.beans.Account;
import com.bank.model.beans.Address;
import com.bank.model.beans.PersonalInfo;
import com.bank.model.enums.AccountType;

import validation.Validate;

@Repository
public class Bank 
{
	@Autowired 
	DbTemplate database;
	
	private Validate isValid;
	
	public Bank()
	{
		isValid = new Validate();
	}
	
	public void createCustomer(PersonalInfo info, Address address)
	{	
		int lastInsertedId = database.addCustomer(info);
		database.insertAddress(lastInsertedId, address);
		
		int accNum = Account.generateAccount(10);
		while (database.accountNumExist(accNum) != 0)
		{
			accNum = Account.generateAccount(10);
		}
		
		database.insertAccountNum(lastInsertedId, new Account(accNum));
	}
	
	public int login(String email, String password)
	{
		if (!isValid.emailPassword(email, password))
		{
			return 0;
		}
		
		if (database.getUser(email, encrypt(password)) == 0)
		{
			errors().put("loginError", "Invalid email or password!");
			return 0;
		}
		
		return 1;
	}
	
	public AccountType getUserType(String email)
	{
		return database.getUserType(email);
	}
	
	public Map<String, String> errors()
	{
		return isValid.getErrors();
	}
	
	public static java.sql.Date convertDate(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date sqlDate = null;

        try
        {
            Date birthDate = format.parse(date);
            sqlDate = new java.sql.Date(birthDate.getTime());

        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return sqlDate;
    }
	
	public static String encrypt(String password)
    {
        String sha1 = "";

        if (!password.isEmpty())
        {
            try
            {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                digest.reset();
                digest.update(password.getBytes("utf8"));
                sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }

        return sha1;
    }
}
