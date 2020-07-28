package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {
    private final IPregunta pregunta;
    private final ArrayList<IRespuesta> respuestas;

    public Ronda(IPregunta pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuesta(IRespuesta respuesta) {
        this.respuestas.add(respuesta);
    }

    public void finalizar() {
        var resultados = this.pregunta.obtenerResultados(respuestas);
        resultados.forEach( resultado -> resultado.actualizar());
    }
}


