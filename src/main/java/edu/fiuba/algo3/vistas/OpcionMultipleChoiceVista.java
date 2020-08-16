package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VerdaderoFalsoControlador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OpcionMultipleChoiceVista extends HBox {
    private final CheckBox checkBoxOpcion;
    private final Opcion opcion;

    public OpcionMultipleChoiceVista(Opcion opcion) {
        this.opcion = opcion;
        checkBoxOpcion = new CheckBox(opcion.obtenerTexto());
        checkBoxOpcion.setPadding(new Insets(10, 20, 10, 200));
        this.getChildren().add(checkBoxOpcion);
        this.setPadding(new Insets(0, 5, 0, 5));
    }

    public boolean seleccionada() {
        return this.checkBoxOpcion.isSelected();
    }

    public Opcion obtenerOpcion() {
        return this.opcion;
    }
}
