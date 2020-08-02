package edu.fiuba.algo3.modelo;

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

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Verdadero", true);
        var opcion2 = new Opcion("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var opcionesCorrectas = new ArrayList<Opcion>();
        opcionesCorrectas.add(opcion1);

        var builder = new PreguntasBuilder();

        var pregunta = builder.crearVerdaderOFalso("Colón llegó a América en el siglo XV.", opciones).get();
        var respuesta = new RespuestaVerdaderoFalso(opcionesCorrectas, jugadorUno);

        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));

        // Respuesta incorrecta

        var opcionesIncorrectas = new ArrayList<Opcion>();
        opcionesIncorrectas.add(opcion2);

        pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", opciones);
        respuesta = new RespuestaVerdaderoFalso(opcionesIncorrectas, jugadorDos);

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaVerdaderoFalsoClasicoRecibeMultiplesRespuestasYAsignaPuntosAJugadores() {
        /*
            Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente
        */

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Verdadero", true);
        var opcion2 = new Opcion("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var opcionCorrecta = new ArrayList<Opcion>();
        var opcionIncorrecta = new ArrayList<Opcion>();

        opcionCorrecta.add(opcion1);
        opcionIncorrecta.add(opcion2);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearVerdaderOFalso("Colón llegó a América en el siglo XV.", opciones).get();

        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(opcionCorrecta, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(opcionIncorrecta, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        Assertions.assertEquals(1, jugadorUno.obtenerPuntaje());
        Assertions.assertEquals(0, jugadorDos.obtenerPuntaje());
    }
}