package br.com.alura.rh.service.reajusteSalario.validacoes;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidarReajuste {

    void validar(Funcionario funcionario, BigDecimal valorAumento);

}
