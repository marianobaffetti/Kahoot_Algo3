package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OpcionGroupChoiceVista extends HBox {
    private final ChoiceBox<String> gruposChoiceBox;
    private final Opcion opcion;

    public OpcionGroupChoiceVista(Pregunta pregunta, Opcion opcion) {
        this.opcion = opcion;
        var grupos = ((GroupChoice) pregunta) .obtenerGrupos();

        this.gruposChoiceBox = new ChoiceBox<String>();
        gruposChoiceBox.setItems(FXCollections.observableArrayList(
                grupos)
        );

        gruposChoiceBox.setPadding(new Insets(10, 20, 10, 10));

        this.getChildren().add(new Label(opcion.obtenerTexto()));
        this.getChildren().add(gruposChoiceBox);
        this.setPadding(new Insets(0, 5, 0, 5));
    }

    public OpcionGroupChoice obtenerOpcion(){
        return new OpcionGroupChoice(this.opcion.obtenerTexto(), this.gruposChoiceBox.getValue());
    }
}
