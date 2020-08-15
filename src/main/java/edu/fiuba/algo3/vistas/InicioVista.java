package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.KahootControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioVista extends BorderPane {

    private final KahootControlador controlador;

    public InicioVista(KahootControlador controlador) {
        this.controlador = controlador;
        establecerFondoDePantalla();
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().add(agregarBotonDeInicio());
        vBox.getChildren().add(agregarBotonPantallaCompleta());
        vBox.getChildren().add(agregarBotonSalir());
        vBox.setPadding(new Insets(0, 0, 50, 0));
        this.setBottom(vBox);
    }

    private HBox agregarBotonSalir() {
        Button botonSalir = new Button("Salir");
        botonSalir.setOnMouseClicked((event) -> this.controlador.cerrarJuego());
        botonSalir.setMinWidth(150);
        HBox hBox = new HBox(botonSalir);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        return hBox;
    }


    private void establecerFondoDePantalla() {
        var url = "https://farusac.edu.gt/herramientas/wp-content/uploads/sites/24/2019/05/kahootlogo_purple-1-1024x998.png";
        Image backgroundImage = new Image(url, 640, 800, true, true);
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setY(-80);
        this.getChildren().add(imageView);
    }

    private HBox agregarBotonPantallaCompleta() {
        Button btnPantallaCompleta = new Button("Pantalla Completa");
        btnPantallaCompleta.setOnMouseClicked((event) -> this.controlador.agrandarPantalla());
        btnPantallaCompleta.setMinWidth(150);
        HBox hBox = new HBox(btnPantallaCompleta);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        return hBox;
    }

    private HBox agregarBotonDeInicio() {
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setOnMouseClicked((event) -> this.controlador.iniciarJuego());
        botonInicio.setMinWidth(150);
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        return hBox;
    }
}
