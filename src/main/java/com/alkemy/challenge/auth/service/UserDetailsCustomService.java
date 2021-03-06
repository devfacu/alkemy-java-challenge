package com.alkemy.challenge.auth.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.auth.dto.UserDTO;
import com.alkemy.challenge.auth.entity.AppUser;
import com.alkemy.challenge.auth.repository.AppUserRepository;

@Service
public class UserDetailsCustomService implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//Falta EmailService
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByUsername(username);
		
		if (appUser == null) {
			throw new UsernameNotFoundException("Username or Password not found.");
		}
		return new User(appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
	}
	
	public boolean save(UserDTO userDTO) {
		AppUser appUser = new AppUser();
		appUser.setUsername(userDTO.getUsername());
		//Password Encoding
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		appUser.setPassword(encodedPassword);
		appUser = this.appUserRepository.save(appUser);
		
		return appUser != null;
	}
	
}
