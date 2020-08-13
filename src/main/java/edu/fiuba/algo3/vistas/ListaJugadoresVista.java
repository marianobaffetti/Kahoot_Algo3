package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ListaJugadoresVista extends StackPane {
    public ListaJugadoresVista(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        Label lblJugadores = new Label("Jugadores");
        vBox.getChildren().add(lblJugadores);

        kahoot.obtenerJugadores().forEach(jugador -> {
            Label lblJugador = new Label(" - " + jugador.obtenerNombre());
            vBox.getChildren().add(lblJugador);
        });

        vBox.setPadding(new Insets(100, 100,0,0));
        this.getChildren().add(vBox);
    }
}
