package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;

public class TimerControlador {
    public void perderTurno() {
        Kahoot.getInstance().perderTurno();
        Kahoot.getInstance().notifyObservers();
    }
}
