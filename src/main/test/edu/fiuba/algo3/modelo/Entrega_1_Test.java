package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_1_Test {
    @Test
    public void PreguntaVerdaderoFalsoConPenalidadSeCreaIndicandoleLaRespuestaCorrecta() {
        /*
            Una Pregunta de Verdadero/Falso con penalidad puede crearse indicándole cual es la
            respuesta correcta
        */

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new OpcionDefault("Verdadero", true);
        var opcion2 = new OpcionDefault("Falso", false);

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

        var respuesta = new Respuesta(opcionesCorrectas, jugadorUno);
        var respuestaIncorrecta = new Respuesta(opcionesIncorrectas, jugadorDos);

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuestaIncorrecta));
        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaMultipleChoiceClasicoSeCreaIndicandoleLasOpcionesCorrectas() {
        /*
            Una Pregunta de Múltiple Choice clásico puede crearse indicándole cuales son las opciones
            correctas
        */

        var opcionCorrecta1 = new OpcionDefault("Celeste", true);
        var opcionCorrecta2 = new OpcionDefault("Blanco", true);
        var opcionIncorrecta = new OpcionDefault("Marron", false);
        var opcionCorrecta3 = new OpcionDefault("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta3);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Que colores tiene la bandera Argentina.", opciones).get();

        var opcionesCorrecta = new ArrayList<Opcion>();
        opcionesCorrecta.add(opcionCorrecta1);
        opcionesCorrecta.add(opcionCorrecta2);
        opcionesCorrecta.add(opcionCorrecta3);
        var respuesta = new Respuesta(opcionesCorrecta, new Jugador("Pepe"));

        var opcionesIncorrectas = new ArrayList<Opcion>();
        opcionesIncorrectas.add(opcionCorrecta1);
        opcionesIncorrectas.add(opcionIncorrecta);
        var respuestaIncorrecta = new Respuesta(opcionesIncorrectas, new Jugador("Pepin"));

        Assertions.assertFalse(pregunta.respuestaEsCorrecta(respuestaIncorrecta));
        Assertions.assertTrue(pregunta.respuestaEsCorrecta(respuesta));
    }

    @Test
    public void PreguntaMultipleChoiceConPuntajeParcialSeCreaIndicandoleLasOpcionesCorrectas() {
        /*
            Una Pregunta de Múltiple Choice con puntaje parcial puede crearse indicándole cuales son
            las opciones correctas
        */
        var opcionCorrecta1 = new OpcionDefault("Celeste", true);
        var opcionCorrecta2 = new OpcionDefault("Blanco", true);
        var opcionIncorrecta = new OpcionDefault("Marron", false);
        var opcionCorrecta3 = new OpcionDefault("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta3);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones)
                .conPuntajeParcial()
                .get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcionCorrecta1);
        opcionesJugadorUno.add(opcionCorrecta2);

        var respuestaJugadoUno = new Respuesta(opcionesJugadorUno, new Jugador("Pepe"));

        var respuesta = new ArrayList<Respuesta>();
        respuesta.add(respuestaJugadoUno);

        var resultadoJugadorUno = pregunta.obtenerResultados(respuesta).get(0);

        Assertions.assertEquals(2, resultadoJugadorUno.obtenerPuntaje());
    }

    @Test
    public void PreguntaMultipleChoiceConPuntajeParcialOtorgaPuntosALosJugadoresCorrectamente() {
        /*
            Una Pregunta de Multiple Choice con puntaje parcial recibe una lista de respuestas y
            asigna correctamente puntos a los jugadores según las opciones correctas que hayan
            respondido
        */

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcionCorrecta1 = new OpcionDefault("Celeste", true);
        var opcionCorrecta2 = new OpcionDefault("Blanco", true);
        var opcionIncorrecta = new OpcionDefault("Marron", false);
        var opcionCorrecta3 = new OpcionDefault("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta3);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones)
                .conPuntajeParcial()
                .get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcionCorrecta1);
        opcionesJugadorUno.add(opcionCorrecta2);

        var opcionesJugadorDos = new ArrayList<Opcion>();
        opcionesJugadorDos.add(opcionCorrecta2);
        opcionesJugadorDos.add(opcionIncorrecta);

        var jugadores = new ArrayList<Jugador>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionesJugadorUno, jugadorUno);
        var respuestaJugadorDos = new Respuesta(opcionesJugadorDos, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(2, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void PreguntaVerdaderoFalsoConPenalidadOtorgaPuntosCorrectamente() {
        /*
            Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente, y resta
            correctamente puntos a los jugadores que respondieron en forma incorrecta
        */

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");

        var opcion1 = new OpcionDefault("Verdadero", true);
        var opcion2 = new OpcionDefault("Falso", false);

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

        var jugadores = new ArrayList<Jugador>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionesCorrectas, jugadorUno);
        var respuestaJugadorDos = new Respuesta(opcionesIncorrectas, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(1, jugadorUno.obtenerPuntaje());
        assertEquals(-1, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void PreguntaMultipleChoiceClasicoOtorgaPuntosALosJugadoresCorrectamente() {
        /*
            Una Pregunta de Multiple Choice clasico recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente
        */

        var jugadorUno = new Jugador("Pepe");
        var jugadorDos = new Jugador("Pepin");
        var jugadorTres = new Jugador("Pepon");

        var opcionCorrecta1 = new OpcionDefault("Celeste", true);
        var opcionCorrecta2 = new OpcionDefault("Blanco", true);
        var opcionIncorrecta = new OpcionDefault("Marron", false);
        var opcionCorrecta3 = new OpcionDefault("Amarillo", true);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionCorrecta2);
        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta3);

        var builder = new PreguntasBuilder();
        var pregunta = builder.crearMultipleChoice("Colón llegó a América en el siglo XV.", opciones).get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcionCorrecta1);
        opcionesJugadorUno.add(opcionCorrecta2);
        opcionesJugadorUno.add(opcionCorrecta3);

        var opcionesJugadorDos = new ArrayList<Opcion>();
        opcionesJugadorDos.add(opcionCorrecta1);
        opcionesJugadorDos.add(opcionCorrecta2);

        var opcionesJugadorTres = new ArrayList<Opcion>();
        opcionesJugadorTres.add(opcionCorrecta1);
        opcionesJugadorTres.add(opcionCorrecta2);
        opcionesJugadorTres.add(opcionIncorrecta);

        var jugadores = new ArrayList<Jugador>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionesJugadorUno, jugadorUno);
        var respuestaJugadorDos = new Respuesta(opcionesJugadorDos, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(3, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
        assertEquals(0, jugadorTres.obtenerPuntaje());
    }
}