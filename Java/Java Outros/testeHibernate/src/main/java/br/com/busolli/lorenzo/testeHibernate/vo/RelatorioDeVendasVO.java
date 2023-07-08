package br.com.busolli.lorenzo.testeHibernate.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVO {

	private String nome;
	private Long quantidade_vendida;
	private LocalDate ultima_venda;
	
	
	
	public RelatorioDeVendasVO(String nome, Long valor_total, LocalDate ultima_venda) {
		this.nome = nome;
		this.quantidade_vendida = valor_total;
		this.ultima_venda = ultima_venda;
	}
	
	public RelatorioDeVendasVO() {
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public Long getValor_total() {
		return quantidade_vendida;
	}
	public LocalDate getUltima_venda() {
		return ultima_venda;
	}



	@Override
	public String toString() {
		return "RelatorioDeVendasVO [nome=" + nome + ", quantidade_vendida=" + quantidade_vendida + ", ultima_venda=" + ultima_venda
				+ "]";
	}
}
