package com.alkemy.challenge.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@SQLDelete(sql="UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause="deleted = false")
@Entity
public class Personaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String imagen;
	@Column(unique = true)
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	
	//Soft-delete Implementation
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(mappedBy="personajes", cascade=CascadeType.ALL)
	private List<Pelicula> peliculas = new ArrayList<>();
	
	
	public Personaje() {
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

	public void setImagen(String string) {
		this.imagen = string;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public List<Pelicula> getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	//Add and remove peliculas.
	public void addPelicula(Pelicula pelicula) {this.peliculas.add(pelicula);}
	
	public void removePelicula(Pelicula pelicula) {this.peliculas.remove(pelicula);}
	
}
