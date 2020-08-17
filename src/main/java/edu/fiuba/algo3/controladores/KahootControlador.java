package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;

public class KahootControlador {
    public void iniciarJuego() {
        Kahoot.getInstance().iniciar();
        Kahoot.getInstance().notifyObservers();
    }

    public void limpiarMensaje() {
        Kahoot.getInstance().limpiarMensaje();
    }

    public void agrandarPantalla() {
    }

    public void cerrarJuego() {
    }

    public void clickEnSiguiente() {
        Kahoot.getInstance().mostrarPregunta();
        Kahoot.getInstance().notifyObservers();
    }
}
