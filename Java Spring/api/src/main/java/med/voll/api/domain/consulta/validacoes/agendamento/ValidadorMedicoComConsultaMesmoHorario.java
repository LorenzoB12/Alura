package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){

        var medicoPossuiConsultaMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiConsultaMesmoHorario){
            throw new ValidacaoException("Médico " + dados.idMedico() + " já possui consulta no mesmo horário!");
        }

    }

}
