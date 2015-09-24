package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "login";
	}
}