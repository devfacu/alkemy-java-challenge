package com.alkemy.challenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.GeneroDTO;
import com.alkemy.challenge.entity.Genero;

@Component
public class GeneroMapper {

	public Genero toEntity(GeneroDTO dto) {
		Genero genero = new Genero();
		genero.setImagen(dto.getImagen());
		genero.setNombre(dto.getNombre());
		return genero;
	}
	
	public GeneroDTO toDTO(Genero entity) {
		GeneroDTO dto = new GeneroDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setNombre(entity.getNombre());
		return dto;
	}
	
	public List<GeneroDTO> toDTOList(List<Genero> entities) {
		List<GeneroDTO> dtos = new ArrayList<>();
		for (Genero entity : entities) {
			dtos.add(this.toDTO(entity));
		}
		return dtos;
	}
	
	public void entityRefreshValues(Genero genero, GeneroDTO dto) {
		genero.setImagen(dto.getImagen());
		genero.setNombre(dto.getNombre());
	}
}
