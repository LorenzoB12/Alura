package br.com.busolli.lorenzo.testeHibernate.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ti_pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_id")
	private Long id;
	
	@Column(name= "data_insercao")
	private LocalDate data = LocalDate.now();
	
	@Column(name= "valor_total")
	private BigDecimal valorTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItensPedido> itensPedido = new ArrayList<>();;
	
	
	
	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItensPedido item) {
		this.itensPedido.add(item);
		item.setPedido(this);
		this.valorTotal = item.getValorTotal();
	}

	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}
	
	@Override
	public String toString() {
		return this.id + " - " + this.data + " " + this.valorTotal + " " + this.cliente.getNome() + " ";
	}

}
