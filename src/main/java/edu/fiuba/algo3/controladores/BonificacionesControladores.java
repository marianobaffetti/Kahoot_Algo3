package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;

public class BonificacionesControladores {
    public void usarMultiplicadorX2() {
        Kahoot.getInstance().usarMultiplicadorX2();
        Kahoot.getInstance().notifyObservers();
    }

    public void usarMultiplicadorX3() {
    }

    public void usarExclusividad() {
    }
}