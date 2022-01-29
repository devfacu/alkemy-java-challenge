package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String>, JpaSpecificationExecutor<Pelicula>{
	
	List<Pelicula> findAll(Specification<Pelicula> spec);
}
