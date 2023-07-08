package br.com.busolli.lorenzo.patterns1.loja.orcamento;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.EmAnalise;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.Finalizado;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public class Orcamento {

    private BigDecimal valor;
    private Integer qtdItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, Integer qtdItens) {
        this.valor = valor;
        this.qtdItens = qtdItens;
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar(){
        this.situacao.aprovar(this);
    }

    public void reprovar(){
        this.situacao.reprovar(this);
    }

    public void finalizar(){
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQtdItens(){
        return qtdItens;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }
}
