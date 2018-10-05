package com.mxirgu.domo.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.list.ListCell;
import com.mxirgu.domo.bean.list.ListCriteria;

@Service
public interface UserServiceInt {

	public void addUser(User u);

	public void updateUser(User u);

	public ArrayList<ArrayList<ListCell>> listUsers(ListCriteria listConfiguration);

	public User getUserById(Integer id);
	
	public User getUserByLogin(String login);

	public void removeUser(Integer id);
	
	public ArrayList<Pair<String, String>> getValuesByColumn(String column);

}
