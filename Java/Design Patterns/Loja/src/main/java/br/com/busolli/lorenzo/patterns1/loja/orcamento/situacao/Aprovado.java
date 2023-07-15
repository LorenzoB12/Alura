package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.02"));
	}

	@Override
	public void finalizar(Orcamento orcamento) throws LojaException {
		orcamento.setSituacao(new Finalizado());
	}

}
