package br.com.busolli.lorenzo.patterns1.loja.imposto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMS implements Imposto{

    private final BigDecimal aliquota = new BigDecimal("0.12");

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(aliquota);
    }
}
