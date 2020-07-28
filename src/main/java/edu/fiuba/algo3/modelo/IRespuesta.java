package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface IRespuesta {

    ArrayList<Opcion> obtenerOpcionesElegidas();

    Jugador obtenerJugador();
}
