package com.arcesi.arcesi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Frédéric Thébault
 * @version 1.0
 */
@Controller
public class LoginController {
	
	private static final String LOGIN = "login2";
	
	@RequestMapping(path = "/" + LOGIN, method = RequestMethod.GET)
	public ModelAndView goToLoginPage(ModelMap modelMap) {
		return new ModelAndView("/../templates/html/login.html");
	}
}