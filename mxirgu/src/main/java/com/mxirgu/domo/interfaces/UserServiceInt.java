package com.mxirgu.domo.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.list.ListCriteria;

@Service
public interface UserServiceInt {

	public void addUser(User u);

	public void updateUser(User u);

	public List<User> listUsers(ListCriteria listConfiguration);

	public User getUserById(Integer id);
	
	public User getUserByLogin(String login);

	public void removeUser(Integer id);

}
