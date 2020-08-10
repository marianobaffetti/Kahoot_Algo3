package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_2_Test {
    @Test
    public void PreguntaMultipleChoiceConPenalidadOtorgaPuntosALosJugadoresCorrectamente() {
        /*
            Una Pregunta de Multiple Choice con penalidad recibe una lista de respuestas y
            asigna correctamente puntos a los jugadores según las opciones correctas que hayan
            respondido
        */

        var jugadorUno = new Jugador("Pepe", new ArrayList<EstrategiaDeMultiplicacion>());
        var jugadorDos = new Jugador("Pepin", new ArrayList<EstrategiaDeMultiplicacion>());

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

        Jugador pepe = new Jugador("Pepe", new ArrayList<EstrategiaDeMultiplicacion>());
        var respuestaPepe = new Respuesta(opcionesPepe, pepe);
        Jugador pepin = new Jugador("Pepin", new ArrayList<EstrategiaDeMultiplicacion>());
        var respuestaPepin = new Respuesta(opcionesPepin, pepin);

        var jugadores = new ArrayList<Jugador>();
        jugadores.add(pepe);
        jugadores.add(pepin);

        var ronda = new Ronda(pregunta, jugadores);

        ronda.agregarRespuesta(respuestaPepe);
        ronda.agregarRespuesta(respuestaPepin);

        ronda.finalizar();

        assertEquals(3, pepe.obtenerPuntaje());
        assertEquals(0, pepin.obtenerPuntaje());
    }

    @Test
    public void jugadorUsaMultiplicadorX3YSeAsignanPuntosCorrectamente() {
        /*
            Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente, y resta
            correctamente puntos a los jugadores que respondieron en forma incorrecta. Además multiplica
            puntos correspondientes.
        */

        var pepe = new Jugador("Pepe", List.of(new MultiplicadorX3()));

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
        jugadores.add(pepe);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionesCorrectas, pepe);

        ronda.asignarMultiplicadorX3AJugador(pepe);
        ronda.agregarRespuesta(respuestaJugadorUno);

        ronda.finalizar();

        assertEquals(3, pepe.obtenerPuntaje());
    }

    @Test
    public void jugadorUsaMultiplicadorX2YSeAsignanPuntosCorrectamente() {
        /*
            Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas y asigna
            correctamente puntos a los jugadores que respondieron correctamente, y resta
            correctamente puntos a los jugadores que respondieron en forma incorrecta. Además multiplica
            puntos correspondientes.
        */

        var pepe = new Jugador("Pepe", List.of(new MultiplicadorX2()));

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
        jugadores.add(pepe);

        var ronda = new Ronda(pregunta, jugadores);

        var respuestaJugadorUno = new Respuesta(opcionesCorrectas, pepe);

        ronda.asignarMultiplicadorX2AJugador(pepe);
        ronda.agregarRespuesta(respuestaJugadorUno);

        ronda.finalizar();

        assertEquals(2, pepe.obtenerPuntaje());
    }

    @Test
    public void PreguntaGroupChoiceSeCreaYAsignaPuntosCorrectamente() {
        /*
            Una Pregunta de Group Choice puede crearse indicándole cuales son
            las opciones correctas
        */

        List<Opcion> opciones = List.of(
            new OpcionGroupChoice("Argentina", "America"),
            new OpcionGroupChoice("Canada", "America"),
            new OpcionGroupChoice("España", "Europa"),
            new OpcionGroupChoice("Francia", "Europa")
        );

        var builder = new PreguntasBuilder();
        var pregunta = builder
                .crearGroupChoice("Agrupar países por continente", opciones)
                .get();

        // Opciones elegidas por el primer jugador

        var elegida1Pepe = new OpcionGroupChoice("Argentina", "America");
        var elegida2Pepe = new OpcionGroupChoice("Canada", "America");
        var elegida3Pepe = new OpcionGroupChoice("España", "Europa");
        var elegida4Pepe = new OpcionGroupChoice("Francia", "Europa");

        var opcionesPepe = new ArrayList<Opcion>();
        opcionesPepe.add(elegida1Pepe);
        opcionesPepe.add(elegida2Pepe);
        opcionesPepe.add(elegida3Pepe);
        opcionesPepe.add(elegida4Pepe);

        // Opciones elegidas por el segundo jugador
        var elegida1Pepin = new OpcionGroupChoice("Argentina", "America");
        var elegida2Pepin = new OpcionGroupChoice("Canada", "Europa");
        var elegida3Pepin = new OpcionGroupChoice("España", "America");
        var elegida4Pepin = new OpcionGroupChoice("Francia", "Europa");

        var opcionesPepin = new ArrayList<Opcion>();
        opcionesPepin.add(elegida1Pepin);
        opcionesPepin.add(elegida2Pepin);
        opcionesPepin.add(elegida3Pepin);
        opcionesPepin.add(elegida4Pepin);

        Jugador pepe = new Jugador("Pepe", new ArrayList<EstrategiaDeMultiplicacion>());
        var respuestaPepe = new Respuesta(opcionesPepe, pepe);
        Jugador pepin = new Jugador("Pepin", new ArrayList<EstrategiaDeMultiplicacion>());
        var respuestaPepin = new Respuesta(opcionesPepin, pepin);

        var ronda = new Ronda(pregunta, List.of(pepe, pepin));

        ronda.agregarRespuesta(respuestaPepe);
        ronda.agregarRespuesta(respuestaPepin);

        ronda.finalizar();

        assertEquals(4, pepe.obtenerPuntaje());
        assertEquals(0, pepin.obtenerPuntaje());
    }
}

