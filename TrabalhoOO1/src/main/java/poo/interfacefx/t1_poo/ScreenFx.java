package poo.interfacefx.t1_poo;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.Objects;

public class ScreenFx extends Application {

    private Stage tela;
    private TableView<Produtos> tabela;
    private static final int LINHAS_POR_PAGINA = 10;
    private TextField nomeInput;
    private TextField descricaoInput;
    private TextField marcaInput;
    private TextField categoriaInput;
    private TextField precoInput;
    private TextField custoInput;
    private TextField buscaInput;
    private ProdutosControlador produtosControlador;
    private Pagination paginacao;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        produtosControlador = new ProdutosControlador();

        // Criacao do GridPane.
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        // Nome do produto.
        Label nomeLabel = new Label("Nome");
        nomeInput = new TextField();
        nomeInput.setPromptText("Nome do produto");

        // Descricao do produto.
        Label descricaoLabel = new Label("Descrição");
        descricaoInput = new TextField();
        descricaoInput.setPromptText("Descrição do produto");

        // Marca do produto.
        Label marcaLabel = new Label("Marca");
        marcaInput = new TextField();
        marcaInput.setPromptText("Marca do produto");

        // Categoria do produto.
        Label categoriaLabel = new Label("Categoria");
        categoriaInput = new TextField();
        categoriaInput.setPromptText("Categoria do produto");

        // Preco do produto.
        Label precoLabel = new Label("Lista de Preço");
        precoInput = new TextField();
        precoInput.setPromptText("Lista de preço produto");

        // Categoria do produto.
        Label custoLabel = new Label("Custo");
        custoInput = new TextField();
        custoInput.setPromptText("Custo do produto");

        // Botoes de criar.
        Button criarBtn = new Button("Criar");
        criarBtn.setOnAction(_ -> {
            produtosControlador.criarProduto(nomeInput, descricaoInput, marcaInput,
                    categoriaInput, precoInput, custoInput, tabela);
            atualizarPaginacao();
        });

        // Filtro de nome.
        buscaInput = new TextField();
        buscaInput.setPromptText("Pesquisar...");
        buscaInput.setPrefWidth(500);
        Button buscaBtn = new Button("Buscar");
        buscaBtn.setOnAction(_ -> atualizarPaginacao());

        // Container do botao buscar.
        HBox buscaContainer = new HBox();
        buscaContainer.setSpacing(10);
        buscaContainer.getChildren().addAll(buscaInput, buscaBtn);
        // Adicionando o botão buscar ao grid.
        GridPane.setConstraints(buscaContainer, 2, 0);

        // Container dos inputs usados pelo usuario.
        VBox inputsContainer = new VBox();
        inputsContainer.setMinWidth(200);
        inputsContainer.setSpacing(15);
        inputsContainer.getChildren().addAll(nomeLabel, nomeInput, descricaoLabel, descricaoInput,
                marcaLabel, marcaInput, categoriaLabel, categoriaInput, precoLabel, precoInput,
                custoLabel, custoInput, criarBtn);
        // Adicionando o container dos inputs ao grid.
        GridPane.setConstraints(inputsContainer, 0, 1);

        // TABELA DE PRODUTOS.

        // Coluna Nomes.
        TableColumn<Produtos, String> nomeCol = getProdutosStringTableColumn("Nome", "nome");

        // Coluna Descricao.
        TableColumn<Produtos, String> descricaoCol = getProdutosStringTableColumn("Descrição", "descricao");

        // Coluna Marca.
        TableColumn<Produtos, String> marcaCol = getProdutosStringTableColumn("Marca", "marca");

        // Coluna Categoria.
        TableColumn<Produtos, String> categoriaCol = getProdutosStringTableColumn("Categoria", "categoria");

