package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected WebDriver webDriver;

    public Page(WebDriver webDriver){
        System.setProperty("webdriver.chrome.driver", "C://Users/loren/Projetos/Alura/Java/Selenium/2019-selenium-java-projeto_inicial/src/test/drivers/chromedriver.exe");

        if(webDriver == null){
            this.webDriver = new ChromeDriver();
        } else{
            this.webDriver = webDriver;
        }

        this.webDriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS).pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public String getUrlAtual() {
        return this.webDriver.getCurrentUrl();
    }

    public void fecharNavegador() {
        this.webDriver.quit();
    }
}
