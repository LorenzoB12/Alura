package br.com.busolli.lorenzo.JUnit.service;

import br.com.busolli.lorenzo.JUnit.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraBonus {

    private BigDecimal percentBonus = new BigDecimal("0.10");
    private BigDecimal valorMaximo = new BigDecimal("1000.00");

    public BigDecimal calcularBonus(Funcionario funcionario){
        if(funcionario.getSalario().multiply(percentBonus).compareTo(valorMaximo) > 0){
            throw new IllegalArgumentException("Salário do funcionário não aceita pagamento de bônus!");
        }
        return funcionario.getSalario().multiply(percentBonus).setScale(2, RoundingMode.HALF_UP);
    }

}
