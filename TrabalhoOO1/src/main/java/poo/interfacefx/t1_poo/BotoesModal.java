package poo.interfacefx.t1_poo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BotoesModal extends ScreenFx {

    static boolean flag;

    public static void updateModal(String titulo, Produtos produto, ScreenFx screenFx){
        Stage modal = new Stage();
        modal.setTitle(titulo);
        modal.setMinWidth(400);
        modal.setMinHeight(400);
        modal.initModality(Modality.APPLICATION_MODAL);

        Label mensagem = new Label("Atualize as informações do produto");
        mensagem.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;" +
                    "-fx-text-fill: #000000;");

<<<<<<< HEAD
        TextField nomeInput = new TextField(produto.getNome());
        nomeInput.setMaxWidth(250);
        TextField descricaoInput = new TextField(produto.getDescricao());
        descricaoInput.setMaxWidth(250);
        TextField marcaInput = new TextField(produto.getMarca());
        marcaInput.setMaxWidth(250);
        TextField categoriaInput = new TextField(produto.getCategoria());
        categoriaInput.setMaxWidth(250);
        TextField precoInput = new TextField(String.valueOf(produto.getPreco()));
        precoInput.setMaxWidth(250);
        TextField custoInput = new TextField(String.valueOf(produto.getCusto()));
        custoInput.setMaxWidth(250);

        Button simBtn = new Button("Atualizar");
        simBtn.setStyle("-fx-text-fill: #fff;-fx-background-color: MediumSeaGreen;"
                + "-fx-font-weight: bold; -fx-cursor: hand;");
        Button naoBtn = new Button("Cancelar");
        naoBtn.setStyle("-fx-text-fill: #fff;-fx-background-color: Crimson;"
                + "-fx-font-weight: bold; -fx-cursor: hand;");

        simBtn.setOnAction(_ -> {
            String novoNome = nomeInput.getText();
            String novaDescricao = descricaoInput.getText();
            String novaMarca = marcaInput.getText();
            String novaCategoria = categoriaInput.getText();
            double novoPreco = Double.parseDouble(precoInput.getText());
            double novoCusto = Double.parseDouble(custoInput.getText());

            screenFx.atualizarProduto(true, produto, novoNome, novaDescricao,
                    novaMarca, novaCategoria, novoPreco, novoCusto);
            modal.close();
        });
        naoBtn.setOnAction(_ -> modal.close());
=======
        simBtn.setOnAction(e -> System.out.println("Atualiza o arquivo!"));
        naoBtn.setOnAction(e -> modal.close());
>>>>>>> 6b7c15b2cd10f531cfeed0bf659ec90c09b771d3


        HBox btnContainer = new HBox(10);
        btnContainer.getChildren().addAll(simBtn, naoBtn);
        btnContainer.setAlignment(Pos.CENTER);

        VBox modalContainer = new VBox(15);
        modalContainer.getChildren().addAll(mensagem, nomeInput, descricaoInput, marcaInput,
                categoriaInput, precoInput, custoInput,btnContainer);
        modalContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(modalContainer);
        modal.setScene(scene);
        modal.showAndWait();
    }

    public static boolean deleteModal(String titulo){
        Stage modal = new Stage();
        modal.setTitle(titulo);
        modal.setMinWidth(216);
        modal.setMinHeight(144);
        modal.initModality(Modality.APPLICATION_MODAL);

        Label mensagem = new Label("Tem certeza que deseja deletar?");
        mensagem.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;" +
                "-fx-text-fill: #000000;");

        Button simBtn = new Button("sim");
        Button naoBtn = new Button("não");

<<<<<<< HEAD
        simBtn.setOnAction(_ -> {
            flag = true;
            modal.close();
        });
        naoBtn.setOnAction(_ -> {
            flag = false;
            modal.close();
        });
=======
        simBtn.setOnAction(e -> System.out.println("Deleta o arquivo!"));
        naoBtn.setOnAction(e -> modal.close());
>>>>>>> 6b7c15b2cd10f531cfeed0bf659ec90c09b771d3

        HBox btnContainer = new HBox();
        btnContainer.setSpacing(15);
        btnContainer.getChildren().addAll(simBtn, naoBtn);
        btnContainer.setAlignment(Pos.CENTER);

        VBox modalContainer = new VBox(15);
        modalContainer.getChildren().addAll(mensagem, btnContainer);
        modalContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(modalContainer);
        modal.setScene(scene);
        modal.showAndWait();

        return flag;
    }
}
