package br.com.alura.rh.promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste{

    private BigDecimal valor;
    private LocalDate dataReajuste;

    public Anuenio(BigDecimal valor, LocalDate dataReajuste) {
        this.valor = valor;
        this.dataReajuste = dataReajuste;
    }

    @Override
    public BigDecimal valor() {
        return this.valor;
    }

    @Override
    public LocalDate dataReajuste() {
        return this.dataReajuste;
    }
}
