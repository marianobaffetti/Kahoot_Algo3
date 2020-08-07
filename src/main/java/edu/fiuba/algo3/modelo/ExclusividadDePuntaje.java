package edu.fiuba.algo3.modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExclusividadDePuntaje {
    private final List<Jugador> jugadores;
    private List<Resultado> resultados;

    public ExclusividadDePuntaje(List<Resultado> resultados, List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.resultados = resultados;
    }

    public void invoke() {
        long cantidadDeExclusividadesActivas = obtenerCantidadDeExclusividadesActivas();

        if (cantidadDeExclusividadesActivas > 0) {
            Double puntajeMax = obtenerPuntajeMaximo(resultados);
            var jugadoresConPuntajeMaximo = resultados
                    .stream()
                    .filter(resultado -> resultado.obtenerPuntaje() == puntajeMax)
                    .collect(Collectors.toList());

            if (jugadoresConPuntajeMaximo.size() > 1) {
                resultados.stream().forEach(resultado -> resultado.actualizarPuntaje(0));
            } else {
                jugadoresConPuntajeMaximo
                        .stream()
                        .findFirst()
                        .get()
                        .actualizarPuntaje(Math.pow(2, cantidadDeExclusividadesActivas) * puntajeMax);

                resultados.forEach(resultado -> {
                    if (resultado.obtenerPuntaje() < puntajeMax) {
                        resultado.actualizarPuntaje(0);
                    }
                });
            }
        }
    }

    private long obtenerCantidadDeExclusividadesActivas() {
        return this.jugadores
                .stream()
                .filter(jugador -> jugador.activoExclusividad())
                .count();
    }

    private Double obtenerPuntajeMaximo(List<Resultado> resultados) {
        return resultados.stream()
                .map(resultado -> resultado.obtenerPuntaje())
                .max(Comparator.comparing(a -> a))
                .get();
    }
}
