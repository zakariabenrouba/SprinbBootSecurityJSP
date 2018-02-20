package SprinbBootSecurityJSP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		
	@RequestMapping(value="/admin/home")
	public String homeadmin() 
	{
		return "Admin";
	}
	
	@RequestMapping(value="/user/home")
	public String homeuser() 
	{
		return "user";
	}
	
	
	@GetMapping("/login")
	public String login(Model model,String error,String logout) 
	{
		if(error !=null) 
		{
			model.addAttribute("error", "Your username or password is invalid");
		}
		if(logout!=null) 
		{
			model.addAttribute("message", "You have been logged out successfully");
		}
		return "login";
	}
}
