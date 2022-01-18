package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.Pelicula;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, String>{

}
