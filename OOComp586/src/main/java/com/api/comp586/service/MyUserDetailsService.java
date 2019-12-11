package com.api.comp586.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//return new User("employee_01","{noop}employee_01", new ArrayList<>());
		if(username.equals("employee_01")) {
			return new User("employee_01","{noop}employee_01", new ArrayList<>());
		}else if(username.equals("employee_02")) {
			return new User("employee_02","{noop}employee_02", new ArrayList<>());
		}
			return new User("foo","{noop}foo", new ArrayList<>());
		
	}
}
