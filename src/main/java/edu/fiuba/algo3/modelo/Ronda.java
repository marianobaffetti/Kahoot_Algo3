package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        this.aplicarExclusividad(resultados);
        resultados.forEach(resultado -> resultado.actualizar());
    }

    private void aplicarExclusividad(List<Resultado> resultados) {
        long cantidadDeExclusividadesActivas = this.jugadores
                .stream()
                .filter(jugador -> jugador.activoExclusividad())
                .count();

        if (cantidadDeExclusividadesActivas > 0) {
            var puntajeMax = resultados.stream()
                    .map(resultado -> resultado.obtenerPuntaje())
                    .max(Comparator.comparing(a->a))
                    .get();

            var jugadoresConPuntajeMaximo = resultados.stream()
                    .filter(resultado -> resultado.obtenerPuntaje() == puntajeMax).collect(Collectors.toList());

            if (jugadoresConPuntajeMaximo.size() > 1){
                resultados.stream().forEach(resultado -> resultado.actualizarPuntaje(0));
            } else {
                jugadoresConPuntajeMaximo
                        .stream()
                        .findFirst()
                        .get()
                        .actualizarPuntaje(Math.pow(2, cantidadDeExclusividadesActivas) * puntajeMax);
                resultados.forEach(resultado ->
                        {
                            if (resultado.obtenerPuntaje() < puntajeMax){
                                resultado.actualizarPuntaje(0);
                            }
                        });
            }
        }
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
}