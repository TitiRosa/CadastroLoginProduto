package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de horança para todas as classes de teste
 */
public abstract class BaseTest {

    /**
     * Driver do navegador da página atual
     */
    static WebDriver driver;

    /**
     * Caminho base da URL do sistema a ser testado
     */
    private static final String URL_BASE =  "file:///C:/Users/letic/Downloads/controle-de-produtos/sistema/login.html";
    /**
     * Caminho relativo do driver ao projeto referente ao path
     */
    private static final String CAMINHO_DRIVER = "C:/Users/letic/Desktop/AutomacaoLogin/TesteLogin/automatizado/src/test/java/automatizado/resource/chromedriver.exe";

    /**
     * Metodo para iniciar o driver do navegador, antes de qualquer classe de teste
     */
    
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
        
    }

    /**
     * Metodo para finalizar o driver do navegador depois de qualquer classe de teste
     */
   @AfterClass
public static void finalizar() {

     driver.quit();
   }
    
}
