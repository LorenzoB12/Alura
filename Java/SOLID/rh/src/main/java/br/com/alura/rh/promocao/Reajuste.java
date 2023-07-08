package br.com.alura.rh.promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste{
    BigDecimal valor();
    LocalDate dataReajuste();
}
