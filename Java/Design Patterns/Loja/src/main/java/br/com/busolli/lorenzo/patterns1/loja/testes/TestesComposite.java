package br.com.busolli.lorenzo.patterns1.loja.testes;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.ItemOrcamento;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.OrcamentoProxy;

public class TestesComposite {

	public static void main(String[] args) {
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);

		OrcamentoProxy proxy = new OrcamentoProxy(novo);
		var valor = proxy.getValor();

		System.out.println(valor);
		System.out.println(valor);
		System.out.println(valor);
		System.out.println(valor);
		System.out.println(valor);
	}

}
