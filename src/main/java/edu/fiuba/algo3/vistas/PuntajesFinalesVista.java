package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PuntajesFinalesVista extends StackPane {
    public PuntajesFinalesVista(Kahoot kahoot) {
        VBox vBox = new VBox();
        kahoot.obtenerJugadores().forEach((jugador) -> {
            vBox.getChildren().add(new Label(jugador.obtenerNombre() + ": " + jugador.obtenerPuntaje()));
        });
        this.getChildren().add(vBox);
    }
}
