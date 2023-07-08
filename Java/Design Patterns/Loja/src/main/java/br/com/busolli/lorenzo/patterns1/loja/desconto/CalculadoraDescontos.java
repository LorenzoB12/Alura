package br.com.busolli.lorenzo.patterns1.loja.desconto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDescontos {

    public BigDecimal calcular(Orcamento orcamento, Desconto desconto){
        return desconto.calcular(orcamento);
    }

}
