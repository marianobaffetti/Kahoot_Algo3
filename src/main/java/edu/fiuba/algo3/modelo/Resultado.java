package edu.fiuba.algo3.modelo;

public class Resultado {
    private final Jugador jugador;
    private final long puntos;

    public Resultado(long puntos, Jugador jugador) {
        this.puntos = puntos;
        this.jugador = jugador;
    }

    public Boolean esCorrecto() {
        return this.puntos > 0;
    }

    public void actualizar() {
        this.jugador.actualizarPuntaje(this.puntos);
        this.jugador.finalizarRonda();
    }

    public long obtenerPuntaje() {
        return this.puntos;
    }
}
