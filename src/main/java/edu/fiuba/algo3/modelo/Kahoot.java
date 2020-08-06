package edu.fiuba.algo3.modelo;

import java.util.Observable;

public class Kahoot extends Observable {
    private static Kahoot kahoot;

    private Kahoot() {
    }

    public static Kahoot getInstance() {
        if (kahoot == null) kahoot = new Kahoot();
        return kahoot;
    }

    public void iniciar() {
        setChanged();
    }
}
