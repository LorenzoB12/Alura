package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {

        var agora = LocalDateTime.now();
        var horarioConsulta = dados.data();
        var diferencaMinutos = Duration.between(agora, horarioConsulta).toMinutes();
        System.out.println(diferencaMinutos);

        if(diferencaMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência!");
        }

    }

}
