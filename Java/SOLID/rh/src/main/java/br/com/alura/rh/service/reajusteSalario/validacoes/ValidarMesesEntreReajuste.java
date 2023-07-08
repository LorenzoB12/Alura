package br.com.alura.rh.service.reajusteSalario.validacoes;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.exceptions.ValidacaoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidarMesesEntreReajuste implements ValidarReajuste{
    @Override
    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        Long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataAtual, dataUltimoReajuste);
        if(mesesUltimoReajuste < 6){
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses!");
        }
    }
}
