package br.com.busolli.lorenzo.patterns1.loja.imposto;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.realizarCalculoEspecifico(orcamento);
	}

}
