package poo.interfacefx.t1_poo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotoesDeOpcoes extends HBox {
    private final Button atualizarBtn, deletarBtn;

    public BotoesDeOpcoes(Produtos produto){
        this.atualizarBtn = new Button("Atualizar");
        this.deletarBtn = new Button("Deletar");

        atualizarBtn.setStyle("-fx-text-fill: #fff;-fx-background-color: DodgerBlue;"
               + "-fx-font-weight: bold; -fx-cursor: hand;");
        deletarBtn.setStyle("-fx-text-fill: #fff;-fx-background-color: Crimson;"
                + "-fx-font-weight: bold; -fx-cursor: hand;");

        atualizarBtn.setOnAction(_ -> {
            BotoesModal.updateModal("Atualizar");
        });

        deletarBtn.setOnAction(_ -> {
            BotoesModal.deleteModal("Deletar");
        });

        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(atualizarBtn,deletarBtn);
    }

    public Button getAtualizarBtn() {
        return atualizarBtn;
    }

    public Button getDeletarBtn() {
        return deletarBtn;
    }
}
