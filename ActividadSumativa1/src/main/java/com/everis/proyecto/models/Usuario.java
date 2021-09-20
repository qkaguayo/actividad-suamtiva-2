package com.everis.proyecto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representacion de entidad modelo
@Table(name="personas") 
public class Usuario {
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para auto incrementar
	private Long id;
	
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	
	// relacion one to many (Usuario)
		@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
		private List<Producto> producto;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	public Usuario() {
		super();
	}
	public Usuario(String rut, String nombre, String apellido, Integer edad, Date createdAt, Date updatedAt) {
		super();
		
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
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
