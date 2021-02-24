package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VerdaderoFalsoControlador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OpcionVerdaderoOFalsoVista extends VBox {
    private final VerdaderoFalsoControlador controlador;

    public OpcionVerdaderoOFalsoVista(Opcion opcion) {
        this.controlador = new VerdaderoFalsoControlador();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnMouseClicked((evento) -> this.controlador.clickEnBoton(opcion));
        botonOpcion.setPadding(new Insets(20, 20, 20, 20));
        botonOpcion.setMinSize(200, 100);
        botonOpcion.setStyle("-fx-background-radius: 90;");
        this.getChildren().add(botonOpcion);
        this.setPadding(new Insets(0, 5, 0, 5));
    }
}
