package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    public void PreguntaVerdaderoFalsoClasicoSeCreaYSeVerificaRespuesta() {
        // Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
        // correcta

        // Respuesta correcta
        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", true);
        var respuesta = new RespuestaVerdaderoFalso(true, jugadorUno);
        var resultado = pregunta.obtenerResultado(respuesta);

        Assertions.assertTrue(resultado.esCorrecto());

        // Respuesta incorrecta

        pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", true);
        respuesta = new RespuestaVerdaderoFalso(false, jugadorDos);
        resultado = pregunta.obtenerResultado(respuesta);

        Assertions.assertFalse(resultado.esCorrecto());
    }

    @Test
    public void PreguntaVerdaderoFalsoClasicoRecibeMultiplesRespuestasYAsignaPuntosAJugadores() {
        // Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        // correctamente puntos a los jugadores que respondieron correctamente
        int puntosEsperadosJugadorUno = 1;
        int puntosEsperadosJugadorDos = 0;

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", true);
        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(true, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(false, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        Assertions.assertEquals(jugadorUno.obtenerPuntaje(), puntosEsperadosJugadorUno);
        Assertions.assertEquals(jugadorDos.obtenerPuntaje(), puntosEsperadosJugadorDos);
    }

    @Test
    public void PreguntaVerdaderoFalsoConPenalidadSeCreaIndicandoleLaRespuestaCorrecta() {
        // Una Pregunta de Verdadero/Falso con penalidad puede crearse indicándole cual es la
        // respuesta correcta
        var pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.",true);
        var proxyPreguntaConPenalidad = new ProxyConPenalidad(pregunta);
        var respuesta = new RespuestaVerdaderoFalso(true, new Jugador("Pepe"));


        Assertions.assertTrue(proxyPreguntaConPenalidad.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaMultipleChoiceSeCreaIndicandoleLasOpcionesCorrectas() {
        // Una Pregunta de Múltiple Choice clásico puede crearse indicándole cuales son las opciones
        // correctas

        var opcion1 = new Opcion("Celeste", true);
        var opcion2 = new Opcion("Blanco", true);
        var opcion3 = new Opcion("Marron", false);
        var opcion4 = new Opcion("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        var pregunta = new MultipleChoice("Que colores tiene la bandera Argentina.", opciones);
        var opcionesCorrecta = new ArrayList<Opcion>();
        opcionesCorrecta.add(opcion1);
        opcionesCorrecta.add(opcion2);
        opcionesCorrecta.add(opcion4);
        var respuesta = new RespuestaMultipleChoice(opcionesCorrecta, new Jugador("Pepe"));
        
        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));
    }
}