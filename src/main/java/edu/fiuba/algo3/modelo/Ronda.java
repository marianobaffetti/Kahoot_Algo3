package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ronda {
    private final Pregunta pregunta;
    private final List<Respuesta> respuestas;
    private final List<Jugador> jugadores;
    private final Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;

    public Ronda(Pregunta pregunta, List<Jugador> jugadores) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
        this.jugadores = jugadores;
        this.iteradorJugadores = jugadores.iterator();
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
        this.siguienteTurno();
    }

    public void finalizar() {
        var resultados = this.pregunta.obtenerResultados(respuestas);
        this.aplicarExclusividad(resultados);
        resultados.forEach(resultado -> resultado.actualizar());
        Kahoot.getInstance().siguienteRonda();
    }

    private void aplicarExclusividad(List<Resultado> resultados) {
        new ExclusividadDePuntaje(resultados, this.jugadores).invoke();
    }

    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        this.pregunta.asignarMultiplicadorX2AJugador(jugador);
    }

    public void asignarMultiplicadorX3AJugador(Jugador jugador) {
        this.pregunta.asignarMultiplicadorX3AJugador(jugador);
    }

    public List<Jugador> obtenerJugadores() {
        return this.jugadores;
    }

    public Pregunta obtenerPregunta() {
        return this.pregunta;
    }

    public void usarExclusividad(Jugador jugador) {
        this.pregunta.usarExclusividad(jugador);
    }

    public void iniciar() {
        siguienteTurno();
    }

    public Jugador jugadorActual() {
        return this.jugadorActual;
    }

    private void siguienteTurno() {
        if (this.iteradorJugadores.hasNext())
            this.jugadorActual = this.iteradorJugadores.next();
        else
            this.finalizar();
    }

    public Jugador obtenerJugadorActual() {
        return this.jugadorActual;
    }
}