package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ResultadoTest {
    @Test
    public void resultadoEsCorrectoSiElPuntajeEsPositivo() {
        var resultado = new Resultado(1, new Jugador("pepe", new ArrayList<EstrategiaDeMultiplicacion>()));

        Assertions.assertTrue(resultado.esCorrecto());
    }
}
