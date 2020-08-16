package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Entrega_0_Test {
    @Test
    public void PreguntaVerdaderoFalsoClasicoSeCreaYSeVerificaRespuesta() {
        /*
            Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
            correcta
        */

        var jugadorUno = new Jugador("Pepe", new ArrayList<EstrategiaDeMultiplicacion>());
        var jugadorDos = new Jugador("Pepin", new ArrayList<EstrategiaDeMultiplicacion>());

        var opcion1 = new OpcionDefault("Verdadero", true);
        var opcion2 = new OpcionDefault("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);

        var builder = new PreguntasBuilder();

        var pregunta = builder.crearVerdaderOFalso("Colón llegó a América en el siglo XV.", opciones).get();
        var respuesta = new Respuesta(opcionesCorrectas, jugadorUno);

        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));

        // Respuesta incorrecta

        var opcionesIncorrectas = new ArrayList<Opcion>();
        opcionesIncorrectas.add(opcion2);

        pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", opciones);
        respuesta = new Respuesta(opcionesIncorrectas, jugadorDos);

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaVerdaderoFalsoClasicoRecibeMultiplesRespuestasYAsignaPuntosAJugadores() {
        /*
            Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente
        */

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

        ronda.finalizar();

        Assertions.assertEquals(1, jugadorUno.obtenerPuntaje());
        Assertions.assertEquals(0, jugadorDos.obtenerPuntaje());
    }
}