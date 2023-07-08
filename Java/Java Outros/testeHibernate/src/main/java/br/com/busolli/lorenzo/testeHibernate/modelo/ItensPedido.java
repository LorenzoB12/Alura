package br.com.busolli.lorenzo.testeHibernate.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ti_itens_pedidos")
public class ItensPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_id")
	private Long id;
	private BigDecimal preco_unitario;
	private Long quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
	
	public ItensPedido() {
	}

	public ItensPedido(Long quantidade, Produto produto, Pedido pedido) {
		this.preco_unitario = produto.getPreco();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(BigDecimal preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = this.preco_unitario.multiply(new BigDecimal(this.quantidade));
		return valorTotal;
	}
	
}
