package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.List;

public class VerdaderoFalsoControlador {
    public void clickEnBoton(Opcion opcion) {
        Kahoot.getInstance().agregarRespuesta(List.of(opcion));
        Kahoot.getInstance().notifyObservers();
    }
}
