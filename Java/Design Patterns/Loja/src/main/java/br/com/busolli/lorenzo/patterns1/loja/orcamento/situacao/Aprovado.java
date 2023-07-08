package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoOrcamento{
    private BigDecimal aliquotaDescontoExtra = new BigDecimal("0.02");

    @Override
    public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(aliquotaDescontoExtra);
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
