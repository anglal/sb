package com.secureapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	private final String LOGINPAGE = "login";
	private final String INDEX = "index";
	private final String LOFINFAILED = "failedLogin";
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
	
	
//	@GetMapping("/login")
//	public String login() {
//		return "WEB-INF/loginPage.jsp";
////		System.out.println("Hello");
//		
//	}
	
	
//	@PostMapping("/doLogin")
//	public String loginProcessor() {
//		System.out.println("Processing");
//		return null;
//	}
	
}
