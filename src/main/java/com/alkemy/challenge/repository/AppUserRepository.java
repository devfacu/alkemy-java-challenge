package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String>{

	@Query("SELECT c FROM AppUser c WHERE c.username = :username")
	public AppUser findByUsername(@Param("username")String username);
}
