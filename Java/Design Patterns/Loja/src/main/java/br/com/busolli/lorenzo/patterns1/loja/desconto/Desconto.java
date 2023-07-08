package br.com.busolli.lorenzo.patterns1.loja.desconto;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    protected BigDecimal perDesconto;

    protected Desconto proximo;

    public Desconto(Desconto proximo){
        this.proximo = proximo;
    }

    public BigDecimal calcular(Orcamento orcamento){
        if(deveAplicar(orcamento)){
            return calcularDesconto(orcamento);
        }
        return proximo.calcular(orcamento);
    }

    protected abstract BigDecimal calcularDesconto(Orcamento orcamento);
    protected abstract Boolean deveAplicar(Orcamento orcamento);

}
