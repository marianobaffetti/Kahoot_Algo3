package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_3_Test{
    @Test
    public void xxxxxxx() {

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

}