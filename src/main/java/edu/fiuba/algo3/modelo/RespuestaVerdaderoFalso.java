package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestaVerdaderoFalso implements IRespuesta {
    private final ArrayList<Opcion> opcionesElegidas;
    private final Jugador jugador;

    public RespuestaVerdaderoFalso(ArrayList<Opcion> opcionesElegidas, Jugador jugador) {
        this.opcionesElegidas = opcionesElegidas;
        this.jugador = jugador;
    }

    public ArrayList<Opcion> obtenerOpcionesElegidas() {
        return this.opcionesElegidas;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }
}
