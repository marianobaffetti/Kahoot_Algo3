package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.input.KeyEvent;

public class KahootControlador {

    public void iniciarJuego() {
        Kahoot.getInstance().iniciar();
        Kahoot.getInstance().notifyObservers();
    }
}
