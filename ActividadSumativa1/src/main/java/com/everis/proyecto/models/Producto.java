package com.everis.proyecto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representacion de entidad modelo
@Table(name="productos")
public class Producto {
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para auto incrementar
	private Long id;
	
	private String nombre;
	private Integer precio;
	private String caracteristicas;
	
	//Relacion 1 a n (Producto)
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="usuario_id")
		private Usuario usuario;
	
		
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, Integer precio, String caracteristicas) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristicas = caracteristicas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getcaracteristicas() {
		return caracteristicas;
	}

	public void setCAracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@PrePersist //se ejecuta antes de que sea insertado el objeto
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate // se ejecuta antes de ser actualizado
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	
}
