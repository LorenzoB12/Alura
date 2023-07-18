package br.com.busolli.lorenzo.JUnit.service;

import br.com.busolli.lorenzo.JUnit.model.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraBonusTest {

    @Test
    @DisplayName("Bonus igual a 500.00")
    void test1() {
        BigDecimal resultadoEsperado = new BigDecimal("500.00");

        CalculadoraBonus calc = new CalculadoraBonus();
        Funcionario funcionario = Funcionario.builder()
                .nome("Lorenzo")
                .salario(new BigDecimal("5000.00"))
                .dataContratacao(now())
                .build();

        BigDecimal bonus = calc.calcularBonus(funcionario);
        assertEquals(bonus, resultadoEsperado);
    }

    @Test
    @DisplayName("Deve lançar Exception pois o salário do funcionário não aceita que ele receba bônus")
    void test2() {
        CalculadoraBonus calc = new CalculadoraBonus();
        Funcionario funcionario = Funcionario.builder()
                .nome("Lorenzo")
                .salario(new BigDecimal("10000.01"))
                .dataContratacao(now())
                .build();

        assertThrows(IllegalArgumentException.class, () -> calc.calcularBonus(funcionario));
    }

    @Test
    @DisplayName("Bonus igual a 1000.00")
    void test3() {
        BigDecimal resultadoEsperado = new BigDecimal("1000.00");

        CalculadoraBonus calc = new CalculadoraBonus();
        Funcionario funcionario = Funcionario.builder()
                .nome("Lorenzo")
                .salario(new BigDecimal("10000.00"))
                .dataContratacao(now())
                .build();

        BigDecimal bonus = calc.calcularBonus(funcionario);
        assertEquals(bonus, resultadoEsperado);
    }
}
