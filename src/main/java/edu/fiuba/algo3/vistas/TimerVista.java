package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Utils.TareaProgramada;
import edu.fiuba.algo3.Utils.Temporizador;
import edu.fiuba.algo3.controladores.TimerControlador;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVista extends HBox {
    private final Integer ciclosTotales;
    private final Label lblTimer;

    public TimerVista(Integer ciclosTotales, Integer periodo) {
        this.lblTimer = new Label();
        this.ciclosTotales = ciclosTotales;
        this.lblTimer.setText(this.ciclosTotales.toString());
        this.getChildren().add(this.lblTimer);
    }

    public void start() {
        Temporizador.getInstance().iniciar(this.ciclosTotales, this.lblTimer, new TimerControlador());
    }


}
