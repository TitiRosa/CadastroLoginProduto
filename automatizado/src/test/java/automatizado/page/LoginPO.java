package automatizado.page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    /**
     * Construtor base para criação da fabrica de elementos (PageFactory)
     *
     * @param driver Driver da página atual
     */
    public LoginPO(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    // @FindBy(css = "'form.form-login>div.alert>span'")
   // public WebElement spanMensagem;     apenas para demonstrar que mensagem pode ser identificada por css

       public String obterMensagem() {

       return spanMensagem.getText();
   }

   /*
   Metodo que tenta executar a ação de logar no sistema
   email e senha para tentativa de login
    */
    public void  executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail,email);
        escrever(inputSenha,senha);
        buttonEntrar.click();
    }


    
}
