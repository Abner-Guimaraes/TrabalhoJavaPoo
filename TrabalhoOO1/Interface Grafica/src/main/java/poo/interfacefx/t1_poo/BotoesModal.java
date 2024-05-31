package poo.interfacefx.t1_poo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BotoesModal {

    public static void updateModal(String titulo){
        Stage modal = new Stage();
        modal.setTitle(titulo);
        modal.setMinWidth(216);
        modal.setMinHeight(144);
        modal.initModality(Modality.APPLICATION_MODAL);

        Label mensagem = new Label("Tem certeza que deseja atualizar?");
        Button simBtn = new Button("sim");
        Button naoBtn = new Button("não");

        simBtn.setOnAction(e -> System.out.println("Atualiza o arquivo!"));
        naoBtn.setOnAction(e -> modal.close());

        HBox btnContainer = new HBox();
        btnContainer.setSpacing(15);
        btnContainer.getChildren().addAll(simBtn,naoBtn);
        btnContainer.setAlignment(Pos.CENTER);

        VBox modalContainer = new VBox(15);
        modalContainer.getChildren().addAll(mensagem,btnContainer);
        modalContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(modalContainer);
        modal.setScene(scene);
        modal.showAndWait();
    }

    public static void deleteModal(String titulo){
        Stage modal = new Stage();
        modal.setTitle(titulo);
        modal.setMinWidth(216);
        modal.setMinHeight(144);
        modal.initModality(Modality.APPLICATION_MODAL);

        Label mensagem = new Label("Tem certeza que deseja deletar?");
        Button simBtn = new Button("sim");
        Button naoBtn = new Button("não");

        simBtn.setOnAction(e -> System.out.println("Deleta o arquivo!"));
        naoBtn.setOnAction(e -> modal.close());

        HBox btnContainer = new HBox();
        btnContainer.setSpacing(15);
        btnContainer.getChildren().addAll(simBtn,naoBtn);
        btnContainer.setAlignment(Pos.CENTER);

        VBox modalContainer = new VBox(15);
        modalContainer.getChildren().addAll(mensagem,btnContainer);
        modalContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(modalContainer);
        modal.setScene(scene);
        modal.showAndWait();
    }
}
