package br.com.busolli.lorenzo.patterns1.loja.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy extends Orcamento{

    private BigDecimal valor;
    private Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento){
        this.valor = orcamento.getValor();
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor(){
        if(valor == null){
            this.valor = orcamento.getValor();
        }

        return this.valor;
    }
}
