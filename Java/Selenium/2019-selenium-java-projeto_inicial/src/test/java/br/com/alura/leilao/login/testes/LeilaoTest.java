package br.com.alura.leilao.login.testes;

import br.com.alura.leilao.login.pageObject.PageFormCadastroLeilao;
import br.com.alura.leilao.login.pageObject.PageLeilao;
import br.com.alura.leilao.login.pageObject.PageLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeilaoTest {

    private PageLogin pageLogin;
    private PageLeilao pageLeilao;
    private PageFormCadastroLeilao pageForm;
    private final String URL_LEILOES =  "http://localhost:8080/leiloes";

    @BeforeEach
    public void beforeEach(){
        this.pageLogin = new PageLogin();
        this.pageLeilao = pageLogin.efetuarLogin("fulano", "pass");
        assertEquals(this.pageLogin.getUrlAtual(), URL_LEILOES);
        assertEquals(this.pageLogin.getUsuarioAtual(), "fulano");
        this.pageForm = this.pageLeilao.acessarFormCadastroLeilao();
    }

    @AfterEach
    public void afterEach(){
        this.pageLeilao.fecharNavegador();
    }

    @Test
    @DisplayName("Cadastrar leilão")
    void test1(){
        String nomeLeilao = "Leilão de teste";
        String valorInicial = "500.00";
        String dataAbertura = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.pageForm.cadastrarLeilao(nomeLeilao, valorInicial, dataAbertura);
        assertTrue(this.pageForm.isLeilaoCadastrado(nomeLeilao, valorInicial, dataAbertura));
    }

    @Test
    @DisplayName("Validações de cadastro inválido de leilão")
    void test2(){
        this.pageForm.cadastrarLeilao("", "", "");
        assertTrue(this.pageForm.isValidacaoWorking());
        assertEquals(this.pageForm.getUrlAtual(), URL_LEILOES);
    }
}
