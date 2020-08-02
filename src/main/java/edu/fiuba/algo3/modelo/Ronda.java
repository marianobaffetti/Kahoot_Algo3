package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private final Pregunta pregunta;
    private final List<Respuesta> respuestas;

    public Ronda(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
    }

    public void finalizar() {
        var resultados = this.pregunta.obtenerResultados(respuestas);
        resultados.forEach(resultado -> resultado.actualizar());
    }
}


