package com.alkemy.challenge.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.auth.entity.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String>{

	AppUser findByUsername(String username);
}
