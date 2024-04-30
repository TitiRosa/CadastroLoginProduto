package automatizado.test;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.GooglePO;
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {

        driver.get("file:///C:/Users/letic/Downloads/controle-de-produtos/sistema/login.html");
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controlleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test

    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();
        String titulo = controlleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
    }
    //    @Test
//    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
//        controlleProdutoPage.buttonAdicionar.click();
//        controlleProdutoPage.buttonAdicionar.click();
//        controlleProdutoPage.cadastrarProduto("00001", "martelo", 10, 59.90,"");
//        String mensagem = controlleProdutoPage.spanMensagem.getText();
//        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
//    }
    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {

          String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage); //cria o objeto para adicionar na tela
        produtoBuilder
                .adicionarNome("")
                .adicionarQuantidade(15)
                .adicionarValor(50.40)
                .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        produtoBuilder
                .adicionarNome("Cimento")
                .adicionarQuantidade(null)
                .adicionarValor(50.40)
                .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        produtoBuilder
                .adicionarNome("Cimento")
                .adicionarQuantidade(15)
                .adicionarValor(null)
                .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        produtoBuilder
                .adicionarQuantidade(15)
                .adicionarValor(50.00)
                .adicionarData("")
                .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        produtoBuilder
                .adicionarCodigo("")
                .adicionarNome("Cimento")
                .adicionarQuantidade(15)
                .adicionarValor(50.00)
                .adicionarData("21/03/2021")
                .builder();
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
        //produtoBuilder.builder(); //Adiciona as informações na tela
    }

    @Test
    public void TC003_DeveSerPossivelCadastrarUmProdutoPreenchendoTodosOsCampos() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage); //cria o objeto para adicionar na tela
        produtoBuilder
                .adicionarCodigo("0005")
                .adicionarNome("Cimento")
                .adicionarQuantidade(20)
                .adicionarValor(50.00)
                .adicionarData("21/03/2021")
                .builder();
        controlleProdutoPage.buttonSalvar.click();
    }

    @Test
    public void TC004_DeveFecharOModalDeCadastroDeProdutoAoClicarEmSair() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();

        controlleProdutoPage.buttonSair.click();
    }
    @Test
    public void TC005_DeveFecharMensagemDeAlerta() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonFecharMensagem.click();
    }
    @Test
    public void TC006_DeveTrazerTabelaDeProdutoscadastrados() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();


        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);
        produtoBuilder
                .adicionarCodigo("0005")
                .adicionarNome("Cimento")
                .adicionarQuantidade(20)
                .adicionarValor(50.00)
                .adicionarData("21/03/2021")
                .builder();
        controlleProdutoPage.buttonSalvar.click();

        produtoBuilder
                .adicionarCodigo("0006")
                .adicionarNome("Martelo")
                .adicionarQuantidade(15)
                .adicionarValor(30.00)
                .adicionarData("21/03/2021")
                .builder();
        controlleProdutoPage.buttonSalvar.click();

        produtoBuilder
                .adicionarCodigo("0007")
                .adicionarNome("Tijolo")
                .adicionarQuantidade(3000)
                .adicionarValor(350.00)
                .adicionarData("21/03/2021")
                .builder();
        controlleProdutoPage.buttonSalvar.click();
        controlleProdutoPage.tableProduto.getText();
        controlleProdutoPage.primeiroProdutoDaTabela.getText("Cimento")
    }
}
