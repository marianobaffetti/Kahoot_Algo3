package edu.fiuba.algo3.modelo;

public class Resultado {
    private final Jugador jugador;
    private double puntos;

    public Resultado(double puntos, Jugador jugador) {
        this.puntos = puntos;
        this.jugador = jugador;
    }

    public Boolean esCorrecto() {
        return this.puntos > 0;
    }

    public void actualizar() {
        this.jugador.actualizarPuntaje(this.puntos);
    }

    public double obtenerPuntaje() {
        return this.puntos;
    }

    public void actualizarPuntaje(double puntos) {
        this.puntos = puntos;
    }
}
