package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Entrega_final_Test {
    @BeforeEach
    public void reiniciarKahoot() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field kahoot = Kahoot.class.getDeclaredField("instance");
        kahoot.setAccessible(true);
        kahoot.set(null, null);
    }

    @Test
    public void kahootAsignaGanadoresAlfinalizar() {
        var kahoot = Kahoot.getInstance();
        kahoot.agregarJugador("Pepe");
        kahoot.agregarJugador("Pepon");
        kahoot.agregarJugador("Pepin");

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

        kahoot.agregarPreguntas(List.of(pregunta));
        kahoot.iniciarRondas();

        //se agrega respuesta de primer jugador (pepe)
        var Pepe = kahoot.obtenerJugadorActual();
        kahoot.agregarRespuesta(opcionCorrecta);

        //se agrega respuesta de primer jugador (pepon)
        var Pepon = kahoot.obtenerJugadorActual();
        kahoot.agregarRespuesta(opcionCorrecta);

        //se agrega respuesta d esegundo jugador (pepin)
        var Pepin = kahoot.obtenerJugadorActual();
        kahoot.agregarRespuesta(opcionIncorrecta);

        Assertions.assertTrue(kahoot.obtenerGanadores().contains(Pepe));
        Assertions.assertTrue(kahoot.obtenerGanadores().contains(Pepon));
        Assertions.assertFalse(kahoot.obtenerGanadores().contains(Pepin));
    }
}