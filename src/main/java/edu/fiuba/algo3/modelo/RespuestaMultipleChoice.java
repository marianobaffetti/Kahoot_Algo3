package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements IRespuesta{
    private final ArrayList<Opcion> opcionesElegidas;
    private final Jugador jugador;

    public RespuestaMultipleChoice(ArrayList<Opcion> opcionesElegidas, Jugador jugador) {
        this.opcionesElegidas = opcionesElegidas;
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public ArrayList<Opcion> obtenerOpcionesElegidas(){
        return this.opcionesElegidas;
    }
}
