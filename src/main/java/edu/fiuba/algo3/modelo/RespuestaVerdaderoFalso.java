package edu.fiuba.algo3.modelo;

import java.util.List;

public class RespuestaVerdaderoFalso implements Respuesta {
    private final List<Opcion> opcionesElegidas;
    private final Jugador jugador;

    public RespuestaVerdaderoFalso(List<Opcion> opcionesElegidas, Jugador jugador) {
        this.opcionesElegidas = opcionesElegidas;
        this.jugador = jugador;
    }

    public List<Opcion> obtenerOpcionesElegidas() {
        return this.opcionesElegidas;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }
}
