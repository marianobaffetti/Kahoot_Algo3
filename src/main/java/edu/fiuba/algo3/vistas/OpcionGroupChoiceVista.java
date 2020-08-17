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

        gruposChoiceBox.setStyle("-fx-background-radius: 90;");

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
        this.getChildren().add(gruposChoiceBox);
        this.setMaxWidth(400);
        this.setPadding(new Insets(10, 10, 10, 100));
//        this.setPadding(new Insets(0, 5, 0, 5));
    }

    public OpcionGroupChoice obtenerOpcion(){
        return new OpcionGroupChoice(this.opcion.obtenerTexto(), this.gruposChoiceBox.getValue());
    }
}
