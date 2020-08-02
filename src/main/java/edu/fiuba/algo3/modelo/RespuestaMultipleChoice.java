package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaMultipleChoice implements Respuesta {
    private final List<Opcion> opcionesElegidas;
    private final Jugador jugador;

    public RespuestaMultipleChoice(List<Opcion> opcionesElegidas, Jugador jugador) {
        this.opcionesElegidas = opcionesElegidas;
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public List<Opcion> obtenerOpcionesElegidas() {
        return this.opcionesElegidas;
    }
}
