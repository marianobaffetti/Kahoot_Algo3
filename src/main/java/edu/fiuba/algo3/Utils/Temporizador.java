package edu.fiuba.algo3.Utils;

import edu.fiuba.algo3.controladores.TimerControlador;
import javafx.scene.control.Label;

import java.sql.Time;
import java.util.Timer;

public class Temporizador {
    private static Temporizador instance;
    private TareaProgramada tareaProgramada;
    private Timer timer;

    private Temporizador() {
        this.timer = new Timer();
    }

    public static Temporizador getInstance() {
        if (instance == null) instance = new Temporizador();
        return instance;
    }

    public void iniciar(Integer ciclosTotales, Label lblTimer, TimerControlador controlador) {
        if (this.tareaProgramada != null) this.tareaProgramada.cancel();
        this.tareaProgramada = new TareaProgramada(ciclosTotales, lblTimer, controlador);
        this.timer.schedule(this.tareaProgramada, 0, 1000);
    }

    public void detener() {
        this.tareaProgramada.cancel();
    }
}
