package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega_0_Test {
    @Test
    public void PreguntaVerdaderoFalsoClasicoSeCreaYSeVerificaRespuesta() {
        // Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta
        // correcta

        // Respuesta correcta
        var pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", true);
        var respuestaCorrecta = true;
        var resultado = pregunta.obtenerResultado(respuestaCorrecta);

        Assertions.assertTrue(resultado.esCorrecto());

        // Respuesta incorrecta

        pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", false);
        respuestaCorrecta = false;
        resultado = pregunta.obtenerResultado(respuestaCorrecta);

        Assertions.assertFalse(resultado.esCorrecto());
    }

    @Test
    public void PreguntaVerdaderoFalsoClasicoRecibeMultiplesRespuestasYAsignaPuntosAJugadores() {
        // Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        // correctamente puntos a los jugadores que respondieron correctamente

        var pregunta = new VerdaderoFalso("Colón llegó a América en el siglo XV.", true);
        var respuestaCorrecta = true;
        var resultado = pregunta.obtenerResultado(respuestaCorrecta);

        Assertions.assertTrue(resultado.esCorrecto());
    }

}