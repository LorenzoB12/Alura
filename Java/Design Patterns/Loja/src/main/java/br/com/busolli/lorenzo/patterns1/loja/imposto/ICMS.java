package br.com.busolli.lorenzo.patterns1.loja.imposto;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class ICMS extends Imposto {

	public ICMS(Imposto outro) {
		super(outro);
	}

	public BigDecimal realizarCalculoEspecifico(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}

}
