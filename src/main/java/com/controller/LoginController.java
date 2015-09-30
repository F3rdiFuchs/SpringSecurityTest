package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.TestService;

@Controller
public class LoginController {
	private final TestService testService;
	
	@Autowired
	public LoginController(TestService testService)
	{
		this.testService = testService;
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value ="/Access_Denied", method = RequestMethod.GET)
	public String showAccesDenied(ModelMap model) {
		return "accessdenied";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {    
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
		return "redirect:/login?logout";
	}
}