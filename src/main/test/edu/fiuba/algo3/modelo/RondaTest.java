package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RondaTest {
    /*@Test
    public void RondaSeInicializaConPreguntasYJugadores() {
        List<Opcion> opciones = List.of(
            new OpcionDefault("Opcion 1", true),
            new OpcionDefault("Opcion 2", false)
        );

        var ronda = new Ronda(
            new VerdaderoFalso("La Opcion 1 es falsa.", opciones),
            List.of(new Jugador("Pepe", new ArrayList<>()))
        );

        Assertions.assertEquals(1, ronda.obtenerJugadores().size());
        Assertions.assertEquals(2, ronda.obtenerPregunta().obtenerOpciones().size());
    }*/
}
