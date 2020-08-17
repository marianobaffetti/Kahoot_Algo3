package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Utils.TareaProgramada;
import edu.fiuba.algo3.controladores.TimerControlador;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Timer;
import java.util.TimerTask;

public class TimerVista extends HBox {
    private final Integer periodo;
    private final Integer ciclosTotales;
    Timer timer;
    private final Label lblTimer;
    private TareaProgramada tareaProgramada;

    public TimerVista(Integer ciclosTotales, Integer periodo) {
        this.timer = new Timer();
        this.periodo = periodo;
        this.lblTimer = new Label();
        this.ciclosTotales = ciclosTotales;
        this.lblTimer.setText(this.ciclosTotales.toString());
        this.getChildren().add(this.lblTimer);
    }

    public void start() {
        this.tareaProgramada = new TareaProgramada(this.ciclosTotales, this.lblTimer, new TimerControlador());
        this.timer.schedule(tareaProgramada, 0, this.periodo);
    }


}
