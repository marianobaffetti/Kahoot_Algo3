package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

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
        establecerFondoDePantalla();
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
    public void update(Observable observable, Object o) {
        this.mostrarMensaje("Empieza el juego!!!");
    }

    public String getTitle() {
        return "Kahoot";
    }
}
