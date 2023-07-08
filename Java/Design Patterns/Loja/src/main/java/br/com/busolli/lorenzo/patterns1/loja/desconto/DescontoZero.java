package br.com.busolli.lorenzo.patterns1.loja.desconto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoZero extends Desconto{

    public DescontoZero(Desconto proximo){
        super(proximo);
    }

    @Override
    public BigDecimal calcularDesconto(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    protected Boolean deveAplicar(Orcamento orcamento) {
        return true;
    }
}
