package com.alkemy.challenge.dto;

import java.util.List;

public class PersonajeDTO {
	
	private String id;
	private String imagen;
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	private List<PeliculaDTO> peliculas;
	
	public PersonajeDTO(){
	}

	public String getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getPeso() {
		return peso;
	}

	public String getHistoria() {
		return historia;
	}

	public List<PeliculaDTO> getPeliculas() {
		return peliculas;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public void setPeliculas(List<PeliculaDTO> peliculas) {
		this.peliculas = peliculas;
	}

}
