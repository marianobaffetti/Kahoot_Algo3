package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RondaTest {
    @Test
    public void rondaIniciaSeleccionadoPrimerJugador() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Jugador> jugadores = List.of(new Jugador("Pepe", new ArrayList<>()));
        Ronda ronda = new Ronda(new VerdaderoFalso("1", opciones), jugadores);

        ronda.iniciar();

        Assertions.assertEquals("Pepe", ronda.jugadorActual().obtenerNombre());
    }

    @Test
    public void rondaLuegoDeAgregarRespuestaSeleccionaSiguienteJugador() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
                List < Jugador > jugadores = List.of(
                        pepe,
                        new Jugador("Pepin", new ArrayList<>())
                );
        Ronda ronda = new Ronda(new VerdaderoFalso("1", opciones), jugadores);
        ronda.iniciar();
        ronda.agregarRespuesta(new Respuesta(opciones, pepe));

        Assertions.assertEquals("Pepin", ronda.jugadorActual().obtenerNombre());
    }
}
