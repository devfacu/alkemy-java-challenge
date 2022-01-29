package com.alkemy.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.entity.AppUser;
import com.alkemy.challenge.repository.AppUserRepository;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional
	public AppUser saveUser() {
		//Hacer validaciones de datos
		AppUser appUser = new AppUser();
		return appUserRepository.save(appUser);
	}
}
