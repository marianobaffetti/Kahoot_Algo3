package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class EncabezadoPreguntaVista extends StackPane {
    public EncabezadoPreguntaVista(Kahoot kahoot) {
        Jugador jugador = kahoot.obtenerJugadorActual();

        HBox hBoxJugador = new HBox();
        Label lblJugador = new Label("Jugador: " + jugador.obtenerNombre());
        lblJugador.setStyle("-fx-text-fill: white;");
        hBoxJugador.getChildren().add(lblJugador);
        hBoxJugador.setAlignment(Pos.TOP_LEFT);


        HBox hBoxRonda = new HBox();
        Label lblRonda = new Label("Ronda: " + kahoot.obtenerNumeroDeRonda());
        lblRonda.setStyle("-fx-text-fill: white;");
        hBoxRonda.getChildren().add(lblRonda);
        hBoxRonda.setAlignment(Pos.TOP_CENTER);

        HBox hBoxPuntos = new HBox();
        Label lblPuntos = new Label("Puntos: " + jugador.obtenerPuntaje());
        lblPuntos.setStyle("-fx-text-fill: white;");
        hBoxPuntos.getChildren().add(lblPuntos);
        hBoxPuntos.setAlignment(Pos.TOP_RIGHT);

        hBoxJugador.setPadding(new Insets(10, 0, 2, 10));
        hBoxRonda.setPadding(new Insets(10, 0, 2, 0));
        hBoxPuntos.setPadding(new Insets(10, 10, 2, 0));

        this.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 0 0 2 0;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: white;"
        );

        this.getChildren().add(hBoxJugador);
        this.getChildren().add(hBoxRonda);
        this.getChildren().add(hBoxPuntos);
    }
}

