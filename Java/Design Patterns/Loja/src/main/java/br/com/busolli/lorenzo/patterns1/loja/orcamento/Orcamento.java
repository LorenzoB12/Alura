package br.com.busolli.lorenzo.patterns1.loja.orcamento;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.EmAnalise;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.Finalizado;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {

	private List<Orcavel> itens = new ArrayList<>();
	private BigDecimal valor = BigDecimal.ZERO;
	private SituacaoOrcamento situacao;

	public Orcamento() {
		this.situacao = new EmAnalise();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}

	public void aprovar() {
		this.situacao.aprovar(this);
	}

	public void reprovar() {
		this.situacao.reprovar(this);
	}

	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public BigDecimal getValor() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			return this.valor;
		}
		return this.valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public boolean isFinalizado() {
		return this.situacao instanceof Finalizado;
	}

	public void adicionarItem(Orcavel item) {
		this.valor = this.valor.add(item.getValor());
		this.itens.add(item);
	}

}
