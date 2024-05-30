package poo.interfacefx.t1_poo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotoesDeOpcoes extends HBox {
    private Button atualizarBtn, deletarBtn;

    public BotoesDeOpcoes(Produtos produto){
        this.atualizarBtn = new Button("Atualizar");
        this.deletarBtn = new Button("Deletar");

        atualizarBtn.setOnAction(e -> System.out.println("clicou em adicionar!"));
        deletarBtn.setOnAction(e -> System.out.println("clicou em deletar!"));

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
