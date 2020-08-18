package edu.fiuba.algo3.Utils;

import edu.fiuba.algo3.controladores.TimerControlador;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class TareaProgramada extends TimerTask {

    private final Integer ciclosTotales;
    private final TimerControlador controlador;
    private Label lblTimer;
    private Integer contador;
    private Integer ciclos;

    public TareaProgramada (Integer ciclosTotales, Label lblTimer, TimerControlador controlador){
        this.contador = ciclosTotales;
        this.ciclosTotales = ciclosTotales;
        this.ciclos = 0;
        this.lblTimer = lblTimer;
        this.controlador = controlador;
    }

    @Override
    public void run() {
        this.ciclos++;
        if (ciclos == ciclosTotales) {
            finalizarTurno();
            this.cancel();
        } else {
            this.contador--;
            Platform.runLater( () -> {
            this.lblTimer.setText(this.contador.toString());
            });
        }
    }

    private void finalizarTurno() {
        Platform.runLater( () -> {
            this.controlador.perderTurno();
            }
        );
    }
}
