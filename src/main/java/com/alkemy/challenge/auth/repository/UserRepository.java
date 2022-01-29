package com.alkemy.challenge.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.challenge.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, String>{
	
	AppUser findByUsername(String username);
}
