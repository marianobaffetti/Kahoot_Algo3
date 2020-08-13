package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class VerdaderoFalsoVista extends BorderPane {
    public VerdaderoFalsoVista(Kahoot kahoot) {
        mostrarOpciones(kahoot);
        mostrarJugador(kahoot);
    }

    private void mostrarJugador(Kahoot kahoot) {
        this.setTop(new EncabezadoPreguntaVista(kahoot));
//        this.setTop(new Label(
//                "Turno: " +
//                kahoot.obtenerJugadorActual().obtenerNombre())
//        );
    }

    private void mostrarOpciones(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.getChildren().add(obtenerTexto(kahoot));
        vBox.getChildren().add(obtenerOpciones(kahoot));
        this.setCenter(vBox);
    }

    private HBox obtenerOpciones(Kahoot kahoot) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        List<Opcion> opciones = kahoot.obtenerOpciones();
        opciones.forEach(opcion ->
                hBox.getChildren().add(new OpcionDefaultVista(opcion))
        );
        return hBox;
    }

    private HBox obtenerTexto(Kahoot kahoot) {
        Label lblPregunta = new Label(kahoot.obtenerTextoDePregunta());
        lblPregunta.setFont(new Font(26));
        HBox hBox = new HBox(lblPregunta);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(30, 0, 50, 0));
        return hBox;
    }
}
