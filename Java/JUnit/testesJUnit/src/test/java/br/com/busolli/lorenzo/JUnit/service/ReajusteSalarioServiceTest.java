package br.com.busolli.lorenzo.JUnit.service;

import br.com.busolli.lorenzo.JUnit.model.Desempenho;
import br.com.busolli.lorenzo.JUnit.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteSalarioServiceTest {

    private ReajusteSalarioService reajusteSalario;
    private Funcionario funcionario;
    public ReajusteSalarioServiceTest(){
        this.reajusteSalario = new ReajusteSalarioService();;
        this.funcionario = Funcionario.builder()
                .nome("Lorenzo")
                .dataContratacao(now())
                .salario(new BigDecimal("1000.00"))
                .desempenho(null)
                .build();
    }

    @DisplayName("Deve retornar 1030.00 quando o salário for de 1000.00 e o desempenho A_DESEJAR")
    @Test
    void test1(){
        funcionario.setDesempenho(Desempenho.A_DESEJAR);
        BigDecimal salarioReajustado = reajusteSalario.reajustarSalario(funcionario);
        assertEquals(salarioReajustado, new BigDecimal("1030.00"));
    }

    @DisplayName("Deve retornar 1150.00 quando o salário for de 1000.00 e o desempenho BOM")
    @Test
    void test2(){
        funcionario.setDesempenho(Desempenho.BOM);
        BigDecimal salarioReajustado = reajusteSalario.reajustarSalario(funcionario);
        assertEquals(salarioReajustado, new BigDecimal("1150.00"));
    }

    @DisplayName("Deve retornar 1300.00 quando o salário for de 1000.00 e o desempenho OTIMO")
    @Test
    void test3(){
        funcionario.setDesempenho(Desempenho.OTIMO);
        BigDecimal salarioReajustado = reajusteSalario.reajustarSalario(funcionario);
        assertEquals(salarioReajustado, new BigDecimal("1200.00"));
    }

}
