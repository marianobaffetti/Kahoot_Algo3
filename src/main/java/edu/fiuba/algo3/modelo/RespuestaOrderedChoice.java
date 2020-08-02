package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RespuestaOrderedChoice implements Respuesta{
    private final Jugador jugador;
    private List<Opcion> opcionesElegidas;

    public RespuestaOrderedChoice(ArrayList<Opcion> opcionesElegidas, Jugador jugador) {
        this.jugador = jugador;
        this.opcionesElegidas = opcionesElegidas;
    }

    @Override
    public List<Opcion> obtenerOpcionesElegidas() {
        return this.opcionesElegidas;
    }

    @Override
    public Jugador obtenerJugador() {
        return this.jugador;
    }
}
