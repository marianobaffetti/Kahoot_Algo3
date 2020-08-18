package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BonificacionesControladores;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BonificacionesVista extends VBox {
    public BonificacionesVista(Kahoot kahoot) {
        var controlador = new BonificacionesControladores();
        this.setSpacing(10);
        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        Label lblBonificaciones = new Label("Bonificaciones: ");
        lblBonificaciones.setStyle("-fx-text-fill: white;");
        this.getChildren().add(lblBonificaciones);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        Button btnX2 = new Button("X 2");
        btnX2.setStyle("-fx-background-radius: 90;");

        String nombreMultiplicador = kahoot.obtenerJugadorActual().obtenerMultiplicadorEnUso().obtenerNombre();


        btnX2.setOnMouseClicked((evento) -> controlador.usarMultiplicadorX2());
        btnX2.setDisable(!kahoot.obtenerRondaActual().obtenerPregunta().obtenerTipo().contains("CON_PENALIDAD"));

        Button btnX3 = new Button("X 3");
        btnX3.setStyle("-fx-background-radius: 90;");
        btnX3.setOnMouseClicked((evento) -> controlador.usarMultiplicadorX3());
        btnX3.setDisable(!kahoot.obtenerRondaActual().obtenerPregunta().obtenerTipo().contains("CON_PENALIDAD"));

        Button btnExclusividad = new Button(" E ");
        btnExclusividad.setStyle("-fx-background-radius: 90;");
        btnExclusividad.setOnMouseClicked((evento) -> controlador.usarExclusividad());
        btnExclusividad.setDisable(kahoot.obtenerRondaActual().obtenerPregunta().obtenerTipo().contains("CON_PENALIDAD"));

        hBox.getChildren().add(btnX2);
        hBox.getChildren().add(btnX3);
        hBox.getChildren().add(btnExclusividad);

        switch (nombreMultiplicador) {
            case "MULTIPLICADOR_X_2":
                btnX2.setStyle(btnX2.getStyle()+ "-fx-background-color: #5bff33;");
                break;

            case "MULTIPLICADOR_X_3":
                btnX3.setStyle(btnX3.getStyle()+ "-fx-background-color: #5bff33;");
                break;
        }

        if (kahoot.obtenerJugadorActual().activoExclusividad())
            btnExclusividad.setStyle(btnExclusividad.getStyle()+ "-fx-background-color: #5bff33;");


        this.getChildren().add(hBox);
        this.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 1 0 0 0;" +
                "-fx-border-insets: 5;" +
//                "-fx-border-radius: 90;" +
                "-fx-border-color: white;");
    }
}
