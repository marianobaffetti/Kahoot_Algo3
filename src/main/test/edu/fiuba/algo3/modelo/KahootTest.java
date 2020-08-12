package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedenAgregarPreguntasSiNoHayJugadoresError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class KahootTest {
    @BeforeEach
    public void reiniciarKahoot() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field kahoot = Kahoot.class.getDeclaredField("instance");
        kahoot.setAccessible(true);
        kahoot.set(null, null);
    }

    @Test
    public void kahootAvanzaALaSiguienteRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Jugador> jugadores = List.of(new Jugador("Pepe", new ArrayList<>()));
        var pregunta1 = new VerdaderoFalso("1", opciones);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarJugadores(jugadores);
        kahoot.agregarPreguntas(List.of(pregunta1));
        Assertions.assertFalse(kahoot.hayRondaEnJuego());

        kahoot.siguienteRonda();

        Assertions.assertTrue(kahoot.hayRondaEnJuego());
    }

    @Test
    public void kahootObtenerNumeroDeRondaDeVuelveNumeroDeRondaActual() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Jugador> jugadores = List.of(new Jugador("Pepe", new ArrayList<>()));

        var pregunta1 = new VerdaderoFalso("1", opciones);
        var pregunta2 = new VerdaderoFalso("2", opciones);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarJugadores(jugadores);
        kahoot.agregarPreguntas(List.of(pregunta1, pregunta2));
        Assertions.assertFalse(kahoot.hayRondaEnJuego());

        kahoot.siguienteRonda();
        kahoot.siguienteRonda();

        Assertions.assertEquals(2, kahoot.obtenerNumeroDeRonda());
    }

    @Test
    public void siSeAgreganPreguntasAntesDeAgregarJugadoresSeLanzaExcepcionCorrespondiente() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        List<Pregunta> preguntas = List.of(new VerdaderoFalso("1", opciones));
        var kahoot = Kahoot.getInstance();

        Assertions.assertThrows(NoSePuedenAgregarPreguntasSiNoHayJugadoresError.class, ()-> kahoot.agregarPreguntas(preguntas));
    }
}
