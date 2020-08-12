package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OpcionDefaultVista extends VBox {
    public OpcionDefaultVista(Opcion opcion) {
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setPadding(new Insets(20, 20, 20, 20));
        botonOpcion.setMinSize(200, 100);
        this.getChildren().add(botonOpcion);
        this.setPadding(new Insets(0, 5, 0, 5));
    }
}
