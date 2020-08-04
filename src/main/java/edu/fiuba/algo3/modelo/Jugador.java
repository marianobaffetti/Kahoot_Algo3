package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private int puntaje;
    private EstrategiaDeMultiplicacion multiplicador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.multiplicador = new MultiplicadorDefault();
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void actualizarPuntaje(long puntos) {
        this.puntaje += this.multiplicador.multiplicar(puntos);
    }

    public void finalizarRonda() {
        this.multiplicador = new MultiplicadorDefault();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void usarMultiplicador(EstrategiaDeMultiplicacion multiplicador) {
        this.multiplicador = multiplicador;
    }
}
