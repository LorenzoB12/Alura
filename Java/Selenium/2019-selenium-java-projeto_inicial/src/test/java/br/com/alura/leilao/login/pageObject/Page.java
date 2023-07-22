package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {

    protected WebDriver webDriver;

    public Page(){
        System.setProperty("webdriver.chrome.driver", "C://Users/loren/Projetos/Alura/Java/Selenium/2019-selenium-java-projeto_inicial/src/test/drivers/chromedriver.exe");
    }

    public String getUrlAtual() {
        return this.webDriver.getCurrentUrl();
    }

    public void fecharNavegador() {
        this.webDriver.quit();
    }
}
