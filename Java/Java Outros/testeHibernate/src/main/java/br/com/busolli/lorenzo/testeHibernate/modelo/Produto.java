package br.com.busolli.lorenzo.testeHibernate.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ti_produtos")
@NamedQuery(name = "Produto.buscarTodos", query = "SELECT P FROM Produto P")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Column(name = "data_insercao")
	private LocalDate data_insercao = LocalDate.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	
	
	
	public Produto() {

	}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public LocalDate getData() {
		return data_insercao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", data_insercao=" + data_insercao + ", categoria=" + categoria + "]";
	}
	
}
