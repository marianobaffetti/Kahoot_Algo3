package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class PuntajesFinalesVista extends StackPane {
    public PuntajesFinalesVista(Kahoot kahoot) {
        VBox vBox = new VBox();

        kahoot.obtenerJugadores().forEach((jugador) -> {
            String puntaje = String.valueOf(jugador.obtenerPuntaje()).substring(0, String.valueOf(jugador.obtenerPuntaje()).indexOf("."));
            var mensajeGanadorPerdedor = kahoot.obtenerGanadores().contains(jugador) ? " <- GANADOR :)" : " <- LOOSER :(";
            Label lblResultado = new Label(jugador.obtenerNombre() + ": " + puntaje + mensajeGanadorPerdedor);
            lblResultado.setStyle("-fx-font-size: 26;-fx-text-fill: white");
            vBox.getChildren().add(lblResultado);
            vBox.setAlignment(Pos.CENTER);
        });

        this.setStyle("-fx-background-color: #9E31F2");
        this.getChildren().add(vBox);
    }
}
