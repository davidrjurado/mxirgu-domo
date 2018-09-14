package com.mxirgu.domo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.interfaces.UserServiceInt;

@Controller
@Scope("request")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private User user;
	
	@Autowired(required = true)
	private UserServiceInt userService;

	@RequestMapping(value = "/ini")
	public String ini() {
		logger.debug("Redirect to login page");
		return "login";
	}

	@RequestMapping(value="/authenticate")
	public String home(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", userService.getUserByLogin(authentication.getName()));
 		return "home";
 	}
	
	@RequestMapping(value="/error")
	public String error() {
 		return "access-denied";
 	}
}
