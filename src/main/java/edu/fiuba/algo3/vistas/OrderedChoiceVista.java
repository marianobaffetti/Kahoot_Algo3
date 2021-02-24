package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.OrderChoiceControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderedChoiceVista extends PreguntaVista{
    private List<OpcionOrderedChoiceVista> opcionesVistas;

    public OrderedChoiceVista(Kahoot kahoot) {
        this.opcionesVistas = new ArrayList<>();
        mostrarEncabezado(kahoot);
        mostrarBonificaciones(kahoot);
        mostrarTimer(kahoot);
        mostrarOpciones(kahoot);
        this.setStyle("-fx-background-color: #9E31F2");
    }

    @Override
    protected void mostrarOpciones(Kahoot kahoot) {
        HBox hBox = new HBox();

        VBox vBoxOpciones = new VBox();
        vBoxOpciones.getChildren().add(obtenerTexto(kahoot));

        VBox vBox1 = obtenerVistaDeOpciones(kahoot);
        vBox1.setPadding(new Insets(0, 0, 0, 100));

        VBox vBoxBtnEnviar = new VBox();
        Button btnEnviar = new Button("Enviar");
        var controlador = new OrderChoiceControlador();
        btnEnviar.setOnMouseClicked((evento) -> {
            if(!todasSelecionadas()) {
                mostrarMensajeDeValidacion("Se dedeben seleccionar todas las opciones posibles.", "Respuesta incompleta");
            } else if(hayRepetidas()) {
                mostrarMensajeDeValidacion("Las opciones deben tener orden distinto.", "Orden repetido");
            } else {
                controlador.clickEnEnviar(obtenerOpciones());
            }
        });
        btnEnviar.setStyle("-fx-background-radius: 90;");
        vBoxBtnEnviar.getChildren().add(btnEnviar);
        vBoxBtnEnviar.setAlignment(Pos.BOTTOM_RIGHT);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(150);
        hBox2.getChildren().add(vBox1);
        hBox2.getChildren().add(vBoxBtnEnviar);

        vBoxOpciones.getChildren().add(hBox2);

        hBox.getChildren().add(vBoxOpciones);
        hBox.setAlignment(Pos.CENTER);
        this.setCenter(hBox);
    }

    private boolean hayRepetidas() {
        return this.opcionesVistas
            .stream()
            .map(opcion -> opcion.obtenerSeleccion())
            .distinct()
            .count() != this.opcionesVistas.size();
    }

    private boolean todasSelecionadas() {
        return this.opcionesVistas
                .stream()
                .allMatch( opcion -> opcion.estaSeleccionada());
    }

    @Override
    protected VBox obtenerVistaDeOpciones(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        List<Opcion> opciones = kahoot.obtenerOpciones();

        opciones.forEach(opcion -> {
            var opcionVista = new OpcionOrderedChoiceVista(kahoot.obtenerRondaActual().obtenerPregunta(), opcion);
            this.opcionesVistas.add(opcionVista);
            vBox.getChildren().add(opcionVista);
        });

        return vBox;
    }

    private List<Opcion> obtenerOpciones() {
        return this.opcionesVistas
                .stream()
                .map(vista -> vista.obtenerOpcion())
                .collect(Collectors.toList());
    }
}
