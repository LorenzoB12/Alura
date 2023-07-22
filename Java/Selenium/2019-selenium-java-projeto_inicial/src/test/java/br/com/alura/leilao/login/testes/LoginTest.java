package br.com.alura.leilao.login.testes;

import br.com.alura.leilao.login.pageObject.PageLogin;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    private PageLogin pageLogin;

    @BeforeEach
    public void beforeEach(){
        this.pageLogin = new PageLogin();
    }

    @AfterEach
    public void afterEach(){
        this.pageLogin.fecharNavegador();
    }

    @Test
    @DisplayName("Login efetuado com sucesso")
    void test1(){
        pageLogin.efetuarLogin("fulano", "pass");
        assertEquals(pageLogin.getUrlAtual(), "http://localhost:8080/leiloes");
        assertEquals(pageLogin.getUsuarioAtual(), "fulano");
    }

    @Test
    @DisplayName("Login incorreto")
    void test2(){
        pageLogin.efetuarLogin("fulano", "passs");
        assertNull(pageLogin.getUsuarioAtual());
        assertEquals(pageLogin.getUrlAtual(), "http://localhost:8080/login?error");
        assertTrue(pageLogin.isErroLoginEnabled());
        assertEquals(pageLogin.getDivErroLogin(), "Usuário e senha inválidos.");
    }

    @Test
    @DisplayName("Acesso a página de leilões sem estar logado")
    void test3(){
        pageLogin.navigateToLeiloes();
        assertEquals(pageLogin.getUrlAtual(), "http://localhost:8080/login");
        assertFalse(pageLogin.pageContains("Dados do Leilão"));
    }
}
