package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_3_Test{
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


   /* @Test
    public void cuandoElUltimoJugadorRespondeSePasaALaSiguienteRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
        List < Jugador > jugadores = List.of(pepe);
        Ronda ronda1 = new Ronda(new VerdaderoFalso("1", opciones), jugadores);
        Ronda ronda2 = new Ronda(new VerdaderoFalso("2", opciones), jugadores);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarRondas(List.of(ronda1, ronda2));
        kahoot.agregarJugadores(List.of(pepe));
        kahoot.iniciar();
        kahoot.agregarRespuesta(new Respuesta(opciones, pepe));

        Assertions.assertEquals(1, Kahoot.getInstance().obtenerNumeroDeRonda());
    }*/

    /*@Test
    public void cuandoElUltimoJugadorRespondeSePasaALaSiguienteRonda() {
        List<Opcion> opciones = List.of(new OpcionDefault("", true));
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
        List < Jugador > jugadores = List.of(pepe);
        Ronda ronda1 = new Ronda(new VerdaderoFalso("1", opciones), jugadores);
        Ronda ronda2 = new Ronda(new VerdaderoFalso("2", opciones), jugadores);

        var kahoot = Kahoot.getInstance();
        kahoot.agregarRondas(List.of(ronda1, ronda2));
        kahoot.agregarJugadores(List.of(pepe));
        kahoot.iniciar();

        Assertions.assertEquals(1, pepe.obtenerPuntaje());

        ronda.agregarRespuesta(new Respuesta(opciones, pepe));

        Assertions.assertEquals(1, Kahoot.getInstance().obtenerNumeroDeRonda());
    }*/


    /*TODO test para kahoot.iniciar*/

}