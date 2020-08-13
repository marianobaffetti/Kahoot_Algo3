package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BonificacionesControladores;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BonificacionesVista extends VBox {
    public BonificacionesVista(Kahoot kahoot) {
        var controlador = new BonificacionesControladores();
        this.setSpacing(10);
        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new Label("Bonificaciones: "));
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button btnX2 = new Button("X 2");
        btnX2.setOnMouseClicked((evento) -> controlador.usarMultiplicadorX2());

        hBox.getChildren().add(btnX2);
        this.getChildren().add(hBox);
    }
}
