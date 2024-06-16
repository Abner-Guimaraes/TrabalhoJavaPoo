package poo.interfacefx.t1_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.stream.Collectors;
import java.util.List;

public class ProdutosControlador {
    private final ObservableList<Produtos> produtos;

    public ProdutosControlador() {
        this.produtos = FXCollections.observableArrayList();
        carregarProdutosIniciais();
    }

    private void carregarProdutosIniciais() {
        // Adiciona produtos de exemplo
        for (int i = 0; i < 10; i++) {
            produtos.add(new Produtos("Televisão", "Lorem ipsum",
                    "Samsung", "Eletrodomésticos", 1200.00,
                    500.00));
            produtos.add(new Produtos("Play Station 5", "Lorem ipsum", "Sony",
                    "Eletrodomésticossssssssssssssssssssssssssssssssssssssssssssss",
                    5000.00, 2500.00));
        }
    }

    public ObservableList<Produtos> getProdutos() {
        return produtos;
    }

    public int getQuantidadeDeProdutos() {
        return produtos.size();
    }

    public void criarProduto(TextField nomeInput, TextField descricaoInput,
                             TextField marcaInput, TextField categoriaInput,
                             TextField precoInput, TextField custoInput,
                             TableView<Produtos> tabela) {

        Produtos produto = new Produtos();

        produto.setNome(nomeInput.getText());
        produto.setDescricao(descricaoInput.getText());
        produto.setMarca(marcaInput.getText());
        produto.setCategoria(categoriaInput.getText());
        produto.setPreco(Double.parseDouble(precoInput.getText()));
        produto.setCusto(Double.parseDouble(custoInput.getText()));

        produtos.add(produto);
        tabela.getItems().add(produto);

        nomeInput.clear();
        descricaoInput.clear();
        marcaInput.clear();
        categoriaInput.clear();
        precoInput.clear();
        custoInput.clear();
    }

    public void atualizarProduto(boolean flag, Produtos produto, String novoNome,
                                 String novaDescricao, String novaMarca,
                                 String novaCategoria, double novoPreco,
                                 double novoCusto, TableView<Produtos> tabela) {

        if(flag){
            produto.setNome(novoNome);
            produto.setDescricao(novaDescricao);
            produto.setMarca(novaMarca);
            produto.setCategoria(novaCategoria);
            produto.setPreco(novoPreco);
            produto.setCusto(novoCusto);
            tabela.refresh();
        }
    }

    public void deletarProduto(boolean flag, Produtos produto, TableView<Produtos> tabela) {
        if(flag){
            produtos.remove(produto);
            tabela.getItems().remove(produto);
        }
    }

    public ObservableList<Produtos> filtrarProdutos(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            return produtos;
        }
        List<Produtos> filtrados = produtos.stream()
                .filter(produto -> produto.getNome().toLowerCase().contains(criterio.toLowerCase()) ||
                        produto.getDescricao().toLowerCase().contains(criterio.toLowerCase()) ||
                        produto.getMarca().toLowerCase().contains(criterio.toLowerCase()) ||
                        produto.getCategoria().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
        return FXCollections.observableArrayList(filtrados);
    }

}

