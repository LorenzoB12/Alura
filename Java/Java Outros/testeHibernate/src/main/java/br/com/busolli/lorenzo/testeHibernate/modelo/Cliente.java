package br.com.busolli.lorenzo.testeHibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ti_clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_id")
	private Long id;
	@Embedded
	private DadosPessoais dadosPessoais;
	
	
	
	public Cliente() {
	}

	public Cliente(DadosPessoais dados) {
		this.dadosPessoais = dados;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
}
