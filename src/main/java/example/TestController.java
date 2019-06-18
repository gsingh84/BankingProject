package example;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import validation.Validate;

@RestController
public class TestController 
{
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("signin.jsp");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Validate isValid = new Validate();
		
		if (isValid.emailPassword(email, password))
		{
			try {
				modelView.addObject("invalidLogin", "");
				res.sendRedirect("/customerdash");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		modelView.addObject("param", req);
		modelView.addObject("invalidLogin", isValid.getErrors());
		
		return modelView;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest req, HttpServletResponse res)
	{	
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("signup.jsp");
		modelView.addObject("param", req);
		return modelView;
	}
	
	@RequestMapping("/customerdash")
	public ModelAndView customerUi()
	{
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("customer-ui.jsp");
		
		return modelView;
	}
}
