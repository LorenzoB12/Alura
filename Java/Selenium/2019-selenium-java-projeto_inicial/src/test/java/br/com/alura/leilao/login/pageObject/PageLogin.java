package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLogin extends Page{

    private static final String URL_LOGIN = "http://localhost:8080/login";

    public PageLogin(){
        super(null);
        super.webDriver.navigate().to(URL_LOGIN);
    }

    public PageLeilao efetuarLogin(String login, String senha) {
        super.webDriver.findElement(By.id("username")).sendKeys(login);
        super.webDriver.findElement(By.id("password")).sendKeys(senha);
        super.webDriver.findElement(By.id("login-form")).submit();
        return new PageLeilao(super.webDriver);
    }

    public String getUsuarioAtual() {
        try{
            return super.webDriver.findElement(By.id("usuario-autenticado")).getText();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public Boolean isErroLoginEnabled(){
        return super.webDriver.findElement(By.id("alert-erro-login")).isEnabled();
    }

    public String getDivErroLogin(){
        return super.webDriver.findElement(By.id("alert-erro-login")).getText();
    }

    public void navigateToLeiloes(){
        super.webDriver.navigate().to("http://localhost:8080/leiloes/2");
    }

    public Boolean pageContains(String texto){
        return webDriver.getPageSource().contains(texto);
    }
}
