package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.Genero;

@Repository
public interface GeneroRepo extends JpaRepository<Genero, String>{

}
