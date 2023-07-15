package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		throw new LojaException("Orcamento reprovado nao pode ter desconto extra!");
	}

	@Override
	public void finalizar(Orcamento orcamento) throws LojaException {
		orcamento.setSituacao(new Finalizado());
	}

}
