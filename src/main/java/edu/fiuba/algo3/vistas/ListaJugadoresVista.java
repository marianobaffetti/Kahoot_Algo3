package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

public class ListaJugadoresVista extends StackPane {
    public ListaJugadoresVista(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        Label lblJugadores = new Label("Jugadores");
        lblJugadores.setPadding(new Insets(0, 0, 0, 5));
        lblJugadores.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 20pt;" +
                "-fx-font-weight: bold;"
        );
        vBox.getChildren().add(lblJugadores);

        kahoot.obtenerJugadores().forEach(jugador -> {
            Label lblJugador = new Label(" · " + jugador.obtenerNombre());
            lblJugador.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 14pt;"
            );
            vBox.getChildren().add(lblJugador);
        });

        vBox.setPadding(new Insets(40, 60, 0, 0));

        this.setPadding(new Insets(0, 20, 20, 0));
        this.getChildren().add(vBox);
    }
}
