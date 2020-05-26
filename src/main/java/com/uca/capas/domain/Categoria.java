package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {

	
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_categoria;
	
	@Column(name="s_categoria")
	@NotEmpty(message="El campo nombre categoría no puede estar vacío")
	@Size(max=50,message="El campo sobrepasa la cantidad de 50 caracteres")
	private String s_categoria;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	private List<Libro> libro;

	public Integer getC_categoria() {
		return c_categoria;
	}


	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}


	public String getS_categoria() {
		return s_categoria;
	}


	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}


	public Categoria() {
		
	}
	
	
	
}
