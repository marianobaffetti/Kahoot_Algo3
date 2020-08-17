package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class IntroPreguntaVista extends Pane {
    public IntroPreguntaVista(Kahoot kahoot, KahootControlador controlador) {
        String tipoPregunta = kahoot.obtenerRondaActual().obtenerPregunta().obtenerTipo().replaceAll("_", " ");

        Label lblTipoPregunta = new Label(tipoPregunta);
        this.setOnMouseClicked((evento) -> controlador.clickEnSiguiente());
        this.getChildren().add(lblTipoPregunta);

        this.setStyle("-fx-background-color: #9E31F2");
    }
}
