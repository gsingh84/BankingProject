package com.bank;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.DbTemplate;
import com.bank.model.Bank;
import com.bank.model.beans.Address;
import com.bank.model.beans.PersonalInfo;
import com.bank.model.enums.AccountType;

import validation.Validate;

@RestController
public class TestController 
{	
	@Autowired
	Bank bank;
	
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("signin");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Map<String, String[]> paramMap = req.getParameterMap();
		
		if (paramMap.containsKey("submit"))
		{
			if (bank.login(email, password) > 0)
			{
				try {
					modelView.addObject("invalidLogin", "");
					
					if (bank.getUserType(email).equals(AccountType.EMPLOYEE))
						res.sendRedirect("/customerdash");
					else 
						res.sendRedirect("/");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}
		
		modelView.addObject("param", req);
		modelView.addObject("invalidLogin", bank.errors());
		
		return modelView;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest req, HttpServletResponse res)
	{	
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("signup");
		
		Map<String, String[]> paramMap = req.getParameterMap();
		
		if (paramMap.containsKey("submit"))
		{	
			PersonalInfo info = new PersonalInfo(req.getParameter("firstname"), req.getParameter("lastname"),
					req.getParameter("email"), Bank.convertDate(req.getParameter("birthdate")));
			info.setPassword(Bank.encrypt(req.getParameter("password")));
			
			Address address = new Address(req.getParameter("street"), req.getParameter("city"),
					req.getParameter("state"), req.getParameter("zip"));
			
			bank.createCustomer(info, address);
		}
		
		modelView.addObject("param", req);
		
		return modelView;
	}
	
	@RequestMapping("/results")
	public String getResult()
	{
		return bank.login("sam@gmail.com", null) + "";
	}
	
	@RequestMapping("/customerdash")
	public ModelAndView customerUi()
	{
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("customer-ui");
		
		return modelView;
	}
}
