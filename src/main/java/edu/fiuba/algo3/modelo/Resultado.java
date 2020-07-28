package edu.fiuba.algo3.modelo;

public class Resultado {
    private Jugador jugador;
    private int puntos;

    public Resultado(int puntos, Jugador jugador) {
        this.puntos = puntos;
        this.jugador = jugador;
    }

    public Boolean esCorrecto() {
        return this.puntos > 0;
    }

    public void actualizar() {
        this.jugador.actualizarPuntaje(this.puntos);
    }

    public int obtenerPuntaje() {
        return this.puntos;
    }
}
