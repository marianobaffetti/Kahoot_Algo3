package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PreguntaVista extends BorderPane {
    private final KahootControlador controlador;

    public PreguntaVista(KahootControlador controlador) {
        this.controlador = controlador;
    }
}
