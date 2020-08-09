package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KahootTest {
    @Test
    public void kahootAvanzaALaSiguienteRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Jugador> jugadores = List.of(new Jugador("Pepe", new ArrayList<>()));
        Ronda ronda = new Ronda(new VerdaderoFalso("1", opciones), jugadores);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarRondas(List.of(ronda));
        kahoot.agregarJugadores(jugadores);
        Assertions.assertFalse(kahoot.hayRondaEnJuego());

        kahoot.siguienteRonda();

        Assertions.assertTrue(kahoot.hayRondaEnJuego());
    }
}
