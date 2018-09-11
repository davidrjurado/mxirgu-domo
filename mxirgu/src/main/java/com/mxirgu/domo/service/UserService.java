package com.mxirgu.domo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.dao.UserDAO;
import com.mxirgu.domo.interfaces.UserServiceInt;

@Service
@ComponentScan(basePackages = { "com.mxirgu.domo" })
public class UserService implements UserServiceInt {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(Integer id) {
		return this.userDAO.getUserById(id);
	}
	
	@Override
	@Transactional
	public User getUserByLogin(String login) {
		return this.userDAO.getUserByLogin(login);
	}
	
	@Override
	@Transactional
	public void removeUser(Integer id) {
		this.userDAO.removeUser(id);
	}

}
