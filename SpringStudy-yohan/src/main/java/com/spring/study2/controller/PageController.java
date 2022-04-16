package com.spring.study2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value = "/index3", method = RequestMethod.GET)
	public String indexForm() {
		
		return "index3/index3";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinForm() {
		
		return "auth3/signin";
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		
		return "auth3/signup";
	}
	 
}
