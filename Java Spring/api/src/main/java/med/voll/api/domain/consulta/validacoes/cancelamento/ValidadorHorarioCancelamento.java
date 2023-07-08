package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioCancelamento implements ValidadorCancelamentoDeConsulta{
    @Autowired
    ConsultaRepository repo;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repo.findById(dados.idConsulta()).get();
        var dthConsulta = consulta.getData();
        var dthAgora = LocalDateTime.now();
        var diferenca = Duration.between(dthConsulta, dthAgora).toMinutes();

        System.out.println(diferenca);

        if(diferenca < 1440){
            throw new ValidacaoException("A consulta só pode ser cancelada com no mínimo 24 horas de antecedência!");
        }
    }
}
