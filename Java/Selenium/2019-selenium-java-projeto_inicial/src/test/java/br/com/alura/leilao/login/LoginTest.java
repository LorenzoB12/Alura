package br.com.alura.leilao.login;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver webDriver;

    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "C://Users/loren/Projetos/Alura/Java/Selenium/2019-selenium-java-projeto_inicial/src/test/drivers/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        this.webDriver = new ChromeDriver();
        webDriver.navigate().to(URL_LOGIN);
    }

    @AfterEach
    public void afterEach(){
        this.webDriver.quit();
    }

    @Test
    @DisplayName("Teste de login efetuado com sucesso")
    void test1(){
        webDriver.findElement(By.id("username")).sendKeys("fulano");
        webDriver.findElement(By.id("password")).sendKeys("pass");
        webDriver.findElement(By.id("login-form")).submit();
        assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/leiloes");
        String usuarioEncontrado = webDriver.findElement(By.id("usuario-autenticado")).getText();
        String usuarioCorreto = "fulano";
        assertEquals(usuarioCorreto, usuarioEncontrado);
    }

    @Test
    @DisplayName("Teste de login incorreto")
    void test2(){
        webDriver.findElement(By.id("username")).sendKeys("fulano");
        webDriver.findElement(By.id("password")).sendKeys("123");
        webDriver.findElement(By.id("login-form")).submit();
        assertThrows(NoSuchElementException.class, () -> webDriver.findElement(By.id("usuario-autenticado")));
        assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/login?error");
        assertEquals(webDriver.findElement(By.id("alert-erro-login")).isEnabled(), true);
        assertEquals(webDriver.findElement(By.id("alert-erro-login")).getText(), "Usuário e senha inválidos.");
    }

    @Test
    @DisplayName("Teste de acesso a página de leilões sem estar logado")
    void test3(){
        webDriver.navigate().to("http://localhost:8080/leiloes/2");
        assertEquals(URL_LOGIN, webDriver.getCurrentUrl());
        assertFalse(webDriver.getPageSource().contains("Dados do Leilão"));
    }
}
