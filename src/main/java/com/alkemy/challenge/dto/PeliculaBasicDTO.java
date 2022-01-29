package com.alkemy.challenge.dto;

import java.time.LocalDate;

public class PeliculaBasicDTO {

	private String id;
	private String imagen;
	private String titulo;
	private LocalDate fechaCreacion;
	
	//Contructor
	public PeliculaBasicDTO() {
	}
	
	
	//Getters & Setters
	public String getImagen() {
		return imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
