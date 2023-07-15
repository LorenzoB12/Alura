package br.com.busolli.lorenzo.patterns1.loja.testes;

import java.math.BigDecimal;

import br.com.busolli.lorenzo.patterns1.loja.http.ApacheHttpAdapter;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.ItemOrcamento;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.RegistroOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
		orcamento.aprovar();
		orcamento.finalizar();

		RegistroOrcamento registro = new RegistroOrcamento(new ApacheHttpAdapter());
		registro.registrar(orcamento);
	}

}
