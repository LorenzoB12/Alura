package br.com.busolli.lorenzo.patterns1.loja.imposto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public interface Imposto {

    BigDecimal calcular(Orcamento orcamento);

}
