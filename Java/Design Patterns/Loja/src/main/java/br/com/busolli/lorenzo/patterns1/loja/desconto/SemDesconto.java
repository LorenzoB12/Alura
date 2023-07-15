package br.com.busolli.lorenzo.patterns1.loja.desconto;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return true;
	}

}
