package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContentController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showAdminPage(ModelMap model) {
		return "admin";
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showDataPage(ModelMap model) {
		return "data";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(ModelMap model) {
		return "hello";
	}
}
