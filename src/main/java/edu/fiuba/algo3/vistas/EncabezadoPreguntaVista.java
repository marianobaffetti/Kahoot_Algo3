package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class EncabezadoPreguntaVista extends StackPane {
    public EncabezadoPreguntaVista(Kahoot kahoot) {
        Jugador jugador = kahoot.obtenerJugadorActual();

        HBox hBoxJugador = new HBox();
        hBoxJugador.getChildren().add( new Label("Jugador: " + jugador.obtenerNombre()));
        hBoxJugador.setAlignment(Pos.TOP_LEFT);

        HBox hBoxRonda= new HBox();
        hBoxRonda.getChildren().add(new Label("Ronda: " + kahoot.obtenerNumeroDeRonda()));
        hBoxRonda.setAlignment(Pos.TOP_CENTER);

        HBox hBoxPuntos = new HBox();
        hBoxPuntos.getChildren().add( new Label("Puntos: " + jugador.obtenerPuntaje()));
        hBoxPuntos.setAlignment(Pos.TOP_RIGHT);

        hBoxJugador.setPadding(new Insets(10, 0, 0 , 10));
        hBoxRonda.setPadding(new Insets(10, 0, 0 , 0));
        hBoxPuntos.setPadding(new Insets(10, 10, 0 , 0));

        this.getChildren().add(hBoxJugador);
        this.getChildren().add(hBoxRonda);
        this.getChildren().add(hBoxPuntos);
    }
}

