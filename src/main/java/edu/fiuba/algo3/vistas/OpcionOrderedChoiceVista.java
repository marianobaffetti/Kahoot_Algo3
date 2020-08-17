package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class OpcionOrderedChoiceVista extends HBox {
    private final Opcion opcion;
    private final ChoiceBox<String> ordenChoiceBox;

    public OpcionOrderedChoiceVista(Pregunta pregunta, Opcion opcion) {
        this.opcion = opcion;
        var cantidadDeOpciones = pregunta.obtenerOpciones().size();

        var orden = new ArrayList<String>();
        Integer i = 1;
        for (i = 1; i <= cantidadDeOpciones; i++) {
            orden.add(i.toString());
        }

        this.ordenChoiceBox = new ChoiceBox<>();
        ordenChoiceBox.setItems(FXCollections.observableArrayList(
                orden)
        );
        ordenChoiceBox.setStyle("-fx-background-radius: 90;");

        Label lblTexto = new Label(opcion.obtenerTexto());
        lblTexto.setStyle("-fx-text-fill: white;");
        lblTexto.setMinWidth(100);

        this.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 90;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: white;" +
                "-fx-background-color: #A946F5;" +
                "-fx-background-radius: 90;"
        );
        this.getChildren().add(lblTexto);
        this.getChildren().add(ordenChoiceBox);
        this.setMaxWidth(400);
        this.setPadding(new Insets(10, 10, 10, 100));
    }

    public OpcionOrderedChoice obtenerOpcion() {
        return new OpcionOrderedChoice(this.opcion.obtenerTexto(), Integer.parseInt(this.ordenChoiceBox.getValue()));
    }
}
