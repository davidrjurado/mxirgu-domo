package com.mxirgu.domo.interfaces;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.list.ListCriteria;
import com.mxirgu.domo.bean.list.ListData;

@Service
public interface UserServiceInt {

	public void addUser(User u);

	public void updateUser(User u);

	public ListData listUsers(ListCriteria listConfiguration);

	public User getUserById(Integer id);
	
	public User getUserByLogin(String login);

	public void removeUser(Integer id);
	
	public ArrayList<Pair<String, String>> getValuesByColumn(String column);

}
