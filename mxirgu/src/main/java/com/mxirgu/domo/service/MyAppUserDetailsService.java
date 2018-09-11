package com.mxirgu.domo.service;

import java.util.Arrays;

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
@ComponentScan(basePackages = { "com.mxirgu.domo" })
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			        throws UsernameNotFoundException {
		
		User user = userDAO.getUserByLogin(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		UserDetails userDetails = (UserDetails)new  org.springframework.security.core.userdetails.User(user.getLogin(),
				user.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
} 
