package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    List<ValidadorAgendamentoDeConsulta> validadores;

    @Autowired
    List<ValidadorCancelamentoDeConsulta> validoresCanc;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente inexistente!");
        }

        if(dados.idMedico() == null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico inexistente!");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoException("Não há médicos disponíveis nesta data!");
        }
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade deve ser preenchida caso não seja escolhido o médico!");
        }

        return medicoRepository.escolhaMedicoAleatorioLivreNaDataPorEspecialidade(dados.especialidade().name(), dados.data());

    }

    public void cancelar(DadosCancelamentoConsulta dados){

        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Consulta inexistente!");
        }

        validoresCanc.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());

    }

}
