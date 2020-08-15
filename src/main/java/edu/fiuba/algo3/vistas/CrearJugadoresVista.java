package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.CrearJugadoresControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CrearJugadoresVista extends BorderPane {
    public CrearJugadoresVista(Kahoot kahoot) {
        var controlador = new CrearJugadoresControlador();

        Label lblNombre = new Label("Nombre: ");
        lblNombre.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 12pt;"
        );
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese un nombre");
        HBox hBox1 = new HBox();
        hBox1.getChildren().add(lblNombre);
        hBox1.getChildren().add(txtNombre);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        Button btnAgregar = new Button("Agregar");
        //TODO: Validar que el nombre no esté vacío
        btnAgregar.setOnMouseClicked((evento) -> controlador.agregarJugador(txtNombre.getCharacters().toString()));

        //TODO: Validar que haya la cantidad necesaria de jugadores

        Button btnIniciar = new Button("Iniciar");
        btnIniciar.setDisable(kahoot.obtenerJugadores().size() <= 1);
        btnIniciar.setOnMouseClicked((event) -> controlador.iniciarRondas());

        hBox2.getChildren().add(btnAgregar);
        hBox2.getChildren().add(btnIniciar);
        hBox2.setPadding(new Insets(0, 0, 0, 80));

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(new ReglasVista(kahoot));
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setPadding(new Insets(85, 0, 0, 60));

        this.setCenter(vBox);

        this.setStyle("-fx-background-color: #9E31F2");
        this.setRight(new ListaJugadoresVista(kahoot));
    }
}

