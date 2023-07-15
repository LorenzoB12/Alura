package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class EmAnalise extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}

	@Override
	public void aprovar(Orcamento orcamento) throws LojaException {
		orcamento.setSituacao(new Aprovado());
	}
	
	@Override
	public void reprovar(Orcamento orcamento) throws LojaException {
		orcamento.setSituacao(new Reprovado());
	}

}
