package br.com.busolli.lorenzo.patterns1.loja.imposto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImpostos {

    public BigDecimal calcularImposto(Orcamento orcamento, Imposto imposto){
        return imposto.calcular(orcamento);
    }

}
