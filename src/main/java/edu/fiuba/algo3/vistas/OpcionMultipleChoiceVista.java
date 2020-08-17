package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VerdaderoFalsoControlador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public class OpcionMultipleChoiceVista extends HBox {
    private final CheckBox checkBoxOpcion;
    private final Opcion opcion;

    public OpcionMultipleChoiceVista(Opcion opcion) {
        this.opcion = opcion;
        checkBoxOpcion = new CheckBox();
        checkBoxOpcion.setPadding(new Insets(10, 20, 10, 15));

        Label lblTexto = new Label(opcion.obtenerTexto());
        lblTexto.setStyle("-fx-text-fill: white;");
        lblTexto.setMinWidth(100);
        lblTexto.setPadding(new Insets(10, 0, 10, 0));

        this.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 90;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: white;" +
                "-fx-background-color: #A946F5;" +
                "-fx-background-radius: 90;"
        );
        this.getChildren().add(checkBoxOpcion);
        this.getChildren().add(lblTexto);
        this.setMaxWidth(100);
    }

    public boolean seleccionada() {
        return this.checkBoxOpcion.isSelected();
    }

    public Opcion obtenerOpcion() {
        return this.opcion;
    }
}
