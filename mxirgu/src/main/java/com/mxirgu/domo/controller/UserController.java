package com.mxirgu.domo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.User_;
import com.mxirgu.domo.bean.list.ListCriteria;
import com.mxirgu.domo.bean.list.ListSort;
import com.mxirgu.domo.interfaces.UserServiceInt;

@Controller
@Scope("request")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceInt userService;
	@Autowired
	private ListCriteria listConfiguration;

	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public String userList(Model model) {
		
		listConfiguration.setSortBy(User_.ID);
		listConfiguration.setSortDirection(ListSort.ASC.getValue());
		
		model.addAttribute(listConfiguration);
		model.addAttribute("listUsers", this.userService.listUsers(listConfiguration));
		return "user/listUser";
	}
	
	@RequestMapping(value = "/listUser", method = RequestMethod.POST)
	public String userList(Model model, @ModelAttribute("listConfiguration") ListCriteria listConfiguration) {
		
		model.addAttribute("listUsers", this.userService.listUsers(listConfiguration));
		return "user/listUser";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView mv = new ModelAndView("user/editUser", "user", new User());
		return mv;
	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id) {
		User user = userService.getUserById(new Integer(id));
		ModelAndView mv = new ModelAndView("user/editUser", "user", user);
		return mv;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User u) {

		if (u.getId() == null) {
			this.userService.addUser(u);
		} else {
			this.userService.updateUser(u);
		}

		return "redirect:/listUser";
	}

	@RequestMapping("/removeUser/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.userService.removeUser(id);
		return "redirect:/listUser";
	}

}
