package com.arcesi.arcesi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arcesi.arcesi.service.UserManager;

/**
 * @author Frédéric Thébault
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserManager um;
	
	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;
	
	@Value("${error.message}")
	private String errorMessage;
	
	private static final String INDEX = "index";
	private static final String LOGIN = "login";
	
	@RequestMapping(value = {"/", "/" + INDEX, "/" + LOGIN}, method = RequestMethod.GET)
	public String goToLoginPage(Model model) {
		return LOGIN;
	}
}