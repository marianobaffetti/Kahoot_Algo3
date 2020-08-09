package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private final Pregunta pregunta;
    private final List<Respuesta> respuestas;
    private final List<Jugador> jugadores;

    public Ronda(Pregunta pregunta, List<Jugador> jugadores) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
        this.jugadores = jugadores;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
    }

    public void finalizar() {
        var resultados = this.pregunta.obtenerResultados(respuestas);
        resultados.forEach(resultado -> resultado.actualizar());
    }

    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        this.pregunta.asignarMultiplicadorX2AJugador(jugador);
    }

    public void asignarMultiplicadorX3AJugador(Jugador jugador) {
        this.pregunta.asignarMultiplicadorX3AJugador(jugador);
    }
}


