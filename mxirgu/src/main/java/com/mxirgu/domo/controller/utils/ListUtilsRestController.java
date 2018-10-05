package com.mxirgu.domo.controller.utils;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.interfaces.UserServiceInt;

@RestController
public class ListUtilsRestController {
	@Autowired
	private UserServiceInt userService;

	@RequestMapping(value = "/getFilterValues", method = RequestMethod.GET)
	public ArrayList<Pair<String, String>> getFilterValues(@RequestParam(value = "entity") String entity,
			@RequestParam(value = "column") String column) {

		ArrayList<Pair<String, String>> filtereableList = null;
			
		if (User.class.getName().equalsIgnoreCase(entity)) {
			filtereableList = userService.getValuesByColumn(column);
		}

		return filtereableList;
	}
}
