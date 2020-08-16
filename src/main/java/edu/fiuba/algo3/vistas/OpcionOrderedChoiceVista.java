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

        var grupos = new ArrayList<String>();
        Integer i = 1;
        for (i = 1; i <= cantidadDeOpciones; i++) {
            grupos.add(i.toString());
        }

        this.ordenChoiceBox = new ChoiceBox<>();
        ordenChoiceBox.setItems(FXCollections.observableArrayList(
                grupos)
        );

        ordenChoiceBox.setPadding(new Insets(10, 20, 10, 10));

        this.getChildren().add(new Label(opcion.obtenerTexto()));
        this.getChildren().add(ordenChoiceBox);
        this.setPadding(new Insets(0, 5, 0, 5));
    }

    public OpcionOrderedChoice obtenerOpcion() {
        return new OpcionOrderedChoice(this.opcion.obtenerTexto(), Integer.parseInt(this.ordenChoiceBox.getValue()));
    }
}
