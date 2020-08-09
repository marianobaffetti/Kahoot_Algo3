package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.List;

public class Respuesta {
    private final List<Opcion> opcionesElegidas;
    private final Jugador jugador;

    public Respuesta(List<Opcion> opcionesElegidas, Jugador jugador) {
        this.opcionesElegidas = opcionesElegidas;
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public List<Opcion> obtenerOpcionesElegidas() {
        return this.opcionesElegidas;
    }

    public boolean concideCon(Opcion opcion) {
        return this.opcionesElegidas.stream().anyMatch(elegida -> opcion.coincideCon(elegida));
    }
}
