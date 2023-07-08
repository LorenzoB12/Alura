package br.com.busolli.lorenzo.patterns1.loja.desconto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoValor extends Desconto{

    private BigDecimal vlrParaDarDesconto = new BigDecimal("500");

    public DescontoValor(Desconto proximo) {
        super(proximo);
        super.perDesconto = new BigDecimal("0.10");
    }

    @Override
    protected BigDecimal calcularDesconto(Orcamento orcamento) {
        return orcamento.getValor().multiply(super.perDesconto);
    }

    @Override
    protected Boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(vlrParaDarDesconto) > 0;
    }
}
