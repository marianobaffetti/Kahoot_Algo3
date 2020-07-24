package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso {
    private final boolean respuestaCorrecta;

    public VerdaderoFalso(String pregunta, boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public ArrayList<Resultado> obtenerResultados(ArrayList<RespuestaVerdaderoFalso> respuestas) {
        var resultados = new ArrayList<Resultado>();
        respuestas.forEach(respuesta -> resultados.add(this.obtenerResultado(respuesta)));
        return resultados;
    }

    public Resultado obtenerResultado (RespuestaVerdaderoFalso respuesta) {
        var puntos = 0;
        if (respuesta.obtener() == respuestaCorrecta) {
            puntos = 1;
        }
        return new Resultado(puntos, respuesta.obtenerJugador());
    }
}
