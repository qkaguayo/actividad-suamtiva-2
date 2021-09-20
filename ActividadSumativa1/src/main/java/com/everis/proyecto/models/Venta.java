package com.everis.proyecto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representacion de entidad modelo
@Table(name="ventas") 
public class Venta {
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para auto incrementar
	private Long id;
	
	private String nombre;
	private Integer valor_total;  
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Venta() {
		super();
	}

	public Venta(String nombre, Integer valor_total) {
		super();
		this.nombre = nombre;
		this.valor_total = valor_total;
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

	public Integer getValor_Total() {
		return valor_total;
	}

	public void setValor_Total(Integer valor_total) {
		this.valor_total = valor_total;
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
