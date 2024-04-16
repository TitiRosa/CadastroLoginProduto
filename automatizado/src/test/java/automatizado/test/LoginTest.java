package automatizado.test;
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //metodo para executar os testes pela ordem
public class LoginTest extends BaseTest{
    private static LoginPO loginPage;

//    private void  executarAcaoDeLogar(String email, String senha){
//        loginPage.escrever(loginPage.inputEmail,email);
//        loginPage.escrever(loginPage.inputSenha,senha);
//        loginPage.buttonEntrar.click();
//    }
    @BeforeClass
    public static void prepararTestes(){

        loginPage = new LoginPO(driver);

    }
    @Test
    public void TC001_naoDeveLogarComEmailESenhaVazio(){
        /*
        Teste com várias demonstrações de como fazer
         */
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");


//   loginPage.escrever(loginPage.inputEmail,"");
//   loginPage.escrever(loginPage.inputSenha,"");
//   loginPage.buttonEntrar.click();
//   String mensagem = loginPage.obterMensagem();
//   assertEquals(mensagem, "E-mail ou senha inválidos");

//   loginPage.inputEmail.sendKeys("");
//   loginPage.inputSenha.sendKeys("");
//   loginPage.buttonEntrar.click();
//   String mensagem = loginPage.obterMensagem();
//   assertEquals(mensagem, "E-mail ou senha inválidos");

    }
    @Test
    public void TC002_naoDeveLogarComEmailInvalidoESenhaVazia(){

        loginPage.executarAcaoDeLogar("Teste", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
//        executarAcaoDeLogar("Teste", "");
//        String mensagem = loginPage.obterMensagem();
//        assertEquals(mensagem, "E-mail ou senha inválidos");

    }
    @Test
    public void TC003_naoDeveLogarComEmailVazioESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("", "Teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
//        executarAcaoDeLogar("", "Teste");
//        String mensagem = loginPage.obterMensagem();
//        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC004_naoDeveLogarComEmailESenhaIncorretos(){

        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    @Test
    public void TC005_naoDeveLogarComSenhaIncorreta(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }
    @Test
    public void TC006_naoDeveLogarComEmailInvalido(){

        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

@Test
public void TC007_deveLogarComEmailESenhaCorretos(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }

}


