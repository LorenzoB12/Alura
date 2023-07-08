package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){

        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesHorarioFuncionamento = dados.data().getHour() < 7;
        var depoisHorarioFuncionamento = dados.data().getHour() > 18 || (dados.data().getMinute() > 0 && dados.data().getHour() == 18);

        if(domingo || antesHorarioFuncionamento || depoisHorarioFuncionamento){
            throw new ValidacaoException("Horário da consulta fora do horário de funcionamento da clínica!");
        }

    }

}
