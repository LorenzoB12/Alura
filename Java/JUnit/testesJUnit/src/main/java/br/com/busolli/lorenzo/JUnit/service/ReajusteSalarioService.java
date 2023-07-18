package br.com.busolli.lorenzo.JUnit.service;

import br.com.busolli.lorenzo.JUnit.model.Desempenho;
import br.com.busolli.lorenzo.JUnit.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteSalarioService {

    public BigDecimal reajustarSalario(Funcionario funcionario) {
        BigDecimal salario = funcionario.getSalario();
        BigDecimal reajuste = funcionario.getDesempenho().getPercentual();
        return salario.multiply(reajuste).add(salario).setScale(2, RoundingMode.HALF_UP);
    }
}
