package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class KahootVista extends BorderPane implements Observer {
    private KahootControlador controlador;

    public KahootVista(KahootControlador controlador, Node nodo) {
        super(nodo);
        inicializar(controlador);
    }

    public KahootVista(KahootControlador controlador) {
        super();
        inicializar(controlador);
    }

    private void inicializar(KahootControlador controlador) {
        this.controlador = controlador;
        /*establecerFondoDePantalla();*/
        agregarBotonDeInicio();
    }

    public void mostrarMensaje(String mensaje) {
        Label label = new Label(mensaje);
        HBox hBox = new HBox(label);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        this.setTop(hBox);
    }

    private void agregarBotonDeInicio() {
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setOnMouseClicked((event) -> this.controlador.iniciarJuego());
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(50, 50, 50, 50));
        this.setBottom(hBox);
    }

    private void establecerFondoDePantalla() {
        var url = "https://farusac.edu.gt/herramientas/wp-content/uploads/sites/24/2019/05/kahootlogo_purple-1-1024x998.png";
        Image backgroundImage = new Image(url, 640, 800, true, true);
        ImageView imageView = new ImageView(backgroundImage);
        this.getChildren().add(imageView);
    }

    @Override
    public void update(Observable modelo, Object o) {
        Kahoot kahoot = (Kahoot) modelo;
        if (kahoot.hayRondaEnJuego()){
            if (kahoot.obtenerTipoDePregunta() == "VERDADERO_O_FALSO") {
                mostrarTextoDePregunta(kahoot);
                mostrarOpciones(kahoot);
            }
        }
        quitarBotonInicio();
    }

    private void mostrarOpciones(Kahoot kahoot) {
        List<Opcion> opciones = kahoot.obtenerOpciones();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        opciones.forEach(opcion -> {
            Button botonOpcion = new Button(opcion.obtenerTexto());
            botonOpcion.setPadding(new Insets(20, 20, 20, 20));
            botonOpcion.setMinSize(200, 100);
            VBox box = new VBox(botonOpcion);
            box.setPadding(new Insets(0, 5, 0, 5));
            hBox.getChildren().add(box);
        });

        this.setCenter(hBox);
    }

    private void quitarBotonInicio() {
        this.setBottom(new Label(""));
    }

    private void mostrarTextoDePregunta(Kahoot kahoot) {
        Label lblPregunta = new Label(kahoot.obtenerTextoDePregunta());
        lblPregunta.setFont(new Font(26));
        HBox hBox = new HBox(lblPregunta);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(30, 0, 50, 0));
        this.setTop(hBox);
    }

    public String getTitle() {
        return "Kahoot";
    }
}
