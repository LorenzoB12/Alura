package br.com.busolli.lorenzo.patterns1.loja.testes;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.imposto.ICMS;
import br.com.busolli.lorenzo.patterns1.loja.imposto.ISS;
import br.com.busolli.lorenzo.patterns1.loja.imposto.Imposto;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.ItemOrcamento;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

public class TestesImposto {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		Imposto imposto = new ICMS(new ISS(null));
		System.out.println(imposto.calcular(orcamento));
	}

}
