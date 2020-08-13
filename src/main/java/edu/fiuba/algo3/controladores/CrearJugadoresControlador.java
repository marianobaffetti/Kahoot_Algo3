package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;

public class CrearJugadoresControlador {
    public void agregarJugador(String nombre) {
        Kahoot.getInstance().agregarJugador(nombre);
        Kahoot.getInstance().notifyObservers();
    }

    public void iniciarRondas() {
        Kahoot.getInstance().iniciarRondas();
        Kahoot.getInstance().notifyObservers();
    }
}
