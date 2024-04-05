package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;
import org.openqa.selenium.WebDriver;

public class ProdutoBuilder {

    public String codigo = "0001";
    public String nome = "Produto Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "03/11/2021";

    private ControleDeProdutoPO controleDeProdutoPO;
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }
    /*
    Se nenhum valor for passado, os valores informados serão padrão
     */

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    public void builder(){
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : ""); //toString converte o formato para String
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        controleDeProdutoPO.buttonSalvar.click();
    }
}

