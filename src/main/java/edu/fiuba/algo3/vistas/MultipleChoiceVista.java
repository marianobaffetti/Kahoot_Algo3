package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.MultipleChoiceControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleChoiceVista extends PreguntaVista {

    private final List<OpcionMultipleChoiceVista> opcionesVistas;

    public MultipleChoiceVista(Kahoot kahoot) {
        this.opcionesVistas = new ArrayList<>();
        mostrarEncabezado(kahoot);
        mostrarBonificaciones(kahoot);
        mostrarOpciones(kahoot);
        this.setStyle("-fx-background-color: #9E31F2");
    }

    private List<Opcion> obtenerOpciones() {
        return this.opcionesVistas
                .stream()
                .filter(vista -> vista.seleccionada())
                .map(vista -> vista.obtenerOpcion())
                .collect(Collectors.toList());
    }

    protected void mostrarOpciones(Kahoot kahoot) {
        HBox hBox = new HBox();

        VBox vBoxOpciones = new VBox();
        vBoxOpciones.getChildren().add(obtenerTexto(kahoot));

        VBox vBox1 = obtenerVistaDeOpciones(kahoot);
        vBox1.setPadding(new Insets(0, 0, 0, 100));

        VBox vBoxBtnEnviar = new VBox();
        Button btnEnviar = new Button("Enviar");
        MultipleChoiceControlador controlador = new MultipleChoiceControlador();
        btnEnviar.setOnMouseClicked((evento) -> {
            if (haySeleccionada()) {
                controlador.clickEnEnviar(this.obtenerOpciones());
            } else {
                mostrarMensajeDeValidacion("Se debe seleccionar al menos una opción.", "No hay selección");
            }
        });
        btnEnviar.setStyle("-fx-background-radius: 90;");
        vBoxBtnEnviar.getChildren().add(btnEnviar);
        vBoxBtnEnviar.setAlignment(Pos.BOTTOM_RIGHT);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(250);
        hBox2.getChildren().add(vBox1);
        hBox2.getChildren().add(vBoxBtnEnviar);

        vBoxOpciones.getChildren().add(hBox2);

        hBox.getChildren().add(vBoxOpciones);
        this.setCenter(hBox);
    }

    private boolean haySeleccionada() {
        return this.opcionesVistas
            .stream()
            .anyMatch( opcion -> opcion.estaSeleccionada());
    }

    protected VBox obtenerVistaDeOpciones(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        List<Opcion> opciones = kahoot.obtenerOpciones();

        opciones.forEach(opcion -> {
            var opcionVista = new OpcionMultipleChoiceVista(opcion);
            this.opcionesVistas.add(opcionVista);

            vBox.getChildren().add(opcionVista);
        });

        return vBox;
    }
}
