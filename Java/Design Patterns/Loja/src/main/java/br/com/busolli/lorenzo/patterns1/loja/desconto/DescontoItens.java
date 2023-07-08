package br.com.busolli.lorenzo.patterns1.loja.desconto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoItens extends Desconto{

    private Integer qtdItensParaDarDesconto = 5;

    public DescontoItens(Desconto proximo) {
        super(proximo);
        super.perDesconto = new BigDecimal("0.05");
    }

    @Override
    protected BigDecimal calcularDesconto(Orcamento orcamento) {
        return orcamento.getValor().multiply(super.perDesconto);
    }

    @Override
    protected Boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQtdItens() >= qtdItensParaDarDesconto;
    }
}
