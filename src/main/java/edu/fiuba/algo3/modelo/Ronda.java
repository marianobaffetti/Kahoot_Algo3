package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {
    private final VerdaderoFalso pregunta;
    private final ArrayList<RespuestaVerdaderoFalso> respuestas;

    public Ronda(VerdaderoFalso pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuesta(RespuestaVerdaderoFalso respuesta) {
        this.respuestas.add(respuesta);
    }

    public void finalizar() {
        var resultados = this.pregunta.obtenerResultados(respuestas);
        resultados.forEach( resultado -> resultado.actualizar());
    }
}
