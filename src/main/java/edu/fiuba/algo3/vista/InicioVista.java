package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class InicioVista extends BorderPane {

    private final KahootControlador controlador;

    public InicioVista(KahootControlador controlador) {
        this.controlador = controlador;
        establecerFondoDePantalla();
        agregarBotonDeInicio();
    }

    private void establecerFondoDePantalla() {
        var url = "https://farusac.edu.gt/herramientas/wp-content/uploads/sites/24/2019/05/kahootlogo_purple-1-1024x998.png";
        Image backgroundImage = new Image(url, 640, 800, true, true);
        ImageView imageView = new ImageView(backgroundImage);
        this.getChildren().add(imageView);
    }

    private void agregarBotonDeInicio() {
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setOnMouseClicked((event) -> this.controlador.iniciarJuego());
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(50, 50, 50, 50));
        this.setBottom(hBox);
    }
}
