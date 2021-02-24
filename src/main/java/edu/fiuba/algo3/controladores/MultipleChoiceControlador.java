package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Utils.Temporizador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.List;

public class MultipleChoiceControlador {
    public void clickEnEnviar(List<Opcion> opciones) {
        Kahoot.getInstance().agregarRespuesta(opciones);
        Temporizador.getInstance().detener();
        Kahoot.getInstance().notifyObservers();
    }
}
