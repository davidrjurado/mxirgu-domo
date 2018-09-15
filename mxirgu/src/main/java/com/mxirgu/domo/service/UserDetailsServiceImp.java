package com.mxirgu.domo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.dao.UserDAO;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User userInfo = userDAO.getUserByLogin(username);
		System.out.println("UserInfo= " + userInfo);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
		grantList.add(authority);

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				userInfo.getLogin(), userInfo.getPassword(), grantList);

		return userDetails;
	}

}
