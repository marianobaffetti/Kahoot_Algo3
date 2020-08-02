package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_2_Test {
    @Test
    public void PreguntaMultipleChoiceConPuntajePenalidadOtorgaPuntosALosJugadoresCorrectamente() {
        /*
            Una Pregunta de Multiple Choice con penalidad recibe una lista de respuestas y
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
                .conPenalidad()
                .get();

        var opcionesJugadorUno = new ArrayList<Opcion>();
        opcionesJugadorUno.add(opcionCorrecta1);
        opcionesJugadorUno.add(opcionCorrecta2);

        var opcionesJugadorDos = new ArrayList<Opcion>();
        opcionesJugadorDos.add(opcionIncorrecta);


        var ronda = new Ronda(pregunta);

        var respuestaJugadorUno = new RespuestaVerdaderoFalso(opcionesJugadorUno, jugadorUno);
        var respuestaJugadorDos = new RespuestaVerdaderoFalso(opcionesJugadorDos, jugadorDos);

        ronda.agregarRespuesta(respuestaJugadorUno);
        ronda.agregarRespuesta(respuestaJugadorDos);

        ronda.finalizar();

        assertEquals(2, jugadorUno.obtenerPuntaje());
        assertEquals(-1, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void PreguntaOrderedChoiceSeCreaYAsignaPuntosCorrectamente() {
        /*
            Una Pregunta de Orderer Choice puede crearse indicándole cuales son
            las opciones correctas
        */

        var opcion1 = new OpcionOrderedChoice("git add", 1);
        var opcion2 = new OpcionOrderedChoice("git commit", 2);
        var opcion3 = new OpcionOrderedChoice("git push", 3);

        var opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        var builder = new PreguntasBuilder();
        var pregunta = builder
                .crearOrderedChoice("Cuál es el orden correcto para agregar cambios a git.", opciones)
                .get();

        // Opciones elegidas por el primer jugador
        var elegida1Pepe = new OpcionOrderedChoice("git add", 1);
        var elegida2Pepe = new OpcionOrderedChoice("git commit", 2);
        var elegida3Pepe = new OpcionOrderedChoice("git push", 3);

        var opcionesPepe = new ArrayList<Opcion>();
        opcionesPepe.add(elegida1Pepe);
        opcionesPepe.add(elegida2Pepe);
        opcionesPepe.add(elegida3Pepe);

        // Opciones elegidas por el segundo jugador
        var elegida1Pepin = new OpcionOrderedChoice("git add", 2);
        var elegida2Pepin = new OpcionOrderedChoice("git commit", 1);
        var elegida3Pepin = new OpcionOrderedChoice("git push", 3);

        var opcionesPepin = new ArrayList<Opcion>();
        opcionesPepin.add(elegida1Pepin);
        opcionesPepin.add(elegida2Pepin);
        opcionesPepin.add(elegida3Pepin);

        Jugador pepe = new Jugador("Pepe");
        var respuestaPepe = new RespuestaOrderedChoice(opcionesPepe, pepe);
        Jugador pepin = new Jugador("Pepin");
        var respuestaPepin = new RespuestaOrderedChoice(opcionesPepin, pepin);

        var ronda = new Ronda(pregunta);

        ronda.agregarRespuesta(respuestaPepe);
        ronda.agregarRespuesta(respuestaPepin);

        ronda.finalizar();

        assertEquals(3, pepe.obtenerPuntaje());
        assertEquals(0, pepin.obtenerPuntaje());
    }
}

