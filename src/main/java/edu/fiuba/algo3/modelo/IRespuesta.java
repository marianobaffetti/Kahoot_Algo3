package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IRespuesta {

    List<Opcion> obtenerOpcionesElegidas();

    Jugador obtenerJugador();
}
