package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Respuesta {

    List<Opcion> obtenerOpcionesElegidas();

    Jugador obtenerJugador();
}
