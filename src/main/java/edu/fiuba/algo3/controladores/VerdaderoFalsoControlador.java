package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Ronda;

import java.util.List;

public class VerdaderoFalsoControlador {
    public void clickEnBoton(Opcion opcion) {
        Ronda ronda = Kahoot.getInstance().obtenerRondaActual();
        Kahoot.getInstance().agregarRespuesta(
            new Respuesta(List.of(opcion), ronda.jugadorActual())
        );
        Kahoot.getInstance().notifyObservers();
    }
}
