package com.alkemy.challenge.auth.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alkemy.challenge.auth.repository.UserRepository;
import com.alkemy.challenge.entity.AppUser;

public class UserDetailsCustomService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	//Falta EmailService
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = userRepository.findByUsername(username);
		
		if (appUser == null) {
			throw new UsernameNotFoundException("Username or Password not found.");
		}
		return new User(appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
	}
	
	
	
}
