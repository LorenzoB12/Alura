package br.com.alura.rh.promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel{

    private BigDecimal valor;
    private LocalDate dataReajuste;
    private BigDecimal valorImpostoDeRenda;

    public Promocao(BigDecimal valor, LocalDate dataReajuste, BigDecimal valorImpostoDeRenda) {
        this.valor = valor;
        this.dataReajuste = dataReajuste;
        this.valorImpostoDeRenda = valorImpostoDeRenda;
    }

    @Override
    public BigDecimal valor() {
        return this.valor;
    }

    @Override
    public LocalDate dataReajuste() {
        return this.dataReajuste;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return this.valorImpostoDeRenda;
    }
}
