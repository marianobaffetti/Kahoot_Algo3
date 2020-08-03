package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RespuestaTest {
    @Test
    public void respuestaSeCreaConJugadorYOpciones() {
        new OpcionOrderedChoice("git add", 1);
        new OpcionOrderedChoice("git add", 1);
        List<Opcion> opciones = List.of(
            new OpcionOrderedChoice("git add", 1),
            new OpcionOrderedChoice("git commit", 2)
        );
        var pepe = new Jugador("Pepe");

        Respuesta respuesta = new Respuesta(opciones, pepe);

        Assertions.assertEquals("Pepe", respuesta.obtenerJugador().obtenerNombre());
    }

    @Test
    public void coincideConOpcionDevuelveTrueSiAlgunaDeLasOpcionesElegidasCoincideConLaSuministrada() {
        new OpcionOrderedChoice("git add", 1);
        new OpcionOrderedChoice("git add", 1);
        List<Opcion> opciones = List.of(
                new OpcionOrderedChoice("git add", 1),
                new OpcionOrderedChoice("git commit", 2)
        );
        var pepe = new Jugador("Pepe");
        Respuesta respuesta = new Respuesta(opciones, pepe);

        Assertions.assertTrue(respuesta.concideCon(new OpcionOrderedChoice("git add", 1) ));
    }
}
