package br.com.busolli.lorenzo.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private BigDecimal valor;
	private LocalDate dataEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

}
