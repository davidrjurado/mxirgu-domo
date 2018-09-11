package com.mxirgu.domo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/login")
	public String login(User user, Model model) {

		logger.debug("redirect to home page");
		user = userService.getUserById(Integer.valueOf(0));
		model.addAttribute("user", user.getName());
		return "home";
	}

}