        // Coluna de Lista de Preco.
        TableColumn<Produtos, Double> precoCol = new TableColumn<>("Lista de Preço");
        precoCol.setMinWidth(200);
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));

        // Coluna de Custo.
        TableColumn<Produtos, String> custoCol = new TableColumn<>("Custo");
        custoCol.setMinWidth(100);
        custoCol.setCellValueFactory(new PropertyValueFactory<>("custo"));

        // Coluna dos Botoes de Atualizar e Deletar.
        TableColumn<Produtos, BotoesDeOpcoes> opcoesCol = new TableColumn<>("Opções");
        opcoesCol.setMinWidth(175);
        opcoesCol.setCellValueFactory(celldata -> {
            Produtos produto = celldata.getValue();
            return new SimpleObjectProperty<>(new BotoesDeOpcoes(produto, this));
        });

        // Adicionando itens na tabela.
        tabela = new TableView<>();
<<<<<<< HEAD
        tabela.setPrefWidth(776);
        tabela.setItems(produtosControlador.getProdutos());
=======
        tabela.setPrefWidth(885);
        tabela.setItems(getProdutos());
>>>>>>> 6b7c15b2cd10f531cfeed0bf659ec90c09b771d3
        tabela.getColumns().addAll(nomeCol, descricaoCol, marcaCol, categoriaCol, precoCol,
                custoCol, opcoesCol);

        // Paginacao
        paginacao = new Pagination();
        paginacao.setPageFactory(this::criarPagina);
        GridPane.setConstraints(paginacao, 2, 1, 2, 8);

        // Adicionando containers ao grid.
        grid.getChildren().addAll(inputsContainer, buscaContainer, paginacao);

        // Mostrando a cena na tela.
        tela = stage;
        tela.setTitle("Trabalho 1 Poo");
        Scene scene = new Scene(grid, 1280, 720);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Image icone = new Image(Objects.requireNonNull(getClass().getResource("POO_icon.png")).toExternalForm());
        tela.getIcons().add(icone);
        tela.setScene(scene);
        tela.show();

        // Atualizando a paginacao depois que a tela é inicializada
        atualizarPaginacao();
    }

    public void atualizarProduto(boolean flag, Produtos produto, String novoNome,
                                 String novaDescricao, String novaMarca,
                                 String novaCategoria, double novoPreco, double novoCusto){

        produtosControlador.atualizarProduto(flag, produto, novoNome, novaDescricao,
                novaMarca, novaCategoria, novoPreco, novoCusto, tabela);
        atualizarPaginacao();
    }

    public void deletarProduto(boolean flag, Produtos produto) {
        produtosControlador.deletarProduto(flag, produto, tabela);
        atualizarPaginacao();
    }

    private static TableColumn<Produtos, String> getProdutosStringTableColumn(String Nome, String nome) {
        TableColumn<Produtos, String> auxCol = new TableColumn<>(Nome);
        auxCol.setMinWidth(100);
        auxCol.setCellValueFactory(new PropertyValueFactory<>(nome));
        auxCol.setCellFactory(e -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Text text = new Text(item);
                    text.wrappingWidthProperty().bind
                            (auxCol.widthProperty().subtract(5));
                    setGraphic(text);
                }
            }
        });
        return auxCol;
    }

    private Node criarPagina(int pagina) {
        ObservableList<Produtos> produtosFiltrados = produtosControlador.filtrarProdutos(buscaInput.getText());
        int de = pagina * LINHAS_POR_PAGINA;
        int ate = Math.min(de + LINHAS_POR_PAGINA, produtosFiltrados.size());
        tabela.setItems(FXCollections.observableArrayList(produtosFiltrados.subList(de, ate)));
        return new BorderPane(tabela);
    }

    private void atualizarPaginacao() {
        ObservableList<Produtos> produtosFiltrados = produtosControlador.filtrarProdutos(buscaInput.getText());
        int pageCount = (int) Math.ceil((double) produtosFiltrados.size() / LINHAS_POR_PAGINA);
        paginacao.setPageCount(pageCount);
        paginacao.setPageFactory(this::criarPagina);
    }
}
