package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class Finalizado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		throw new LojaException("Orcamento finalizado nao pode ter desconto extra!");
	}

}
