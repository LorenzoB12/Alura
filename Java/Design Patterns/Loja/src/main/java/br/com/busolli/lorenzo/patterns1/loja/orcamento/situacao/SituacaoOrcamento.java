package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {

	public abstract BigDecimal calcularDescontoExtra(Orcamento orcamento);
	
	public void aprovar(Orcamento orcamento) throws LojaException {
		throw new LojaException("Orcamento nao pode ser aprovado!");
	}
	
	public void reprovar(Orcamento orcamento) throws LojaException {
		throw new LojaException("Orcamento nao pode ser reprovado!");
	}
	
	public void finalizar(Orcamento orcamento) throws LojaException {
		throw new LojaException("Orcamento nao pode ser finalizado!");
	}

}
