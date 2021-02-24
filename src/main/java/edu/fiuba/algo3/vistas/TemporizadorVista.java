package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Utils.Temporizador;
import edu.fiuba.algo3.controladores.TimerControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TemporizadorVista extends HBox {
    private final Integer ciclosTotales;
    private final Label lblTimer;

    public TemporizadorVista(Integer ciclosTotales, Integer periodo) {
        this.lblTimer = new Label();
        this.ciclosTotales = ciclosTotales;
        this.lblTimer.setText(this.ciclosTotales.toString());
        this.lblTimer.setStyle("-fx-text-fill: white;" +
            "-fx-font-size: 12pt;" +
            "-fx-font-weight: bold;"
        );
        this.getChildren().add(this.lblTimer);
        this.setAlignment(Pos.TOP_RIGHT);
        this.setPadding(new Insets(0, 20, 0, 0));
    }

    public void start() {
        Temporizador.getInstance().iniciar(this.ciclosTotales, this.lblTimer, new TimerControlador());
    }


}
