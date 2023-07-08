package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoOrcamento{
    private BigDecimal aliquotaDescontoExtra = new BigDecimal("0.05");

    @Override
    public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(aliquotaDescontoExtra);
    }

    @Override
    public void aprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Aprovado());
    }

    @Override
    public void reprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Reprovado());
    }
}
