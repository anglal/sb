package com.secureapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	private final String LOGINPAGE = "login";
	private final String INDEX = "index";
	private final String LOFINFAILED = "failedLogin";
	private final String ALLUSERS = "showAllUsers";
	private final String ACCESSDENIED = "accessDenied";
	
	@GetMapping("/login")
	public String showLogin() {
		return LOGINPAGE;
	}
	@GetMapping({"/","/index"})
	public String homePage() {
		//return "static/index.jsp";
		return INDEX;
	}
	
	@GetMapping("/loginFailed")
	public String failedLogin(){
		return LOFINFAILED;
	}
	
	@GetMapping("/users")
	public String showAllUsers() {
		return ALLUSERS;
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return ACCESSDENIED;
	}
	
}
