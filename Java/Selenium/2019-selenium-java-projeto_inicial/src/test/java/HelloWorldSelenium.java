import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class HelloWorldSelenium {

    @Test
    void hello(){
        System.setProperty("webdriver.chrome.driver", "C://Users/loren/Projetos/Alura/Java/Selenium/2019-selenium-java-projeto_inicial/src/test/drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("http://localhost:8080");
        webDriver.quit();
    }

}
