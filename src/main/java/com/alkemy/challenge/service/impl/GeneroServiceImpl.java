package com.alkemy.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.dto.GeneroDTO;
import com.alkemy.challenge.entity.Genero;
import com.alkemy.challenge.mapper.GeneroMapper;
import com.alkemy.challenge.repository.GeneroRepository;
import com.alkemy.challenge.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroRepository generoRepo;
	
	@Autowired
	private GeneroMapper generoMapper;

	
	public GeneroDTO save(GeneroDTO dto) {
		Genero genero = generoMapper.toEntity(dto);
		Genero generoSaved = generoRepo.save(genero);
		GeneroDTO result = generoMapper.toDTO(generoSaved);
		return result;
	}

	public GeneroDTO update(GeneroDTO dto) {
		Genero genero = this.generoRepo.getById(dto.getId());
		this.generoMapper.entityRefreshValues(genero, dto);
		this.generoRepo.save(genero);
		return dto;
	}

	public List<GeneroDTO> getAll() {
		List<Genero> entities = generoRepo.findAll();
		return generoMapper.toDTOList(entities);
	}

	public void delete(String id) {
		this.generoRepo.deleteById(id);
	}

	@Override
	public GeneroDTO getById(String id) {
		Genero genero = generoRepo.getById(id);
		GeneroDTO dto = generoMapper.toDTO(genero);
		return dto;
	}
	
	
}
