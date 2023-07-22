package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLogin {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver webDriver;

    public PageLogin(){
        System.setProperty("webdriver.chrome.driver", "C://Users/loren/Projetos/Alura/Java/Selenium/2019-selenium-java-projeto_inicial/src/test/drivers/chromedriver.exe");
        this.webDriver = new ChromeDriver();
        this.webDriver.navigate().to(URL_LOGIN);
    }

    public void fecharNavegador() {
        this.webDriver.quit();
    }

    public void efetuarLogin(String login, String senha) {
        this.webDriver.findElement(By.id("username")).sendKeys(login);
        this.webDriver.findElement(By.id("password")).sendKeys(senha);
        this.webDriver.findElement(By.id("login-form")).submit();
    }

    public String getUrlAtual() {
        return this.webDriver.getCurrentUrl();
    }

    public String getUsuarioAtual() {
        try{
            return this.webDriver.findElement(By.id("usuario-autenticado")).getText();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Boolean isErroLoginEnabled(){
        return this.webDriver.findElement(By.id("alert-erro-login")).isEnabled();
    }

    public String getDivErroLogin(){
        return this.webDriver.findElement(By.id("alert-erro-login")).getText();
    }

    public void navigateToLeiloes(){
        this.webDriver.navigate().to("http://localhost:8080/leiloes/2");
    }

    public Boolean pageContains(String texto){
        return webDriver.getPageSource().contains(texto);
    }
}
