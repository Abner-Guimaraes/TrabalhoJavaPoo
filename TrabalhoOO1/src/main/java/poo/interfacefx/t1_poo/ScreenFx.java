package poo.interfacefx.t1_poo;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.util.Objects;

public class ScreenFx extends Application {

    Stage tela;
    TableView<Produtos> tabela;
    private static final int LINHAS_POR_PAGINA = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Criacao do GridPane.
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        // Nome do produto.
        Label nomeLabel = new Label("Nome");
        TextField nomeInput = new TextField();
        nomeInput.setPromptText("Nome do produto");

        // Descricao do produto.
        Label descricaoLabel = new Label("Descrição");
        TextField descricaoInput = new TextField();
        descricaoInput.setPromptText("Descrição do produto");

        // Marca do produto.
        Label marcaLabel = new Label("Marca");
        TextField marcaInput = new TextField();
        marcaInput.setPromptText("Marca do produto");

        // Categoria do produto.
        Label categoriaLabel = new Label("Categoria");
        TextField categoriaInput = new TextField();
        categoriaInput.setPromptText("Categoria do produto");

        // Preco do produto.
        Label precoLabel = new Label("Lista de Preço");
        TextField precoInput = new TextField();
        precoInput.setPromptText("Lista de preço produto");

        // Categoria do produto.
        Label custoLabel = new Label("Custo");
        TextField custoInput = new TextField();
        custoInput.setPromptText("Custo do produto");

        // Botoes de criar.
        Button criarBtn = new Button("Criar");

        // Filtro de nome.
        TextField buscaInput = new TextField();
        buscaInput.setPromptText("Pesquisar...");
        buscaInput.setPrefWidth(500);
        Button buscaBtn = new Button("Buscar");

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
            return new SimpleObjectProperty<>(new BotoesDeOpcoes(produto));
        });

        // Adicionando itens na tabela.
        tabela = new TableView<>();
        tabela.setPrefWidth(885);
        tabela.setItems(getProdutos());
        tabela.getColumns().addAll(nomeCol, descricaoCol, marcaCol, categoriaCol, precoCol,
                custoCol, opcoesCol);

        // Paginacao
        Pagination paginacao = new Pagination();
        paginacao.setPageCount((int) Math.ceil(getProdutos().size() /
                (double) LINHAS_POR_PAGINA));
        paginacao.setPageFactory(this::criarPagina);

        // Adicionando a paginacao ao grid.
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
                    text.wrappingWidthProperty().bind(auxCol.widthProperty().subtract(5));
                    setGraphic(text);
                }
            }
        });
        return auxCol;
    }

    private Node criarPagina(int paginaIdx) {
        int doIndex = paginaIdx * LINHAS_POR_PAGINA;
        int paraIndex = Math.min(doIndex + LINHAS_POR_PAGINA, getProdutos().size());
        tabela.setItems(FXCollections.observableArrayList(getProdutos().
                subList(doIndex, paraIndex)));
        return new BorderPane(tabela);
    }

    public ObservableList<Produtos> getProdutos() {
        ObservableList<Produtos> produtos = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            produtos.add(new Produtos("Televisão", "Lorem ipsum", "Samsung",
                    "Eletrodomesticos", 1200.00, 500.00));
            produtos.add(new Produtos("Play Station 5", "Lorem ipsum", "Sony",
                    "Eletrodomesticossssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss", 5000.00, 2500.00));
        }
        return produtos;
    }
}