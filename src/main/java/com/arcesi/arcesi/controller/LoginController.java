package com.arcesi.arcesi.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arcesi.arcesi.model.User;
import com.arcesi.arcesi.utils.IWordHashGenerator;
import com.arcesi.arcesi.utils.WordHashGenerator;

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
	private static final String HASH_ALGORITHM = "SHA-256";
	private static final String ERROR_MESSAGE = "Identifiants non valides";
	private static final User USER_IDENTIFICATION = new User("Arcesi", "f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9");
	
	@RequestMapping(value = {"/", "/" + INDEX, "/" + LOGIN}, method = RequestMethod.GET)
	public String goToLoginPage(Model model) {
		model.addAttribute("user", new User());
		return LOGIN;
	}
	
	@RequestMapping(value = "/" + VERIFY_LOGIN, method = RequestMethod.GET)
	public String verifyLogin(Model model) {
		model.addAttribute("user", new User());
		return LOGIN;
	}
	
	@RequestMapping(value = "/" + VERIFY_LOGIN, method = RequestMethod.POST)
	public String verifyLogin(Model model, @ModelAttribute User user) {
		IWordHashGenerator iwhg = new WordHashGenerator();
		try {
			if (iwhg.generateHash(user.getPassword(), HASH_ALGORITHM).equals(USER_IDENTIFICATION.getPassword()) && user.getUserName().equals(USER_IDENTIFICATION.getUserName())) {
				return "personList";
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		model.addAttribute("errorMessage", ERROR_MESSAGE);
		return LOGIN;
	}
}