package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/*
 * Classe base para a criação das novas PagesObjects
 * Todas as pages devem ser herdadas desta classe
 */
public abstract class BasePO {

/*
* Driver base que será usado pelas pages
*/
    protected WebDriver driver;

/**
 * Construtor base para criação da fabrica de elementos (PageFactory)
 * @param driver Driver da página atual
 */   
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String obterTituloPagina(){
        return driver.getTitle();
    }
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
