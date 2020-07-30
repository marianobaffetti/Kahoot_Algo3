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
        // Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        // correctamente puntos a los jugadores que respondieron correctamente
        int puntosEsperadosJugadorUno = 1;
        int puntosEsperadosJugadorDos = 0;

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

        Assertions.assertEquals(jugadorUno.obtenerPuntaje(), puntosEsperadosJugadorUno);
        Assertions.assertEquals(jugadorDos.obtenerPuntaje(), puntosEsperadosJugadorDos);
    }

    @Test
    public void PreguntaVerdaderoFalsoConPenalidadSeCreaIndicandoleLaRespuestaCorrecta() {
        // Una Pregunta de Verdadero/Falso con penalidad puede crearse indicándole cual es la
        // respuesta correcta
        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Verdadero", true);
        var opcion2 = new Opcion("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);


        var opcionesCorrectas = new ArrayList<Opcion>();
        var opcionesIncorrectas = new ArrayList<Opcion>();

        opcionesCorrectas.add(opcion1);
        opcionesIncorrectas.add(opcion2);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearVerdaderOFalso("Colón llegó a América en el siglo XV.", opciones)
                .conPenalidad()
                .get();

        var respuesta = new RespuestaVerdaderoFalso(opcionesCorrectas, jugadorUno);
        var respuestaIncorrecta = new RespuestaVerdaderoFalso(opcionesIncorrectas, jugadorDos);

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuestaIncorrecta));
        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaMultipleChoiceClasicoSeCreaIndicandoleLasOpcionesCorrectas() {
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

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Que colores tiene la bandera Argentina.", opciones).get();

        var opcionesCorrecta = new ArrayList<Opcion>();
        opcionesCorrecta.add(opcion1);
        opcionesCorrecta.add(opcion2);
        opcionesCorrecta.add(opcion4);
        var respuesta = new RespuestaMultipleChoice(opcionesCorrecta, new Jugador("Pepe"));

        var opcionesIncorrectas = new ArrayList<Opcion>();
        opcionesIncorrectas.add(opcion1);
        opcionesIncorrectas.add(opcion3);
        var respuestaIncorrecta = new RespuestaMultipleChoice(opcionesIncorrectas, new Jugador("Pepin"));

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuestaIncorrecta));
        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaMultipleChoiceConPuntajeParcialSeCreaIndicandoleLasOpcionesCorrectas() {
        var opcion1 = new Opcion("Celeste", true);
        var opcion2 = new Opcion("Blanco", true);
        var opcion3 = new Opcion("Marron", false);
        var opcion4 = new Opcion("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones)
                .conPuntajeParcial()
                .get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcion1);
        opcionesJugadorUno.add(opcion2);

        var respuestaJugadoUno = new RespuestaMultipleChoice(opcionesJugadorUno, new Jugador("Pepe"));

        var respuesta = new ArrayList<IRespuesta>();
        respuesta.add(respuestaJugadoUno);

        var resultadoJugadorUno = pregunta.obtenerResultados(respuesta).get(0);

        Assertions.assertEquals(resultadoJugadorUno.obtenerPuntaje(), 2);
    }

    @Test
    public void PreguntaMultipleChoiceConPuntajeParcialOtorgaPuntosALosJugadoresCorrectamente() {

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Celeste", true);
        var opcion2 = new Opcion("Blanco", true);
        var opcion3 = new Opcion("Marron", false);
        var opcion4 = new Opcion("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones)
                .conPuntajeParcial()
                .get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcion1);
        opcionesJugadorUno.add(opcion2);

        var opcionesJugadorDos = new ArrayList<Opcion>();
        opcionesJugadorDos.add(opcion2);
        opcionesJugadorDos.add(opcion3);


        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(opcionesJugadorUno, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(opcionesJugadorDos, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();
        assertEquals(jugadorUno.obtenerPuntaje(), 2);
        assertEquals(jugadorDos.obtenerPuntaje(), 0);
    }

    @Test
    public void PreguntaVerdaderoFalsoConPenalidadOtorgaPuntosCorrectamente() {
        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Verdadero", true);
        var opcion2 = new Opcion("Falso", false);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var opcionesCorrectas = new ArrayList<Opcion>();
        var opcionesIncorrectas = new ArrayList<Opcion>();

        opcionesCorrectas.add(opcion1);
        opcionesIncorrectas.add(opcion2);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones)
                .conPenalidad()
                .get();

        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(opcionesCorrectas, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(opcionesIncorrectas, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(jugadorUno.obtenerPuntaje(), 1);
        assertEquals(jugadorDos.obtenerPuntaje(), -1);
    }

    @Test
    public void PreguntaMultipleChoiceClasicoOtorgaPuntosALosJugadoresCorrectamente() {

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new Opcion("Celeste", true);
        var opcion2 = new Opcion("Blanco", true);
        var opcion3 = new Opcion("Marron", false);
        var opcion4 = new Opcion("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones).get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcion1);
        opcionesJugadorUno.add(opcion2);
        opcionesJugadorUno.add(opcion4);

        var opcionesJugadorDos = new ArrayList<Opcion>();
        opcionesJugadorDos.add(opcion1);
        opcionesJugadorDos.add(opcion2);

        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(opcionesJugadorUno, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(opcionesJugadorDos, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(jugadorUno.obtenerPuntaje(), 1);
        assertEquals(jugadorDos.obtenerPuntaje(), 0);
    }
}