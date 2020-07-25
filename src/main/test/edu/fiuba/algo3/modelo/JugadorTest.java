package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorTest {
    @Test
    public void jugadorSeCreaConNombre(){
        var nombre = "Pepe";
        var jugador = new Jugador(nombre);

        Assertions.assertEquals(nombre, jugador.obtenerNombre());
    }

    @Test
    public void jugadorSeCreaConPuntajeCero() {
        var nombre = "Pepe";
        var jugador = new Jugador(nombre);

        Assertions.assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void jugadorActualizarPuntajeSumaPuntosAlosQueElJugadorTiene() {
        var nombre = "Pepe";
        var jugador = new Jugador(nombre);

        jugador.actualizarPuntaje(1);

        Assertions.assertEquals(1, jugador.obtenerPuntaje());
    }
}
