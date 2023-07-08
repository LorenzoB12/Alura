package br.com.alura.rh.service.reajusteSalario.validacoes;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.exceptions.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidarPercentualReajuste implements ValidarReajuste{
    @Override
    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
