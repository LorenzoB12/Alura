package br.com.alura.leilao.login.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageFormCadastroLeilao extends Page{

    public PageFormCadastroLeilao(WebDriver webDriver){
        super.webDriver = webDriver;
    }

    public void cadastrarLeilao(String nomeLeilao, String valorInicial, String dataAbertura) {
        super.webDriver.findElement(By.id("nome")).sendKeys(nomeLeilao);
        super.webDriver.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        super.webDriver.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        super.webDriver.findElement(By.id("button-submit")).submit();
    }

    public Boolean isLeilaoCadastrado(String nomeLeilao, String valorInicial, String dataAbertura) {
        WebElement element = super.webDriver.findElement(By.cssSelector("#table-leiloes tbody tr:last-child"));
        String leilaoCadastrado = element.findElement(By.cssSelector("td:nth-child(1)")).getText();
        String dataAberturaCadastrada = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
        String valorInicialCadastrado = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
        return leilaoCadastrado.equals(nomeLeilao) &&
                valorInicialCadastrado.equals(valorInicial) &&
                dataAberturaCadastrada.equals(dataAbertura);
    }

    public Boolean isValidacaoWorking() {
        String pageSource = super.webDriver.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("não deve estar em branco") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy") &&
                pageSource.contains("alert alert-danger");
    }
}
