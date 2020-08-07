package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSeEncuentraElMultiplicadorError;
import edu.fiuba.algo3.modelo.Excepciones.YaHayUnMultiplicadorEnUsoError;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JugadorTest {
    @Test
    public void jugadorSeCreaConNombre() {
        var nombre = "Pepe";
        var jugador = new Jugador(nombre, List.of(new MultiplicadorX2()));

        Assertions.assertEquals(nombre, jugador.obtenerNombre());
    }

    @Test
    public void jugadorSeCreaConPuntajeCero() {
        var nombre = "Pepe";
        var jugador = new Jugador(nombre, List.of(new MultiplicadorX2()));

        Assertions.assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void jugadorActualizarPuntajeSumaPuntosAlosQueElJugadorTiene() {
        var nombre = "Pepe";
        var jugador = new Jugador(nombre, List.of(new MultiplicadorX2()));

        jugador.actualizarPuntaje(1);

        Assertions.assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void actualizaPuntajeCorrectamenteCuandoSeUtilizaMultiplicadorPorDos() {
        Jugador pepe = new Jugador("Pepe", List.of(new MultiplicadorX2()));
        pepe.usarMultiplicador("MULTIPLICADOR_X_2");

        pepe.actualizarPuntaje(1);

        Assertions.assertEquals(2, pepe.obtenerPuntaje());
    }


    @Test
    public void SeLanzaYaHayUnMultiplicadorEnUsoErrorSiElJugadorYaEstaUsandoUnMultiplicador() {
        Jugador pepe = new Jugador("Pepe", List.of(new MultiplicadorX2()));
        String nombreDeMultiplcador = "MULTIPLICADOR_X_2";

        pepe.usarMultiplicador(nombreDeMultiplcador);

        Assertions.assertThrows(YaHayUnMultiplicadorEnUsoError.class, () -> pepe.usarMultiplicador(nombreDeMultiplcador));
    }

    @Test
    public void SeLanzaNoSeEncuentraElMultiplicadorErrorSiElNombreNoCoincideConNinguno() {
        Jugador pepe = new Jugador("Pepe", List.of(new MultiplicadorX2()));
        String nombreDeMultiplcador = "MULTIPLICADOR_XXXX";

        Assertions.assertThrows(NoSeEncuentraElMultiplicadorError.class, () -> pepe.usarMultiplicador(nombreDeMultiplcador));
    }

    @Test
    public void actualizaPuntajeCorrectamenteCuandoSeUtilizaMultiplicadorPorTres() {
        Jugador pepe = new Jugador("Pepe", List.of(new MultiplicadorX3()));
        String nombreDeMultiplcador = "MULTIPLICADOR_X_3";

        pepe.usarMultiplicador(nombreDeMultiplcador);
        pepe.actualizarPuntaje(1);

        Assertions.assertEquals(3, pepe.obtenerPuntaje());
    }

}
