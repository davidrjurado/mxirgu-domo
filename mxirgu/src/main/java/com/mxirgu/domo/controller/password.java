package com.mxirgu.domo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {

  public static void main(String[] args) {

	int i = 0;
	while (i < 10) {
		String password = "1";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		i++;
	}
  }
  }