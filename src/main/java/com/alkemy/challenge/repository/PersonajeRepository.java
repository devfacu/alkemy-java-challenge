package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.alkemy.challenge.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, String>, JpaSpecificationExecutor<Personaje>{

	List<Personaje> findAll(Specification<Personaje> spec);
}
