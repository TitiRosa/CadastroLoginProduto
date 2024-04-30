package automatizado.page;

import automatizado.builder.ProdutoBuilder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO{
    /*
     * Construtor base para criação da fabrica de elementos (PageFactory)
     * @param driver Driver da página atual
     */

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;
    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    //@FindBy(css = "div.modal-body>div.alert>button")
    @FindBy(css = "#cadastro-produto > div > div > div.modal-body > div.alert.alert-danger.text-center.alert-dismissible > button")
    public WebElement buttonFecharMensagem;

    @FindBy(css = "table.table.table-hover")
    public WebElement tableProduto;

    @FindBy(css = "body >div>div:nth-child(2)>table>tbody>tr:nth-child(1)>td:nth-child(2)")
    public WebElement primeiroProdutoDaTabela;

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

    public  void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor,String data){

        inputCodigo.clear();
        escrever(inputCodigo, codigo);
        escrever(inputNome,nome);
        escrever(inputQuantidade, quantidade.toString()); //toString converte o formato para String
        escrever(inputValor, valor.toString());
        escrever(inputData, data);
        buttonSalvar.click();
    }
    public  void cadastrarProduto(ProdutoBuilder produtoBuilder){
        inputCodigo.clear();
        escrever(inputCodigo, produtoBuilder.codigo);
        escrever(inputNome,produtoBuilder.nome);
        escrever(inputQuantidade, produtoBuilder.quantidade.toString()); //toString converte o formato para String
        escrever(inputValor, produtoBuilder.valor.toString());
        escrever(inputData, produtoBuilder.data);
        buttonSalvar.click();
    }
}
