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
		if (email == null || password == null)
		{
			return false;
		}
		
		if (!isValidEmail(email) || password.isEmpty())
		{
			errors.put("loginError", "Invalid email or password!");
			return false;
		}
		
		return true;
	}
	
	private boolean isValidEmail(String email)
	{
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}
}
