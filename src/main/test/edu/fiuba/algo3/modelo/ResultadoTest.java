package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultadoTest {
    @Test
    public void resultadoEsCorrectoSiElPuntajeEsPositivo(){
        var resultado = new Resultado(1, new Jugador("pepe"));

        Assertions.assertTrue(resultado.esCorrecto());
    }
}
