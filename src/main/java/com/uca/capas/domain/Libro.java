package com.uca.capas.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(schema="public",name="cat_libro")
public class Libro {

	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_libro;
	
	
	@Column(name="s_titulo")
	@NotEmpty(message="El campo titulo categoría no puede estar vacío")
	@Size(max=500,message="El campo sobrepasa la cantidad de 500 caracteres")
	private String s_titulo;
	
	@Column(name="s_autor")
	@NotEmpty(message="El campo autor categoría no puede estar vacío")
	@Size(max=150,message="El campo sobrepasa la cantidad de 150 caracteres")
	private String s_autor;
	
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	@CreationTimestamp
	private LocalDateTime f_ingreso;
	
	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="El campo ISBN categoría no puede estar vacío")
	@Size(max=10,message="El campo sobrepasa la cantidad de 10 caracteres")
	private String s_isbn;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titiulo() {
		return s_titulo;
	}

	public void setS_titiulo(String s_titiulo) {
		this.s_titulo = s_titiulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	

	@DateTimeFormat(pattern="dd-MMM-YYYY hh:mm")
	public LocalDateTime getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(LocalDateTime f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getEstadoDelegate() {
		if(this.b_estado==null)return"";
		else {
			return b_estado==true ?"Activo":"Inactivo";
		}
	}

	public Libro() {
		
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	
	
	
}
