package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest{

    private static GooglePO googlePage;
    @BeforeClass
    public static void prepararTestes(){

        googlePage = new GooglePO(driver);

    }
    
    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita(){
     
     //Arrange -- Preparação
     //WebElement inputPesquisa = driver.findElement(By.name("q"));
     //googlePage.inputPesquisa.sendKeys("Batata Frita" + Keys.ENTER);
     googlePage.pesquisar("Batata Frita");
     
     //String resultado = driver.findElement(By.id("result-stats")).getText();
     String resultado = googlePage.divResultadoPesquisa.getText();

     assertTrue(resultado, resultado.contains("Aproximadamente"));

    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita(){
     
     //Arrange -- Preparação
     googlePage.pesquisar("Batata Frita");
     
     String resultado = googlePage.obterResultadoDaPesquisa();

     assertTrue(resultado, resultado.contains("resultados"));
 
     // verificando alteração
    }

}
