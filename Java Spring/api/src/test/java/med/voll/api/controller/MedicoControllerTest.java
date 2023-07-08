package med.voll.api.controller;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoMedicoJson;

    @MockBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Deve retornar 400 quando não forem passado parâmetros na requisição")
    void cadastrarCenario1() throws Exception{
        var response = mockMvc.perform(post("/medicos")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve retornar 200 quando os parâmetros passados forem os corretos")
    void cadastrarCenario2() throws Exception{
        var especialidade = Especialidade.DERMATOLOGIA;
        var dadosEndereco = new DadosEndereco("Rua Duque de Caxias", "Jardim da Fonte", "95960000", "Encantado", "RS", "Casa", "2775");
        var dadosCadastroMedico = new DadosCadastroMedico("Lorenzo", "lorenzo@busolli.com", "51996044688", "849733", especialidade, dadosEndereco);

        when(repository.save(any())).thenReturn(new Medico(dadosCadastroMedico));

        var retornoEsperado = new DadosDetalhamentoMedico(null, "Lorenzo", "lorenzo@busolli.com", "849733", "51996044688", especialidade, new Endereco(dadosEndereco));
        var jsonRetornoEsperado = dadosDetalhamentoMedicoJson.write(retornoEsperado).getJson();

        var dadosCadastroMedicoJsonContent = dadosCadastroMedicoJson.write(dadosCadastroMedico).getJson();
        var response = mockMvc.perform(post("/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroMedicoJsonContent)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonRetornoEsperado);
    }
}