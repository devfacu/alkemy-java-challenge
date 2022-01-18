package com.alkemy.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.challenge.entity.AppUser;
import com.alkemy.challenge.repository.AppUserRepo;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepo appUserRepo;
	
	@Transactional
	public AppUser saveUser() {
		//Hacer validaciones de datos
		AppUser appUser = new AppUser();
		return appUserRepo.save(appUser);
	}
}
