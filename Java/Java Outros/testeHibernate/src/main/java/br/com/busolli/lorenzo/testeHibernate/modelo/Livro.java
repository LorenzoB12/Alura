package br.com.busolli.lorenzo.testeHibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ti_livros")
public class Livro extends Produto{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_id")
	private Integer id;
	private String autor;
	@Column(name = "numero_de_paginas")
	private Integer numeroDePaginas;
	
	@Column(name = "cod_id_produto")
	private Integer fk;
	
	
	
	public Livro() {
	}

	public Livro(String autor, Integer numeroDePaginas, Integer fk) {
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
		this.fk = fk;
	}

	
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	
}
