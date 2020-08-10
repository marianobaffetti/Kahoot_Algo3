package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class VerdaderoFalsoVista extends BorderPane {
    private final KahootControlador controlador;

    public VerdaderoFalsoVista(KahootControlador controlador, Kahoot kahoot) {
        this.controlador = controlador;
        mostrarTextoDePregunta(kahoot);
        mostrarOpciones(kahoot);
    }

    private void mostrarOpciones(Kahoot kahoot) {
        List<Opcion> opciones = kahoot.obtenerOpciones();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        opciones.forEach(opcion -> {
            Button botonOpcion = new Button(opcion.obtenerTexto());
            botonOpcion.setPadding(new Insets(20, 20, 20, 20));
            botonOpcion.setMinSize(200, 100);
            VBox box = new VBox(botonOpcion);
            box.setPadding(new Insets(0, 5, 0, 5));
            hBox.getChildren().add(box);
        });

        this.setCenter(hBox);
    }

    private void mostrarTextoDePregunta(Kahoot kahoot) {
        Label lblPregunta = new Label(kahoot.obtenerTextoDePregunta());
        lblPregunta.setFont(new Font(26));
        HBox hBox = new HBox(lblPregunta);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(30, 0, 50, 0));
        this.setTop(hBox);
    }
}
