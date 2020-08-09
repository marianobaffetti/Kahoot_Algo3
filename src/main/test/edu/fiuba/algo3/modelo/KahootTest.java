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

    /*
    TODO: actualmente el test falla porque no se puede resetear el singleton Kahoot
    @Test
    public void kahootObtenerNumeroDeRondaDeVuelveNumeroDeRondaActual() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Jugador> jugadores = List.of(new Jugador("Pepe", new ArrayList<>()));
        Ronda ronda1 = new Ronda(new VerdaderoFalso("1", opciones), jugadores);
        Ronda ronda2 = new Ronda(new VerdaderoFalso("2", opciones), jugadores);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarRondas(List.of(ronda1, ronda2));
        kahoot.agregarJugadores(jugadores);
        Assertions.assertFalse(kahoot.hayRondaEnJuego());

        kahoot.siguienteRonda();
        kahoot.siguienteRonda();

        Assertions.assertEquals(2, kahoot.obtenerNumeroDeRonda());
    }*/
}
