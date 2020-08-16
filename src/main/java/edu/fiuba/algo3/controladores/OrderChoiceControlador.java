package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.List;

public class OrderChoiceControlador {
    public void clickEnEnviar(List<Opcion> opciones) {
        Kahoot.getInstance().agregarRespuesta(opciones);
        Kahoot.getInstance().notifyObservers();
    }
}
