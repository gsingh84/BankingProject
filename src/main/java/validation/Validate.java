package validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bank.model.HandleAccounts;

public class Validate 
{	
	private Map<String, String> errors;
	
	public Validate()
	{
		errors = new HashMap<>();
	}
	
	public boolean emailPassword(String email, String password)
	{
		if (email == null)
		{
			return false;
		}
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
			
		HandleAccounts accounts = new HandleAccounts();
		
		if (!matcher.matches() || password.isEmpty())
		{
			errors.put("loginError", "Invalid email or password!");
			return false;
		}
		else if (!accounts.login(email, password)) 
		{
			errors.put("loginError", "Invalid email or password!");
			return false;
		}
		
		return accounts.login(email, password);
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}
}
