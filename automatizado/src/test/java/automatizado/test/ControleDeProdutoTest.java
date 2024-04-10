package automatizado.test;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
<<<<<<< HEAD
=======
import automatizado.page.GooglePO;
>>>>>>> e06b6399f8bffe56d1286af9641d34b4e81b8a37
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

<<<<<<< HEAD
=======
import java.util.concurrent.TimeUnit;

>>>>>>> e06b6399f8bffe56d1286af9641d34b4e81b8a37
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
<<<<<<< HEAD
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
=======
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
>>>>>>> e06b6399f8bffe56d1286af9641d34b4e81b8a37
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
    public void TC004_DeveSerPossivelCadastrarUmProdutoPreenchendoTodosOsCampos() {
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
<<<<<<< HEAD
    @Test
    public void TC005_DeveFecharOModalDeCadastroDeProdutoAoClicarEmSair() {
        controlleProdutoPage.buttonAdicionar.click();
        controlleProdutoPage.buttonAdicionar.click();

        controlleProdutoPage.buttonSair.click();
    }
=======
>>>>>>> e06b6399f8bffe56d1286af9641d34b4e81b8a37
}
