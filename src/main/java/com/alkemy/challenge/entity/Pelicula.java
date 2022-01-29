package com.alkemy.challenge.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@SQLDelete(sql="UPDATE pelicula SET deleted = true WHERE id=?")
@Where(clause="deleted = false")
@Entity
public class Pelicula implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String imagen;
	@Column(unique = true)
	private String titulo;
	@Column(name="fecha_creacion")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate fechaCreacion;
	private Integer calificacion;
	
	//Soft-delete Implementation
	private boolean deleted = Boolean.FALSE;
	
	//This is only used to retrieve information
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="genero_id", insertable = false, updatable = false)
	private Genero genero;
	
	//This is used for almost everything
	@Column(name = "genero_id", nullable = false)
	private String generoId;

	@ManyToMany(cascade= {
			CascadeType.MERGE,
			CascadeType.PERSIST
	})
	@JoinTable(name="pelicula_personaje",
	joinColumns=@JoinColumn(name="pelicula_id"),
	inverseJoinColumns=@JoinColumn(name="personaje_id"))
	private List<Personaje> personajes = new ArrayList<>();
	
	
	public Pelicula() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public String getGeneroId() {
		return generoId;
	}

	public void setGeneroId(String generoId) {
		this.generoId = generoId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
