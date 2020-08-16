package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_3_Test{
    @BeforeEach
    public void reiniciarKahoot() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field kahoot = Kahoot.class.getDeclaredField("instance");
        kahoot.setAccessible(true);
        kahoot.set(null, null);
    }

    @Test
    public void ExclusividadDePuntajeSeAplicaCorrectamente() {

        var jugadorUno = new Jugador("Pepe", new ArrayList<EstrategiaDeMultiplicacion>());
        var jugadorDos = new Jugador("Pepin", new ArrayList<EstrategiaDeMultiplicacion>());

        var opcion1 = new OpcionDefault("Verdadero", true);
        var opcion2 = new OpcionDefault("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var opcionCorrecta = new ArrayList<Opcion>();
        var opcionIncorrecta = new ArrayList<Opcion>();

        opcionCorrecta.add(opcion1);
        opcionIncorrecta.add(opcion2);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearVerdaderOFalso("Colón llegó a América en el siglo XV.", opciones).get();

        var jugadores = new ArrayList<Jugador>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionCorrecta, jugadorUno);
        var respuestaJugadorDos = new Respuesta(opcionIncorrecta, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.usarExclusividad(jugadorUno);

        ronda.finalizar();

        Assertions.assertEquals(2, jugadorUno.obtenerPuntaje());
        Assertions.assertEquals(0, jugadorDos.obtenerPuntaje());
    }


    @Test
    public void cuandoElUltimoJugadorRespondeSePasaALaSiguienteRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
        List <Jugador> jugadores = List.of(pepe);
        var pregunta1 = new VerdaderoFalso("1", opciones);
        var pregunta2 = new VerdaderoFalso("2", opciones);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarJugadores(List.of(pepe));
        kahoot.agregarPreguntas(List.of(pregunta1, pregunta2));
        kahoot.iniciar();
        kahoot.agregarRespuesta(opciones);

        Assertions.assertEquals(2, Kahoot.getInstance().obtenerNumeroDeRonda());
    }

    @Test
    public void kahootSeIniciaConRondasYJugadoresYDevuelveNumeroDeRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
        List <Jugador> jugadores = List.of(pepe);
        var pregunta1 = new VerdaderoFalso("1", opciones);
        var pregunta2 = new VerdaderoFalso("2", opciones);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarJugadores(List.of(pepe));
        kahoot.agregarPreguntas(List.of(pregunta1, pregunta2));
        kahoot.iniciar();

        Assertions.assertEquals(1, Kahoot.getInstance().obtenerNumeroDeRonda());
        Assertions.assertEquals("1", Kahoot.getInstance().obtenerRondaActual().obtenerPregunta().obtenerTexto());
    }
}