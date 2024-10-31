package com.todo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authService;
	
	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String welcomePage(@RequestParam String username, @RequestParam String pass, ModelMap map) {
		if(authService.authenticate(username, pass)) {
			map.put("name", username);
			return "welcome";
		}
		map.put("error", "Invalid credentials! Please enter correct username or password.");
		return "login";
		
	}
	
}
