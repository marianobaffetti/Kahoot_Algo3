package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void actualizarPuntaje(int puntos) {
        this.puntaje+=puntos;
    }
}