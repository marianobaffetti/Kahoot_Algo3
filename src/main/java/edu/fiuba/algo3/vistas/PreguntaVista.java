package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public abstract class PreguntaVista extends BorderPane {
    protected void mostrarBonificaciones(Kahoot kahoot) {
        this.setBottom(new BonificacionesVista(kahoot));
    }

    protected void mostrarEncabezado(Kahoot kahoot) {
        this.setTop(new EncabezadoPreguntaVista(kahoot));
    }

    protected abstract void mostrarOpciones(Kahoot kahoot);

    protected void mostrarMensajeDeValidacion(String mensaje, String titulo) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.show();
    }

    protected abstract Pane obtenerVistaDeOpciones(Kahoot kahoot);

    protected Pane obtenerTexto(Kahoot kahoot) {
        Label lblPregunta = new Label(kahoot.obtenerTextoDePregunta());
        lblPregunta.setStyle("-fx-font-size: 26;" +
                "-fx-text-fill: white;"
        );
        lblPregunta.setWrapText(true);
        HBox hBox = new HBox(lblPregunta);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(30, 50, 30, 100));
        return hBox;
    }
}
