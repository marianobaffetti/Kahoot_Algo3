package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class VerdaderoFalsoVista extends PreguntaVista {
    public VerdaderoFalsoVista(Kahoot kahoot) {
        mostrarOpciones(kahoot);
        mostrarEncabezado(kahoot);
        mostrarBonificaciones(kahoot);
        this.setStyle("-fx-background-color: #9E31F2");
    }

    @Override
    protected void mostrarOpciones(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.getChildren().add(obtenerTexto(kahoot));
        vBox.getChildren().add(obtenerVistaDeOpciones(kahoot));
        this.setCenter(vBox);
    }

    @Override
    protected Pane obtenerVistaDeOpciones(Kahoot kahoot) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        List<Opcion> opciones = kahoot.obtenerOpciones();
        opciones.forEach(opcion ->
                hBox.getChildren().add(new OpcionVerdaderoOFalsoVista(opcion))
        );
        return hBox;
    }

}
