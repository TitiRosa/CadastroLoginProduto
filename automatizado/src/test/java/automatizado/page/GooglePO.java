package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;

/**
* Construtor para criação da página do Googke
* @param driver Driver da página do Google
*/

    public GooglePO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    /*
     * Metodo que irá efetuar uma pesquisa no google baseando no texto informado e concluindo com Enter
     * @param texto Texto a ser pesquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /*
     * Metodo que retorna o resultado aproximado da pesquisa
     */
    public String obterResultadoDaPesquisa(){

        return divResultadoPesquisa.getText();
    }
    
}
