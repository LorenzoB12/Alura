package br.com.busolli.lorenzo.testeHibernate.modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ti_informatica")
//@PrimaryKeyJoinColumn(name = "cod_id_produto")
public class Informatica extends Produto{

	private String marca;
	private Integer modelo;
	
	
	
	public Informatica() {
	}

	public Informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	
	
	public String getAutor() {
		return marca;
	}

	public void setAutor(String marca) {
		this.marca = marca;
	}

	public Integer getNumeroDePaginas() {
		return modelo;
	}

	public void setNumeroDePaginas(Integer modelo) {
		this.modelo = modelo;
	}
	
}
