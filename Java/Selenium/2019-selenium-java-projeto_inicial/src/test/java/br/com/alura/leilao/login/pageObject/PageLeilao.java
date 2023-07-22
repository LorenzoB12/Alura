package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLeilao extends Page{

    public PageLeilao(WebDriver webDriver){
        super.webDriver = webDriver;
    }

    public PageFormCadastroLeilao acessarFormCadastroLeilao() {
        super.webDriver.findElement(By.id("novo_leilao_link")).click();
        return new PageFormCadastroLeilao(super.webDriver);
    }
}
