package com.arcesi.arcesi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arcesi.arcesi.model.User;
import com.arcesi.arcesi.service.UserManager;

/**
 * @author Frédéric Thébault
 * @version 1.0
 */
@Controller
public class LoginController {
	
//	@Autowired
//	private UserManager um;
	
//	// Injectez (inject) via application.properties.
//	@Value("${welcome.message}")
//	private String message;
//	
//	@Value("${error.message}")
//	private String errorMessage;
	
	private static final String INDEX = "index";
	private static final String LOGIN = "login";
	private static final String VERIFY_LOGIN = "verifyLogin";
	
	@RequestMapping(value = {"/", "/" + INDEX, "/" + LOGIN}, method = RequestMethod.GET)
	public String goToLoginPage(Model model) {
//		model.addAttribute("user", um.saveAndFlush(new User("John", "azerty")));
		model.addAttribute("user", new User("John", "azerty"));
		return LOGIN;
	}
	
	@RequestMapping(value = "/" + VERIFY_LOGIN, method = RequestMethod.POST)
	public String verifyLogin(Model model, @ModelAttribute User user) {
//		User userFromDB = um.findOneByUserName(user.getUserName());
//		System.out.println("--------------------- " + userFromDB.getPassword());
//		model.addAttribute("user", new User(userFromDB.getPassword(), userFromDB.getPassword()));
		model.addAttribute("user", new User("Jack", "ytreza"));
		return LOGIN;
	}
}