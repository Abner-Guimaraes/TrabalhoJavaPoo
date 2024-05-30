package poo.interfacefx.t1_poo;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ScreenFx extends Application {

    Stage tela;
    TableView<Produtos> tabela;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        tela = stage;
        tela.setTitle("trabalho 1 poo");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(12);

        // nome do produto.
        Label nomeLabel = new Label("Nome");
        TextField nomeInput = new TextField();
        nomeInput.setPromptText("Nome do produto");
        GridPane.setConstraints(nomeLabel,0,0);
        GridPane.setConstraints(nomeInput,0,1);

        // filtro de nome.
        TextField buscaInput = new TextField();
        buscaInput.setPromptText("Pesquisar...");
        buscaInput.setPrefWidth(400);
        Button buscaBtn = new Button("Buscar");
        GridPane.setConstraints(buscaInput,4,0);
        GridPane.setConstraints(buscaBtn,6,0);

        // descricao do produto.
        Label descricaoLabel = new Label("ID");
        TextField descricaoInput = new TextField();
        descricaoInput.setPromptText("Descricao do produto");
        GridPane.setConstraints(descricaoLabel,0,2);
        GridPane.setConstraints(descricaoInput,0,3);

        // marca do produto.
        Label marcaLabel = new Label("Marca");
        TextField marcaInput = new TextField();
        marcaInput.setPromptText("Marca do produto");
        GridPane.setConstraints(marcaLabel,0,4);
        GridPane.setConstraints(marcaInput,0,5);

        // categoria do produto.
        Label categoriaLabel = new Label("Categoria");
        TextField categoriaInput = new TextField();
        categoriaInput.setPromptText("Categoria do produto");
        GridPane.setConstraints(categoriaLabel,0,6);
        GridPane.setConstraints(categoriaInput,0,7);

        // preco do produto.
        Label precoLabel = new Label("Lista de Preco");
        TextField precoInput = new TextField();
        precoInput.setPromptText("Lista de preco produto");
        GridPane.setConstraints(precoLabel,0,8);
        GridPane.setConstraints(precoInput,0,9);

        // categoria do produto.
        Label custoLabel = new Label("Custo");
        TextField custoInput = new TextField();
        custoInput.setPromptText("Custo do produto");
        GridPane.setConstraints(custoLabel,0,10);
        GridPane.setConstraints(custoInput,0,11);

        // botoes de criar.
        Button criarBtn = new Button("Criar");
        GridPane.setConstraints(criarBtn,0,12);

        // TABELA DE PRODUTOS.

        //  coluna Nomes.
        TableColumn<Produtos,String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setMinWidth(200);
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //  coluna Decricao.
        TableColumn<Produtos,String> descricaoCol = new TableColumn<>("Descricao");
        descricaoCol.setMinWidth(200);
        descricaoCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        //  coluna Marca.
        TableColumn<Produtos,String> marcaCol = new TableColumn<>("Marca");
        marcaCol.setMinWidth(100);
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));

        //  coluna Categoria.
        TableColumn<Produtos,String> categoriaCol = new TableColumn<>("Categoria");
        categoriaCol.setMinWidth(150);
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        //  coluna de Lista de Preco.
        TableColumn<Produtos,Double> precoCol = new TableColumn<>("Lista de Preço");
        precoCol.setMinWidth(150);
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));

        //  coluna de Custo.
        TableColumn<Produtos,String> custoCol = new TableColumn<>("Custo");
        custoCol.setMinWidth(150);
        custoCol.setCellValueFactory(new PropertyValueFactory<>("custo"));

        // coluna dos Botoes de Atualizar e Deletar.
        TableColumn<Produtos,BotoesDeOpcoes> opcoesCol = new TableColumn<>("Opções");
        opcoesCol.setMinWidth(175);
        opcoesCol.setCellValueFactory(celldata -> {
            Produtos produto = celldata.getValue();
            return new SimpleObjectProperty<>(new BotoesDeOpcoes(produto));
        });

        // adicionando itens na tabela e a tabela no grid.
        tabela = new TableView<>();
        tabela.setItems(getProdutos());
        tabela.getColumns().addAll(nomeCol,descricaoCol,marcaCol,categoriaCol,precoCol,
                custoCol,opcoesCol);
        GridPane.setConstraints(tabela,4,1,6,12);


        // adicionando ao grid.
        grid.getChildren().addAll(nomeLabel,nomeInput,buscaInput,buscaBtn,descricaoLabel,
                descricaoInput, marcaLabel,tabela,marcaInput,categoriaLabel,categoriaInput,
                precoLabel,precoInput,custoLabel,custoInput,criarBtn);

        // mostrando a cena na tela.
        Scene scene = new Scene(grid,1024,600);
        tela.setScene(scene);
        tela.show();
    }

    public ObservableList<Produtos> getProdutos(){
        ObservableList<Produtos> produtos = FXCollections.observableArrayList();
        produtos.add(new Produtos("Televisão","Lorem ipsum","Samsung",
                "Eletrodomesticos",1200.00,500.00));
        produtos.add(new Produtos("Play Station 5","Lorem ipsum","Sony",
                "Eletrodomesticos",5000.00,2500.00));
        return produtos;
    }

}