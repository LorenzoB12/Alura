package br.com.alura.rh.service.reajusteSalario;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajusteSalario.validacoes.ValidarReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajustarSalarioService {

    private List<ValidarReajuste> validacoes;

    public ReajustarSalarioService(List<ValidarReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalario(Funcionario funcionario, BigDecimal valorAumento){
        validacoes.forEach(v -> v.validar(funcionario, valorAumento));
        BigDecimal salarioReajustado = funcionario.getSalario().add(valorAumento);
        funcionario.atualizarSalario(salarioReajustado);
    }

}
