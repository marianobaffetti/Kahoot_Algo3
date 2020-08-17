package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class IntroPreguntaVista extends StackPane {
    public IntroPreguntaVista(Kahoot kahoot, KahootControlador controlador) {
        String tipoPregunta = kahoot.obtenerRondaActual().obtenerPregunta().obtenerTipo().replaceAll("_", " ");

        Label lblTipoPregunta = new Label(tipoPregunta);
        lblTipoPregunta.setStyle("-fx-text-fill: white;" +
                    "-fx-font-size: 40pt;" +
                "-fx-border-style: dotted;" +
                "-fx-border-width: 10;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 90;" +
                "-fx-border-color: white;"
        );
        lblTipoPregunta.setWrapText(true);
        lblTipoPregunta.setPadding(new Insets(0, 50, 0, 50));

        this.setOnMouseClicked((evento) -> controlador.clickEnSiguiente());
        this.getChildren().add(lblTipoPregunta);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #9E31F2");
    }
}
