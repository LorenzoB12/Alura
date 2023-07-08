package br.com.busolli.lorenzo.patterns1.loja.orcamento.situacao;

import br.com.busolli.lorenzo.patterns1.loja.LojaException;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {

    public BigDecimal calcularDescontoExtra(Orcamento orcamento){
        return BigDecimal.ZERO;
    }

    public void aprovar(Orcamento orcamento){
        throw new LojaException("Orçamento não pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento){
        throw new LojaException("Orçamento não pode ser reprovado!");
    }

    public void finalizar(Orcamento orcamento){
        throw new LojaException("Orçamento não pode ser finalizado!");
    }

}
